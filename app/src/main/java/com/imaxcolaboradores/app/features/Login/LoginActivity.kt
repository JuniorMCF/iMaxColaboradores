package com.imaxcolaboradores.app.features.Login

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.PrincipalActivity
import com.imaxcolaboradores.app.models.LoginResponse
import com.imaxcolaboradores.app.features.Principal.PrimerActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    //private val loginViewModel: LoginViewModel by viewModel()

    private var progress : ProgressDialog? = null
    private var database: FirebaseFirestore?=null

    var auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initProgress()
        //setObservers()
        setOnClick()

        //TODO("sin view model")

        if(auth.currentUser != null){
            val intent = Intent(this,PrimerActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setOnClick() {
        btnLogin.setOnClickListener {
            //progress!!.show()

            auth.signInWithEmailAndPassword(etUser.text.toString(), etPassword.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        //val user = auth.currentUser
                        val intent = Intent(this,PrimerActivity::class.java)
                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.d("aca","error ${task.exception!!.message}")
                        if(task.exception!!.message.equals("The email address is badly formatted.")){
                            Toast.makeText(baseContext, "Formato incorrecto de e-mail", Toast.LENGTH_SHORT).show()
                        }
                        if(task.exception!!.message.equals("There is no user record corresponding to this identifier. The user may have been deleted.")){
                            Toast.makeText(baseContext, "usuario no existe", Toast.LENGTH_SHORT).show()
                        }
                        if(task.exception!!.message.equals("The password is invalid or the user does not have a password.")){
                            Toast.makeText(baseContext, "password incorrecto", Toast.LENGTH_SHORT).show()
                        }

                    }
                    // ...
                }

            //loginViewModel.login(etUser.text.toString().trim(),etPassword.text.toString().trim())
        }
    }

    private fun initProgress() {
        progress = ProgressDialog(this)
        progress!!.setTitle("Login")
        progress!!.setMessage("Iniciando sesión ...")
        progress!!.setCancelable(false)

    }


    /*private fun setObservers(){
        loginViewModel.apply {
            loginSuccessful.observe(this@LoginActivity, loginSuccessfulObserver)
            loginError.observe(this@LoginActivity,loginErrorObserver)
            loginUserError.observe(this@LoginActivity,loginUserErrorObserver)
            loginPasswordError.observe(this@LoginActivity,loginPasswordErrorObserver)
        }
    }*/



    private val loginSuccessfulObserver = Observer<Any> {
        val res = it as LoginResponse
            //se ejecuta esto despues de 1500 ms
            progress!!.dismiss()

        startActivity(Intent(this@LoginActivity, PrincipalActivity::class.java))



    }

    private val loginErrorObserver = Observer<Any> {
        val response = it as LoginResponse
        progress!!.dismiss()
        Toast.makeText(this,response.message,Toast.LENGTH_LONG).show()
    }


    private val loginUserErrorObserver = Observer<Any> {
        progress!!.dismiss()
        val res = it as LoginResponse
        Toast.makeText(this, res.message, Toast.LENGTH_SHORT).show()
        etUser.error = res.message
        etUser.requestFocus()
    }



    private val loginPasswordErrorObserver = Observer<Any>{
        progress!!.dismiss()
        val res = it as LoginResponse
        etPassword.error = res.message
        etPassword.requestFocus()
    }




}
