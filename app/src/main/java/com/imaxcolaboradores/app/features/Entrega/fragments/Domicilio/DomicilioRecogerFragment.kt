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

import kotlinx.android.synthetic.main.fragment_domicilio_recoger.view.*
import kotlinx.android.synthetic.main.fragment_domicilio_recoger.view.mapView
import kotlinx.android.synthetic.main.fragment_domicilio_recoger.view.txtCosto
import kotlinx.android.synthetic.main.fragment_domicilio_recoger.view.txtDistancia
import kotlinx.android.synthetic.main.fragment_domicilio_recoger.view.txtDomicilio
import kotlinx.android.synthetic.main.fragment_domicilio_recoger.view.txtEntregarDireccion
import kotlinx.android.synthetic.main.fragment_domicilio_recoger.view.txtObjeto
import kotlinx.android.synthetic.main.fragment_domicilio_recoger.view.txtRecogerDireccion
import kotlinx.android.synthetic.main.fragment_domicilio_recoger.view.txtRecogerReferencia

/**
 * A simple [Fragment] subclass.
 */
class DomicilioRecogerFragment : Fragment() , OnMapReadyCallback{


    private lateinit var pedidoCargo: PedidoCargo
    private lateinit var pedidoAgencia: PedidoAgencia
    private lateinit var pedidoDomicilio: PedidoDomicilio
    private lateinit var solicitud:SolicitudesDisponibles

    var adapter = AgenciasListAdapter()
    var listAgencias = ArrayList<AgenciasCheck>()

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

        solicitud = (context as SolicitudActivity).solicitud

        if(solicitud.tipo=="DOMICILIO"){
            pedidoDomicilio = solicitud.data!! as PedidoDomicilio
            view.txtRecogerDireccion.text = pedidoDomicilio.recogerEn
            view.txtRecogerReferencia.text = pedidoDomicilio.referenciaRecoger1
            view.txtEntregarDireccion.text = pedidoDomicilio.dejarEn
            view.txtCosto.text = pedidoDomicilio.costoServicio
            view.txtDomicilio.text = "D"
            view.txtDistancia.text = "${pedidoDomicilio.distancia1}"
            view.txtCosto.text = "${pedidoDomicilio.costoServicio}"
            view.txtObjeto.text = "Objeto"

        }else if(solicitud.tipo=="AGENCIA LIMA"){
            pedidoAgencia = solicitud.data!! as PedidoAgencia
            view.txtRecogerDireccion.text = pedidoAgencia.recogerEn!!
            view.txtRecogerReferencia.text = pedidoAgencia.referenciaRecoger1!!
            view.txtTipoServicio.text = "AGENCIAS "
            view.txtDomicilio.text = "AG"
            view.txtObjeto.text = "Objeto ${pedidoAgencia.paqueteList.size}"
            view.txtDistancia.text = "${pedidoAgencia.distancia1!!}km"
            view.txtCosto.text = "${pedidoAgencia.costoServicio!!}"


            view.rv_agencias_recoger.visibility = View.VISIBLE
            //iniciamos el recyclerview
            view.rv_agencias_recoger.setHasFixedSize(true)
            val llm = LinearLayoutManager(context)
            view.rv_agencias_recoger.layoutManager = llm
            view.rv_agencias_recoger.adapter = adapter

            view.txtEntregarDireccion.visibility = View.GONE
            view.txtEntregarReferencia.visibility = View.GONE
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


        }else if(solicitud.tipo=="CON RECOJO"){
            pedidoCargo = solicitud.data!! as PedidoCargo
            view.txtRecogerDireccion.text = pedidoCargo.recogerEn!!
            view.txtRecogerReferencia.text = pedidoCargo.referenciaRecoger1!!
            view.txtEntregarDireccion.text = ""//pedidoCargo.dejarEn!!
            //txtDomicilio.text = pedidoDomicilio.
            view.txtDistancia.text = "${pedidoCargo.distancia1!!}"
            view.txtCosto.text = "${pedidoCargo.costoServicio!!}"
            view.txtObjeto.text = "Objeto ${pedidoCargo.paqueteCargoSinRecojo.size}"

            //recyclerview
            view.rv_agencias_recoger.visibility = View.VISIBLE
            //iniciamos el recyclerview
            view.rv_agencias_recoger.setHasFixedSize(true)
            val llm = LinearLayoutManager(context)
            view.rv_agencias_recoger.layoutManager = llm
            view.rv_agencias_recoger.adapter = adapter

            view.txtEntregarDireccion.visibility = View.GONE
            view.txtEntregarReferencia.visibility = View.GONE
            val recojoList = pedidoCargo.paqueteCargoSinRecojo
            for (data in recojoList){
                var agencias = AgenciasCheck()
                agencias.agencia = data.agencia
                agencias.estado = "1"
                listAgencias!!.add(agencias)
            }
            if(listAgencias!=null){
                adapter!!.list = listAgencias
                adapter!!.notifyDataSetChanged()
            }


        }else if(solicitud.tipo=="SIN RECOJO"){
            pedidoCargo = solicitud.data!! as PedidoCargo
            view.txtRecogerDireccion.text = pedidoCargo.recogerEn!!
            view.txtRecogerReferencia.text = pedidoCargo.referenciaRecoger1!!
            view.txtEntregarDireccion.text = ""//pedidoCargo.dejarEn!!
            //txtDomicilio.text = pedidoDomicilio.
            view.txtDistancia.text = "${pedidoCargo.distancia1!!}"
            view.txtCosto.text = "${pedidoCargo.costoServicio!!}"
            view.txtObjeto.text = "Objeto ${pedidoCargo.paqueteCargoSinRecojo.size}"

            //recyclerview
            view.rv_agencias_recoger.visibility = View.VISIBLE
            //iniciamos el recyclerview
            view.rv_agencias_recoger.setHasFixedSize(true)
            val llm = LinearLayoutManager(context)
            view.rv_agencias_recoger.layoutManager = llm
            view.rv_agencias_recoger.adapter = adapter

            view.txtEntregarDireccion.visibility = View.GONE
            view.txtEntregarReferencia.visibility = View.GONE
            val recojoList = pedidoCargo.paqueteCargoSinRecojo
            for (data in recojoList){
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




        initButtons(view)



        return view
    }
    fun initButtons(view:View){
        view.imgCancelarPendiente.setOnClickListener{
            Log.d("gaa","xxd")
            (context as SolicitudActivity).supportFragmentManager.beginTransaction().replace(R.id.container_rechazo_pedido,
                RechazoPedidoFragment(),"rechazo_pendiente_fragment").commit()
        }
        view.btnAceptarPendiente.setOnClickListener{
            val builder = AlertDialog.Builder(ContextThemeWrapper(context, R.style.AlertDialogCustom))

            with(builder) {
                setTitle(solicitud.tipo)
                setMessage("¿Recogió el pedido?")
                setPositiveButton("Ok") { dialog, which ->

                    if (solicitud.tipo == "DOMICILIO") {
                        pedidoDomicilio.estadoServicio = "2" //recogido
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoDomicilio!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                val bundle = Bundle()
                                val fragment = DomicilioEntregarFragment()
                                bundle.putSerializable("pedidoRecojo", solicitud)
                                fragment.arguments = bundle
                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction()
                                    .replace(R.id.fl_solicitud, fragment, "domicilio_entrega").commit()
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e)

                            }




                    } else if (solicitud.tipo == "AGENCIA LIMA") {
                        pedidoAgencia.estadoServicio = "2" //recogido
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoAgencia!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                val bundle = Bundle()
                                val fragment = DomicilioEntregarFragment()
                                bundle.putSerializable("pedidoRecojo", solicitud)
                                fragment.arguments = bundle
                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction()
                                    .replace(R.id.fl_solicitud, fragment, "domicilio_entrega").commit()
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e)

                            }

                    } else if (solicitud.tipo == "CON RECOJO") {
                        pedidoCargo.estadoServicio = "2" //recogido
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoCargo!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                val bundle = Bundle()
                                val fragment = DomicilioEntregarFragment()
                                bundle.putSerializable("pedidoRecojo", solicitud)
                                fragment.arguments = bundle
                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction()
                                    .replace(R.id.fl_solicitud, fragment, "domicilio_entrega").commit()
                            }
                            .addOnFailureListener { e -> Log.w("aca", "Error writing document", e)

                            }

                    } else if (solicitud.tipo == "SIN RECOJO") {
                        pedidoCargo.estadoServicio = "2" //recogido
                        (activity as SolicitudActivity).database!!.collection("pedidos")
                            .document(solicitud.idDocument!!)
                            .set(pedidoCargo!!)
                            .addOnSuccessListener { Log.d("aca", "DocumentSnapshot successfully written!")
                                dialog.dismiss()
                                val bundle = Bundle()
                                val fragment = DomicilioEntregarFragment()
                                bundle.putSerializable("pedidoRecojo", solicitud)
                                fragment.arguments = bundle
                                (activity as SolicitudActivity).supportFragmentManager.beginTransaction()
                                    .replace(R.id.fl_solicitud, fragment, "domicilio_entrega").commit()
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
