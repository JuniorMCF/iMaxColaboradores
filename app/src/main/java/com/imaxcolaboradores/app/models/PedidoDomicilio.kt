package com.imaxclientes.app.models

import com.google.android.gms.maps.model.LatLng
import java.io.Serializable
import java.util.*

class PedidoDomicilio:Serializable {
    var codigoServicio = ""
    var datosCliente:String?=null //datos del cliente
    var tipoServicio = ""  //domicilio
    var tipoTransporte= ""         //motorizado o furgon
    var estadoServicio= ""     //0(en espera),1(aceptado),2-3-4(en Ruta),5(entregado),6(cancelado)
    var recogerEn= ""
    var origen: LatLng?=null     //{}
    var referenciaRecoger1= ""
    var referenciaRecoger2= ""
    var urlFoto= ""
    var dejarEn= ""
    var destino:LatLng?=null //{}
    var referenciaDejar= ""
    var nombreContacto= ""
    var numeroContacto= ""
    var distancia1= ""
    var distancia2= ""
    var costoServicio= ""
    var metodoPago= "" //efectivo
    var tiempoEstimado= ""
    var pagoEnDestino= false // true
    var datosColaborador:String?=null  //{}
    var fechaGenerada:Date?=null
    var fechaAceptado:Date?=null
    var fechaRecogido:Date?=null
    var fechaEntregado:Date?=null
    var urlFirma= ""

}