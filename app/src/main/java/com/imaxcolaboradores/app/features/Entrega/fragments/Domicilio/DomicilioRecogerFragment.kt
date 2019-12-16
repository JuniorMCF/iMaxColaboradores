package com.imaxcolaboradores.app.features.Entrega.fragments.Domicilio


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

import com.imaxcolaboradores.app.R
import kotlinx.android.synthetic.main.fragment_domicilio_recoger.view.*

/**
 * A simple [Fragment] subclass.
 */
class DomicilioRecogerFragment : Fragment() , OnMapReadyCallback{


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_domicilio_recoger, container, false)

        val mMapView =  view.mapView
        if (mMapView != null) {
            mMapView.onCreate(null)
            mMapView.onResume()
            mMapView.getMapAsync(this)
        }
/*
        if(solicitud.tipo=="DOMICILIO"){
            pedidoDomicilio = solicitud.data!! as PedidoDomicilio
            txtRecogerDireccion.text = pedidoDomicilio.recogerEn!!
            txtRecogerReferencia.text = pedidoDomicilio.referenciaRecoger1!!
            txtEntregarDireccion.text = pedidoDomicilio.dejarEn!!
            //txtDomicilio.text = pedidoDomicilio.
            txtDistancia.text = "${pedidoDomicilio.distancia1!!}"
            txtCosto.text = "${pedidoDomicilio.costoServicio!!}"
            txtObjeto.text = ""

        }else if(solicitud.tipo=="AGENCIA LIMA"){
            pedidoAgencia = solicitud.data!! as PedidoAgencia
            txtRecogerDireccion.text = pedidoAgencia.recogerEn!!
            txtRecogerReferencia.text = pedidoAgencia.referenciaRecoger1!!
            txtEntregarDireccion.text = "" //dejar en
            //txtDomicilio.text = pedidoDomicilio.
            txtDistancia.text = "${pedidoAgencia.distancia1!!}km"
            txtCosto.text = "${pedidoAgencia.costoServicio!!}"
            txtObjeto.text = ""

        }else if(solicitud.tipo=="CON RECOJO"){
            pedidoCargo = solicitud.data!! as PedidoCargo
            txtRecogerDireccion.text = pedidoCargo.recogerEn!!
            txtRecogerReferencia.text = pedidoCargo.referenciaRecoger1!!
            txtEntregarDireccion.text = ""//pedidoCargo.dejarEn!!
            //txtDomicilio.text = pedidoDomicilio.
            txtDistancia.text = "${pedidoCargo.distancia1!!}"
            txtCosto.text = "${pedidoCargo.costoServicio!!}"
            txtObjeto.text = ""

        }else if(solicitud.tipo=="SIN RECOJO"){
            pedidoCargo = solicitud.data!! as PedidoCargo
            txtRecogerDireccion.text = pedidoCargo.recogerEn!!
            txtRecogerReferencia.text = pedidoCargo.referenciaRecoger1!!
            txtEntregarDireccion.text = ""//pedidoCargo.dejarEn!!
            //txtDomicilio.text = pedidoDomicilio.
            txtDistancia.text = "${pedidoCargo.distancia1!!}"
            txtCosto.text = "${pedidoCargo.costoServicio!!}"
            txtObjeto.text = ""

        }




        imgCancelarPendiente.setOnClickListener{
            Log.d("gaa","xxd")
            supportFragmentManager.beginTransaction().replace(R.id.container_rechazo_pedido,RechazoPedidoFragment(),"rechazo_pendiente_fragment").commit()
        }
        btnAceptarPendiente.setOnClickListener{
            val intent = Intent(this,DomicilioEntregarActivity::class.java)
            if(solicitud.tipo=="DOMICILIO"){
                val bundle = Bundle()
                bundle.putSerializable("pedidoRecojo",solicitud)
                intent.putExtra("bundle",bundle)
                startActivity(intent)

            }else if(solicitud.tipo=="AGENCIA LIMA"){
                val bundle = Bundle()
                bundle.putSerializable("pedidoRecojo",solicitud)
                intent.putExtra("bundle",bundle)
                startActivity(intent)

            }else if(solicitud.tipo=="CON RECOJO"){
                val bundle = Bundle()
                bundle.putSerializable("pedidoRecojo",solicitud)
                intent.putExtra("bundle",bundle)
                startActivity(intent)

            }else if(solicitud.tipo=="SIN RECOJO"){
                val bundle = Bundle()
                bundle.putSerializable("pedidoRecojo",solicitud)
                intent.putExtra("bundle",bundle)
                startActivity(intent)
            }

        }
*/


        return view
    }

    override fun onMapReady(p0: GoogleMap?) {

    }

}
