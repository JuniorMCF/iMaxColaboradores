package com.imaxcolaboradores.app.models

import com.google.firebase.firestore.QueryDocumentSnapshot
import java.io.Serializable

class SolicitudesDisponibles :Serializable {
    var tipo: String?=null// 0 : domicilio 1: agencias  2: con recojo 3: sin recojo
    var movilidad: String?=null
    var lugar: String?=null
    var tiempo: String?=null

    var document: QueryDocumentSnapshot?=null
}