package com.imaxcolaboradores.app.features.Entrega.fragments.Domicilio


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.imaxclientes.app.models.PedidoAgencia
import com.imaxclientes.app.models.PedidoCargo
import com.imaxclientes.app.models.PedidoDomicilio

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Entrega.SolicitudActivity
import com.imaxcolaboradores.app.features.Entrega.fragments.Agencia.ServicioAgenciaFragment
import com.imaxcolaboradores.app.features.Entrega.fragments.iMaxCargo.AcopiadoresDetallePedidoFragment
import com.imaxcolaboradores.app.models.SolicitudesDisponibles
import kotlinx.android.synthetic.main.fragment_domicilio_entregar.*
import kotlinx.android.synthetic.main.fragment_domicilio_entregar.view.*

/**
 * A simple [Fragment] subclass.
 */
class DomicilioEntregarFragment : Fragment(),OnMapReadyCallback {


    private lateinit var pedidoCargo: PedidoCargo
    private lateinit var pedidoAgencia: PedidoAgencia
    private lateinit var pedidoDomicilio: PedidoDomicilio
    private lateinit var solicitud: SolicitudesDisponibles

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

        solicitud = (context as SolicitudActivity).solicitud

        if(solicitud!!.tipo=="DOMICILIO"){
            pedidoDomicilio = solicitud!!.data!! as PedidoDomicilio
            view.txtRecogerDireccion.text = pedidoDomicilio.recogerEn!!
            view.txtRecogerReferencia.text = pedidoDomicilio.referenciaRecoger1!!
            view.txtEntregarDireccion.text = pedidoDomicilio.dejarEn!!
            view.txtDomicilio.text = "D"
            view.txtDistancia.text = "${pedidoDomicilio.distancia1!!}"
            view.txtCosto.text = "${pedidoDomicilio.costoServicio!!}"
            view.txtObjeto.text = "Objeto"

        }else if(solicitud!!.tipo=="AGENCIA LIMA"){
            //pedidoAgencia = solicitud!!.data!! as PedidoAgencia
            (context as SolicitudActivity).supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,ServicioAgenciaFragment(),"servicio_agencia").commit()

        }else if(solicitud!!.tipo=="CON RECOJO"){
            pedidoCargo = solicitud!!.data!! as PedidoCargo
            (context as SolicitudActivity).supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,AcopiadoresDetallePedidoFragment(),"detalle_pedido").commit()

        }else if(solicitud!!.tipo=="SIN RECOJO"){
            pedidoCargo = solicitud!!.data!! as PedidoCargo
            (context as SolicitudActivity).supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,AcopiadoresDetallePedidoFragment(),"detalle_pedido").commit()

        }

        initButtons(view)

        return view
    }

    fun initButtons(view:View){

        view.btnLlegueRecoger.setOnClickListener{

            val builder = AlertDialog.Builder(ContextThemeWrapper(context, R.style.AlertDialogCustom))

            with(builder) {
                setTitle(solicitud.tipo)
                setMessage("¿Recogió el pedido?")
                setPositiveButton("Ok") { dialog, which ->

                    if (solicitud.tipo == "DOMICILIO") {
                        pedidoDomicilio.estadoServicio = "5" //recogido
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoDomicilio!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction()
                                    .replace(R.id.fl_solicitud,  DomicilioRealizadoFragment(), "domicilio_realizado").commit()
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e)

                            }




                    } else if (solicitud.tipo == "AGENCIA LIMA") {
                        pedidoAgencia.estadoServicio = "5" //recogido
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoAgencia!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction()
                                    .replace(R.id.fl_solicitud,  DomicilioEntregarFragment(), "domicilio_entrega").commit()
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e)

                            }

                    } else if (solicitud.tipo == "CON RECOJO") {
                        pedidoCargo.estadoServicio = "5" //recogido
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoCargo!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()

                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction()
                                    .replace(R.id.fl_solicitud,  DomicilioEntregarFragment(), "domicilio_entrega").commit()
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e)

                            }

                    } else if (solicitud.tipo == "SIN RECOJO") {
                        pedidoCargo.estadoServicio = "5" //recogido
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoCargo!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction()
                                    .replace(R.id.fl_solicitud,  DomicilioEntregarFragment(), "domicilio_entrega").commit()
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e)

                            }

                    }

                }
                setNegativeButton("Cancel") { dialog, which ->
                    dialog.dismiss()
                }
                builder.show()
            }

        }


    }
    override fun onMapReady(p0: GoogleMap?) {

    }

}
