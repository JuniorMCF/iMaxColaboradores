package com.imaxcolaboradores.app.models

import android.os.Parcelable
import com.google.firebase.firestore.QueryDocumentSnapshot
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
class SolicitudesDisponibles : Serializable {
    var tipo: String?=null// 0 : domicilio 1: agencias  2: con recojo 3: sin recojo
    var lugar: String?=null
    var tiempo: String?=null
    var vehiculo : String?=null  // guarda el tipo de vehiculo  (C/CARRETA O NO )
    var estado:String?=null
    var data : Any?=null //document.toObject(Class::class.java)
    var idDocument : String?= null

}