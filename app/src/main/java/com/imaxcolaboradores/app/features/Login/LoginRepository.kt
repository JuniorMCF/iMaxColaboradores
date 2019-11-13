package com.imaxcolaboradores.app.features.Login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.imaxcolaboradores.app.features.login.firestore.FirestoreColaboradores
import com.imaxcolaboradores.app.models.LoginResponse

class LoginRepository {

    private var newLoginRepositoryInstance : LoginRepository? = null
    private var firestoreClient  = FirestoreColaboradores().getInstance()

    fun getInstance() : LoginRepository{
        if(newLoginRepositoryInstance == null){
            newLoginRepositoryInstance = LoginRepository()
        }

        return newLoginRepositoryInstance!!
    }


    fun loginUser(username : String, password : String, loginSuccessful : MutableLiveData<Any>, loginError : MutableLiveData<Any>,
                  loginUserError : MutableLiveData<Any>, loginPasswordError : MutableLiveData<Any>){

        firestoreClient.collection("colaboradores").whereEqualTo("username",username).get()
            .addOnSuccessListener { document ->
                if(document != null){
                    if(document.size() == 0){
                        val loginResponse = LoginResponse("error usuario no existe")
                        loginUserError.postValue(loginResponse)
                    }else{
                        if(password == document.documents[0]["password"]){
                            val loginResponse = LoginResponse("Inicio de sesion valida")
                            loginSuccessful.postValue(loginResponse)
                        }else{
                            val loginResponse = LoginResponse("Contraseña incorrecta")
                            loginPasswordError.postValue(loginResponse)
                        }
                    }
                }else{


                }

            }.addOnFailureListener { error ->
                Log.d("aca","error $error")
            }


    }

}