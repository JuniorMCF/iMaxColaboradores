package com.imaxclientes.app.models

import com.google.android.gms.maps.model.LatLng
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class PedidoCargo:Serializable {

    var codigoServicio = ""
    var datosCliente= ""
    var tipoServicio= ""
    var recojo : Boolean? = null
    var tipoTransporte= ""
    var estadoServicio= ""
    var recogerEn= ""
    var origen: LatLng?=null
    var referenciaRecoger1= ""
    var urlFoto= ""
    var paqueteCargoSinRecojo = ArrayList<PaqueteCargo>()
    var estadoDeuda:Boolean?=null
    var montoDeuda= ""
    var puntosAcopio:LatLng?=null
    var distancia1= ""
    var distancia2= ""
    var costoServicio= ""
    var metodoPago= ""
    var tiempoEstimado= ""
    var datosColaborador= ""
    var fechaGenerada: Date?=null
    var fechaAceptado: Date?=null
    var fechaRecogido: Date?=null
    var fechaEntregadoAcopio: Date?=null
    var fechaEnviado: Date?=null
    var permisoEntrega:Boolean?=null

    constructor()
}