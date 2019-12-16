package com.imaxcolaboradores.app.features.Entrega.fragments.Domicilio


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.imaxclientes.app.models.PedidoAgencia
import com.imaxclientes.app.models.PedidoCargo
import com.imaxclientes.app.models.PedidoDomicilio

import com.imaxcolaboradores.app.R
import kotlinx.android.synthetic.main.fragment_domicilio_aceptar.*
import kotlinx.android.synthetic.main.fragment_domicilio_aceptar.view.*

/**
 * A simple [Fragment] subclass.
 */
class DomicilioAceptarFragment : Fragment(), OnMapReadyCallback {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_domicilio_aceptar, container, false)

        val mMapView =  view.mapView
            if (mMapView != null) {
                mMapView.onCreate(null)
                mMapView.onResume()
                mMapView.getMapAsync(this)
            }
/*

        if(solicitud.tipo=="DOMICILIO"){
            pedidoDomicilio = solicitud.data!! as PedidoDomicilio


        }else if(solicitud.tipo=="AGENCIA LIMA"){
            pedidoAgencia = solicitud.data!! as PedidoAgencia

        }else if(solicitud.tipo=="CON RECOJO"){
            pedidoCargo = solicitud.data!! as PedidoCargo

        }else if(solicitud.tipo=="SIN RECOJO"){
            pedidoCargo = solicitud.data!! as PedidoCargo

        }


        btnAceptarDisponible.setOnClickListener{
            val builder = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogCustom))

            with(builder){
                setTitle(solicitud.tipo)
                setMessage("¿Està seguro de aceptar el pedido?")
                setPositiveButton("Ok") { dialog, which ->

                    if(solicitud.tipo=="DOMICILIO"){
                        pedidoDomicilio.datosColaborador = "idcolaborador"
                        pedidoDomicilio.estadoServicio = "1" //aceptado
                        database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoDomicilio!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                val intent = Intent(context , DomicilioRecogerActivity::class.java)
                                context!!.startActivity(intent)
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e)

                            }

                    }else if(solicitud.tipo=="AGENCIA LIMA"){
                        pedidoAgencia.datosColaborador = "idcolaborador"
                        pedidoAgencia.estadoServicio = "1" //aceptado
                        database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoAgencia!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                val intent = Intent(context , DomicilioRecogerActivity::class.java)
                                context!!.startActivity(intent)
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e) }

                    }else if(solicitud.tipo=="CON RECOJO"){
                        pedidoCargo.datosColaborador = "idcolaborador"
                        pedidoCargo.estadoServicio = "1" //aceptado
                        database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoCargo!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                val intent = Intent(context , DomicilioRecogerActivity::class.java)
                                context!!.startActivity(intent)
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e) }
                    }else if(solicitud.tipo=="SIN RECOJO"){
                        pedidoCargo.datosColaborador = "idcolaborador"
                        pedidoCargo.estadoServicio = "1" //aceptado
                        database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoCargo!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                val intent = Intent(context , DomicilioRecogerActivity::class.java)
                                context!!.startActivity(intent)
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e) }
                    }


                }
                setNegativeButton("Cancel") { dialog, which ->
                    dialog.dismiss()
                }
                builder.show()
            }
        }
*/
        return view
    }

    override fun onMapReady(googleMap: GoogleMap) {
       /* mMap = googleMap

        val pedido = (context as PedidosDomicilioActivity).pedido
        partida = LatLng(pedido.origen!!.latitude,pedido.origen!!.longitude)

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(partida,14.5f))
        mMap.addMarker(MarkerOptions().title("").position(LatLng(partida!!.latitude,partida!!.longitude)).icon(bitmapDescriptorFromVector(context!!,R.drawable.ic_marker)))

        if((context as PedidosDomicilioActivity).estadoPedido == "1") {
            obtenerDatos(context!!)
        }

        */
    }
}
