package com.imaxcolaboradores.app.features.Entrega.fragments.Domicilio


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

import com.imaxcolaboradores.app.R
import kotlinx.android.synthetic.main.fragment_domicilio_entregar.*
import kotlinx.android.synthetic.main.fragment_domicilio_entregar.view.*

/**
 * A simple [Fragment] subclass.
 */
class DomicilioEntregarFragment : Fragment(),OnMapReadyCallback {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_domicilio_entregar, container, false)

        val mMapView =  view.mapView
        if (mMapView != null) {
            mMapView.onCreate(null)
            mMapView.onResume()
            mMapView.getMapAsync(this)
        }
/*
        if(solicitudRecojo!!.tipo=="DOMICILIO"){
            pedidoDomicilio = solicitudRecojo!!.data!! as PedidoDomicilio
            txtRecogerDireccion.text = pedidoDomicilio.recogerEn!!
            txtRecogerReferencia.text = pedidoDomicilio.referenciaRecoger1!!
            txtEntregarDireccion.text = pedidoDomicilio.dejarEn!!
            //txtDomicilio.text = pedidoDomicilio.
            txtDistancia.text = "${pedidoDomicilio.distancia1!!}"
            txtCosto.text = "${pedidoDomicilio.costoServicio!!}"
            txtObjeto.text = ""

        }else if(solicitudRecojo!!.tipo=="AGENCIA LIMA"){
            pedidoAgencia = solicitudRecojo!!.data!! as PedidoAgencia
            txtRecogerDireccion.text = pedidoAgencia.recogerEn!!
            txtRecogerReferencia.text = pedidoAgencia.referenciaRecoger1!!
            txtEntregarDireccion.text = "" //dejar en
            //txtDomicilio.text = pedidoDomicilio.
            txtDistancia.text = "${pedidoAgencia.distancia1!!}km"
            txtCosto.text = "${pedidoAgencia.costoServicio!!}"
            txtObjeto.text = ""

        }else if(solicitudRecojo!!.tipo=="CON RECOJO"){
            pedidoCargo = solicitudRecojo!!.data!! as PedidoCargo
            txtRecogerDireccion.text = pedidoCargo.recogerEn!!
            txtRecogerReferencia.text = pedidoCargo.referenciaRecoger1!!
            txtEntregarDireccion.text = ""//pedidoCargo.dejarEn!!
            //txtDomicilio.text = pedidoDomicilio.
            txtDistancia.text = "${pedidoCargo.distancia1!!}"
            txtCosto.text = "${pedidoCargo.costoServicio!!}"
            txtObjeto.text = ""

        }else if(solicitudRecojo!!.tipo=="SIN RECOJO"){
            pedidoCargo = solicitudRecojo!!.data!! as PedidoCargo
            txtRecogerDireccion.text = pedidoCargo.recogerEn!!
            txtRecogerReferencia.text = pedidoCargo.referenciaRecoger1!!
            txtEntregarDireccion.text = ""//pedidoCargo.dejarEn!!
            //txtDomicilio.text = pedidoDomicilio.
            txtDistancia.text = "${pedidoCargo.distancia1!!}"
            txtCosto.text = "${pedidoCargo.costoServicio!!}"
            txtObjeto.text = ""

        }

        btnLlegueRecoger.setOnClickListener{

        }


*/



        return view
    }

    override fun onMapReady(p0: GoogleMap?) {

    }

}
