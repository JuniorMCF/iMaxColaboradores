package com.imaxclientes.app.models

import com.imaxcolaboradores.app.models.Remitente
import java.io.Serializable

class PaqueteCargo:Serializable {
    var codigoEnvio=""
    var remitente: Remitente?=null
    var destinatario:Remitente?=null
    var destino=""
    var agencia=""
    var cantidad=""
    var objeto=""
    var entregaDomicilio:Boolean?=null
    var dirEntrega=""
    var pagoFlete:Boolean?=null
    var depositoFlete=""
    var costoFlete=""
    var guia:Boolean?=null
    var estadoEnvio=""
    var urlComprobante=""

    constructor()
}