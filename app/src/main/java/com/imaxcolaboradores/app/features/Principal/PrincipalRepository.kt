package com.imaxcolaboradores.app.features.Principal

import com.imaxcolaboradores.app.features.login.firestore.FirestoreColaboradores


class PrincipalRepository  {

    private var newPrincipalRepository : PrincipalRepository? = null
    private var firestoreColaboradores  = FirestoreColaboradores().getInstance()

    fun getInstance() : PrincipalRepository{
        if(newPrincipalRepository == null){
            newPrincipalRepository = PrincipalRepository()
        }
        return newPrincipalRepository!!
    }




}