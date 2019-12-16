package com.imaxclientes.app.models


import com.imaxcolaboradores.app.models.LatLng
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class PedidoAgencia :Serializable{
    var codigoServicio = ""
    var datosCliente = ""
    var tipoServicio= ""//agencias
    var tipoTransporte= ""//motorizado o furgon
    var estadoServicio= ""//0(en espera),1(aceptado),2-3-4(en Ruta),5(entregado),6(cancelado)
    var recogerEn= ""
    var tipoReferencia = ""
    var origen: LatLng?=null //{}
    var referenciaRecoger1 = ""
    var referenciaRecoger2 = ""
    var urlFoto = ""
    var paqueteList = ArrayList<PaqueteAgencia>()
    var estadoDeuda: Boolean?= null //true o false
    var montoDeuda = ""
    var puntosAcopio: LatLng?=null
    var distancia1 = ""
    var distancia2 = ""
    var costoServicio = ""
    var metodoPago = ""//efectivo
    var tiempoEstimado = ""
    var datosColaborador = ""
    var fechaGenerada : Date?=null
    var fechaAceptado : Date?=null
    var fechaRecogido : Date?=null
    var fechaEntregadoAcopio : Date?=null
    var fechaEnviado : Date?=null


    var permisoEntrega: Boolean?= null //false


}
