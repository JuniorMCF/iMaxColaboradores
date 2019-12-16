package com.imaxclientes.app.models


import com.imaxcolaboradores.app.models.LatLng
import com.imaxcolaboradores.app.models.Remitente
import java.io.Serializable

class PaqueteAgencia : Serializable {

    var codigoEnvio = ""
    var remitente = Remitente()
    var destinatario = Remitente()
    var destino = ""
    var agencia = ""
    var cantidad = ""
    var objeto = ""
    var entregaDomicilio: Boolean?=null//false
    var dirEntrega = ""
    var pagoFlete: Boolean?=null //false o true
    var depositoFlete= ""
    var costoFlete= ""
    var guia: Boolean?=null //false o true
    var estadoEnvio = ""
    var urlComprobante = ""
    var destinoCoordenadas : LatLng? = null
}