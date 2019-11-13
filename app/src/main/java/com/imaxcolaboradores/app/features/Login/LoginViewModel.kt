package com.imaxcolaboradores.app.features.Login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imaxcolaboradores.app.models.LoginResponse

class LoginViewModel : ViewModel() {
    val loginSuccessful = MutableLiveData<Any>()
    val loginError = MutableLiveData<Any>()
    val loginUserError = MutableLiveData<Any>()
    val loginPasswordError = MutableLiveData<Any>()



    fun login (username : String, password : String){

        if(password.isEmpty()){
            val loginResponse = LoginResponse("Ingrese Password")
            loginPasswordError.postValue(loginResponse)
        }

        if(username.isEmpty()){
            val loginResponse = LoginResponse("Ingrese Usuario")
            loginUserError.postValue(loginResponse)
        }

        if(password.isNotEmpty() && username.isNotEmpty()){
            val loginRepository = LoginRepository().getInstance()
            loginRepository.loginUser(username,password,loginSuccessful,loginError,loginUserError, loginPasswordError )
        }




    }



}