package com.imaxcolaboradores.app.features.Entrega.fragments.Domicilio


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.imaxclientes.app.models.PedidoAgencia
import com.imaxclientes.app.models.PedidoCargo
import com.imaxclientes.app.models.PedidoDomicilio

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Entrega.SolicitudActivity
import com.imaxcolaboradores.app.features.Entrega.fragments.RechazoPedidoFragment
import com.imaxcolaboradores.app.features.Principal.Adapters.AgenciasListAdapter
import com.imaxcolaboradores.app.models.AgenciasCheck
import com.imaxcolaboradores.app.models.SolicitudesDisponibles
import kotlinx.android.synthetic.main.activity_entrega_recoger.*
import kotlinx.android.synthetic.main.activity_entrega_recoger.txtEntregarDireccion
import kotlinx.android.synthetic.main.activity_entrega_recoger.txtRecogerDireccion
import kotlinx.android.synthetic.main.fragment_agencia_entregue.*
import kotlinx.android.synthetic.main.fragment_agencia_entregue.etObjetoAgencia
import kotlinx.android.synthetic.main.fragment_agencia_entregue.view.*
import kotlinx.android.synthetic.main.fragment_agencia_realizada.*
import kotlinx.android.synthetic.main.fragment_domicilio_aceptar.*
import kotlinx.android.synthetic.main.fragment_domicilio_aceptar.txtCosto
import kotlinx.android.synthetic.main.fragment_domicilio_aceptar.txtDistancia
import kotlinx.android.synthetic.main.fragment_domicilio_aceptar.txtDomicilio
import kotlinx.android.synthetic.main.fragment_domicilio_aceptar.txtObjeto
import kotlinx.android.synthetic.main.fragment_domicilio_aceptar.view.*
import kotlinx.android.synthetic.main.fragment_domicilio_recoger.*
import kotlinx.android.synthetic.main.fragment_entregue_asignacion.*

/**
 * A simple [Fragment] subclass.
 */
class DomicilioAceptarFragment : Fragment(), OnMapReadyCallback {

    private lateinit var pedidoCargo: PedidoCargo
    private lateinit var pedidoAgencia: PedidoAgencia
    private lateinit var pedidoDomicilio: PedidoDomicilio
    var adapter = AgenciasListAdapter()
    var listAgencias = ArrayList<AgenciasCheck>()
    /**Esta actividad se usa para aceptar los pedidos para todos los casos
     *
     * DOMICILIO
     * Agencia Lima
     * iMaxCargo (con recojo, sin recojo)
     *
     *
     * **/
    private lateinit var solicitud :SolicitudesDisponibles
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_domicilio_aceptar, container, false)

        initButtons(view)
        val mMapView =  view!!.mapView
        if (mMapView != null) {
            mMapView.onCreate(null)
            mMapView.onResume()
            mMapView.getMapAsync(this)
        }

        solicitud = (context as SolicitudActivity).solicitud

        if(solicitud.tipo=="DOMICILIO"){
            pedidoDomicilio = solicitud.data!! as PedidoDomicilio
            view.txtDistancia.text = pedidoDomicilio.distancia1
            view.txtDomicilio.text = "DOMICILIO: D"
            view.txtObjeto.text = "Objeto"
            view.txtCosto.text = pedidoDomicilio.costoServicio
            view.txtDirRecogerEn.text = pedidoDomicilio.recogerEn
            view.txtRefRecogerEn.text = pedidoDomicilio.referenciaRecoger1
            view. txtDirEntregarEn.text = pedidoDomicilio.dejarEn
            view.txtRefEntregarEn.text = pedidoDomicilio.referenciaDejar

        }else if(solicitud.tipo=="AGENCIA LIMA"){
            pedidoAgencia = solicitud.data!! as PedidoAgencia
            if((context as SolicitudActivity).rol == "acopiador" || (context as SolicitudActivity).rol == "motorizado_acopiador" ||  (context as SolicitudActivity).rol == "conductor_acopiador"){
                view.clAceptar1.visibility = View.GONE
                view.clAceptar2.visibility = View.VISIBLE
                view.txtServicioData.text = pedidoAgencia.tipoServicio
                view.txtDetalleData.text = "${pedidoAgencia.paqueteList.size} caja"
                view.txtDirEntregarEn.text = ""
                view.txtRefEntregarEn.text = ""

            }else if ((context as SolicitudActivity).rol=="motorizado" || (context as SolicitudActivity).rol=="conductor" ){
                view.txtDistancia.text = "${pedidoAgencia.distancia1}km"
                view.txtDomicilio.text = "DOMICILIO: D"
                view.txtObjeto.text = "Objeto: ${pedidoAgencia.paqueteList.size}"
                view.txtDirRecogerEn.text = pedidoAgencia.recogerEn
                view.txtRefRecogerEn.text = pedidoAgencia.referenciaRecoger1
                view.txtCosto.text = "Costo: ${pedidoAgencia.costoServicio}"
                view.rv_agencias_aceptar.visibility = View.VISIBLE
                //iniciamos el recyclerview
                view.rv_agencias_aceptar.setHasFixedSize(true)
                val llm = LinearLayoutManager(context)
                view.rv_agencias_aceptar.layoutManager = llm
                view.rv_agencias_aceptar.adapter = adapter

                view.txtDirEntregarEn.visibility = View.GONE
                view.txtRefEntregarEn.visibility = View.GONE
                val agenciaList = pedidoAgencia.paqueteList
                for (data in agenciaList){
                    var agencias = AgenciasCheck()
                    agencias.agencia = data.agencia
                    agencias.estado = "1"
                    listAgencias!!.add(agencias)
                }
                if(listAgencias!=null){
                    adapter!!.list = listAgencias
                    adapter!!.notifyDataSetChanged()
                }
            }

        }else if(solicitud.tipo=="CON RECOJO"){
            pedidoCargo = solicitud.data!! as PedidoCargo

        }else if(solicitud.tipo=="SIN RECOJO"){
            pedidoCargo = solicitud.data!! as PedidoCargo

        }




        return view
    }

    fun initButtons(view:View){
        view.btnAceptarDisponible.setOnClickListener{
            val builder = AlertDialog.Builder(ContextThemeWrapper(context, R.style.AlertDialogCustom))

            with(builder){
                setTitle(solicitud.tipo)
                setMessage("¿Està seguro de aceptar el pedido?")
                setPositiveButton("Ok") { dialog, which ->

                    if(solicitud.tipo=="DOMICILIO"){
                        pedidoDomicilio.datosColaborador = "idcolaborador"
                        pedidoDomicilio.estadoServicio = "1" //aceptado
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoDomicilio!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,DomicilioRecogerFragment(),"domicilio_recoger").commitAllowingStateLoss()
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e)

                            }

                    }else if(solicitud.tipo=="AGENCIA LIMA"){
                        pedidoAgencia.datosColaborador = "idcolaborador"
                        pedidoAgencia.estadoServicio = "1" //aceptado
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoAgencia!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,DomicilioRecogerFragment(),"domicilio_recoger").commitAllowingStateLoss()
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e) }

                    }else if(solicitud.tipo=="CON RECOJO"){
                        pedidoCargo.datosColaborador = "idcolaborador"
                        pedidoCargo.estadoServicio = "1" //aceptado
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoCargo!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,DomicilioRecogerFragment(),"domicilio_recoger").commitAllowingStateLoss()
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e) }
                    }else if(solicitud.tipo=="SIN RECOJO"){
                        pedidoCargo.datosColaborador = "idcolaborador"
                        pedidoCargo.estadoServicio = "1" //aceptado
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoCargo!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,DomicilioRecogerFragment(),"domicilio_recoger").commitAllowingStateLoss()
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

        view.btnCancelarDisponible.setOnClickListener{

            (context as SolicitudActivity).supportFragmentManager.beginTransaction().add(R.id.fl_solicitud,RechazoPedidoFragment(),"rechazo_pedido").addToBackStack(null).commit()

        }
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
