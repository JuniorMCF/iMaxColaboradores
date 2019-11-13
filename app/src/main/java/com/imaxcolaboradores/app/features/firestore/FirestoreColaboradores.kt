package com.imaxcolaboradores.app.features.login.firestore

import com.google.firebase.firestore.FirebaseFirestore

class FirestoreColaboradores {

    private var newFirestoreInstance : FirebaseFirestore? = null

    fun getInstance() : FirebaseFirestore{
        if(newFirestoreInstance == null){
            newFirestoreInstance = FirebaseFirestore.getInstance()
        }
        return newFirestoreInstance!!
    }



}