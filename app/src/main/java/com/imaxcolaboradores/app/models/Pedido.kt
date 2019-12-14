package com.imaxcolaboradores.app.models

import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

class Pedido {

    var tipo:String?=null       // 0 : domicilio
                                // 1 : agencia
                                // 2 : con recojo
                                // 3 : sin recojo
    var recoger:String?=null
    var tiempo: String?=null
    var document: QueryDocumentSnapshot?= null


}