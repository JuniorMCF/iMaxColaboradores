package com.imaxcolaboradores.app.features.Principal.fragments.solicitudesfragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.DocumentChange

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.Adapters.DisponiblesAdapter
import com.imaxcolaboradores.app.features.Principal.Adapters.PedidosAdapter
import com.imaxcolaboradores.app.features.Principal.PrimerActivity
import com.imaxcolaboradores.app.features.Principal.PrincipalViewModel
import com.imaxcolaboradores.app.models.Pedido
import com.imaxcolaboradores.app.models.SolicitudesDisponibles
import kotlinx.android.synthetic.main.fragment_solicitudes_disponible.*
import kotlinx.android.synthetic.main.fragment_solicitudes_disponible.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 */
class SolicitudesDisponibleFragment : Fragment() {

    private val principalViewModel: PrincipalViewModel by viewModel()

    private val adapter =  DisponiblesAdapter()
    private var listDisponible = ArrayList<SolicitudesDisponibles>()
    var rol:String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_solicitudes_disponible, container, false)
        rol = "motorizado"
        view.imgAcopiador.setOnClickListener{
            if(rol == "motorizado"){ //cambiamos a acopiador-motorizado
                rol = "acopiador-motorizado"
                listDisponible.clear()
                actualizarData()
                imgAcopiador.setImageResource(R.drawable.acopiador)
            }else if(rol == "conductor"){   //cambiamos a acopiador-conductor
                rol = "acopiador-conductor"
                listDisponible.clear()
                actualizarData()
                imgAcopiador.setImageResource(R.drawable.acopiador)
            }else if(rol == "acopiador-motorizado"){ //cambiamos a motorizado
                rol = "motorizado"
                listDisponible.clear()
                actualizarData()
                imgAcopiador.setImageResource(R.drawable.motorizado_conductor)
            }else if(rol == "acopiador-conductor"){ //cambiamos a conductor
                rol = "conductor"
                listDisponible.clear()
                actualizarData()
                imgAcopiador.setImageResource(R.drawable.motorizado_conductor)
            }
        }

        setObservers()


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        obtenerData()
        initAdapter()
    }
    private fun obtenerData(){
        (context as PrimerActivity).pedidoList!!.clear()

        (context as PrimerActivity).database!!.collection("pedidos")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w("aca", "listen:error", e)
                    return@addSnapshotListener
                }
                for (dc in snapshots!!.documentChanges) {
                    Log.d("aca", "New city: ${dc.document}")
                    when (dc.type) {
                        DocumentChange.Type.ADDED -> {
                            Log.d("aca", "New city: ${dc.document.data}")
                            var pedido = Pedido()
                            if(dc.document.get("tipoServicio").toString() == "Domicilio"){
                                pedido.tipo = "0"
                            }
                            if(dc.document.get("tipoServicio").toString() == "Agencia Lima"){
                                pedido.tipo = "1"
                            }
                            if(dc.document.get("tipoServicio").toString() == "Con Recojo"){
                                pedido.tipo = "2"
                            }
                            if(dc.document.get("tipoServicio").toString() == "Sin Recojo"){
                                pedido.tipo = "3"
                            }
                            pedido.recoger = dc.document.get("recogerEn").toString()
                            pedido.tiempo = dc.document.get("fechaGenerada").toString()
                            pedido.document = dc.document
                            (context as PrimerActivity).pedidoList.add(pedido)

                        }
                        DocumentChange.Type.MODIFIED ->{
                            Log.d("aca", "Modified city: ${dc.document.data}")
                            for((i,data) in (context as PrimerActivity).pedidoList!!.withIndex()){
                                if(data.document!!.id == dc.document.id){
                                    (context as PrimerActivity).pedidoList!!.removeAt(i)
                                    var pedido = Pedido()
                                    pedido.tipo = dc.document.get("tipoServicio").toString()
                                    pedido.tipo = dc.document.get("recogerEn").toString()
                                    pedido.tiempo = dc.document.get("fechaGenerada").toString()
                                    pedido.document = dc.document
                                    (context as PrimerActivity).pedidoList!!.add(i,pedido)

                                }
                            }
                        }
                        DocumentChange.Type.REMOVED -> {
                            Log.d("aca", "Removed city: ${dc.document.data}")
                            for((i, data) in (context as PrimerActivity).pedidoList!!.withIndex()){
                                if(data.document!!.id == dc.document.id){
                                    (context as PrimerActivity).pedidoList!!.removeAt(i)
                                }
                            }


                        }
                    }
                }
                listDisponible.clear()
                actualizarData()
            }
    }

    private fun actualizarData() {


        for (data in  (context as PrimerActivity).pedidoList){
            var solicitudDisponible = SolicitudesDisponibles()



            //-------ACOPIADOR--------//  0
            if((context as PrimerActivity).tipoColaborador == "0"){  // Acopiador (menor a 500m)
               // posicion del colaborador - posicion de la solicitud

            }


            //-------MOTORIZADO--------//  1
            else if((context as PrimerActivity).tipoColaborador == "1"){ // Motorizado  (mayor a 500m)
                if(rol == "acopiador-motorizado"){
                    //se muestran agencia y recojo
                    if (data.tipo == "1"){
                        solicitudDisponible.tipo = "AGENCIA LIMA"
                        solicitudDisponible.tiempo = data.tiempo!!.substring(11,19)
                        solicitudDisponible.lugar = data.recoger!!
                        listDisponible!!.add(solicitudDisponible)
                    }
                    if (data.tipo == "2"){
                        solicitudDisponible.tipo = "CON RECOJO"
                        solicitudDisponible.tiempo = data.tiempo!!.substring(11,19)
                        solicitudDisponible.lugar = data.recoger!!
                        listDisponible!!.add(solicitudDisponible)
                    }
                }


                if(rol == "motorizado"){
                    //se muestra domicilio , agencia o recojo
                    if( data.tipo == "0"){
                        solicitudDisponible.tipo = "DOMICILIO"
                        solicitudDisponible.tiempo = data.tiempo!!.substring(11,19)
                        solicitudDisponible.lugar = data.recoger!!
                        solicitudDisponible.movilidad = data.document!!.get("tipoTransporte").toString()
                        /*if(data.document!!.get("estadoServicio") == "0"){
                        }
                        */
                        listDisponible!!.add(solicitudDisponible)
                    }
                    if (data.tipo == "1"){
                        solicitudDisponible.tipo = "AGENCIA LIMA"
                        solicitudDisponible.tiempo = data.tiempo!!.substring(11,19)
                        solicitudDisponible.lugar = data.recoger!!
                        listDisponible!!.add(solicitudDisponible)
                    }
                    if (data.tipo == "2"){
                        solicitudDisponible.tipo = "CON RECOJO"
                        solicitudDisponible.tiempo = data.tiempo!!.substring(11,19)
                        solicitudDisponible.lugar = data.recoger!!
                        listDisponible!!.add(solicitudDisponible)
                    }

                }
            }

            //-------CONDUCTOR--------//   2
            else if((context as PrimerActivity).tipoColaborador == "2"){ // Conductor (furgon  mayor a  500m )
                if(rol == "acopiador-conductor"){
                    //se muestran agencia y recojo
                    if (data.tipo == "1"){
                        solicitudDisponible.tipo = "AGENCIA LIMA"
                        solicitudDisponible.tiempo = data.tiempo!!.substring(11,19)
                        solicitudDisponible.lugar = data.recoger!!
                        listDisponible!!.add(solicitudDisponible)
                    }
                    if (data.tipo == "2"){
                        solicitudDisponible.tipo = "CON RECOJO"
                        solicitudDisponible.tiempo = data.tiempo!!.substring(11,19)
                        solicitudDisponible.lugar = data.recoger!!
                        listDisponible!!.add(solicitudDisponible)
                    }
                }

                if(rol == "conductor"){
                    //se muestra domicilio , agencia o recojo
                    if( data.tipo == "0"){
                        solicitudDisponible.tipo = "DOMICILIO"
                        solicitudDisponible.tiempo = data.tiempo!!.substring(11,19)
                        solicitudDisponible.lugar = data.recoger!!
                        solicitudDisponible.movilidad = data.document!!.get("tipoTransporte").toString()
                        /*if(data.document!!.get("estadoServicio") == "0"){

                        }
                        */
                        listDisponible!!.add(solicitudDisponible)
                    }
                    if (data.tipo == "1"){
                        solicitudDisponible.tipo = "AGENCIA LIMA"
                        solicitudDisponible.tiempo = data.tiempo!!.substring(11,19)
                        solicitudDisponible.lugar = data.recoger!!
                        listDisponible!!.add(solicitudDisponible)
                    }
                    if (data.tipo == "2"){
                        solicitudDisponible.tipo = "CON RECOJO"
                        solicitudDisponible.tiempo = data.tiempo!!.substring(11,19)
                        solicitudDisponible.lugar = data.recoger!!
                        listDisponible!!.add(solicitudDisponible)
                    }
                }

            }



        }
        adapter!!.notifyDataSetChanged()

    }

    private fun initAdapter(){

        adapter!!.context = context!!
        adapter!!.list = listDisponible
        view!!.rv_Disponible.layoutManager = LinearLayoutManager(context)
        view!!.rv_Disponible.adapter = adapter

    }



    private fun setObservers() {
        principalViewModel.apply {
            disponibleSuccess.observe(this@SolicitudesDisponibleFragment, disponibleSuccessObserver)
        }
    }

    private val disponibleSuccessObserver = Observer<Any>{
        Log.d("aca","data $it")
        adapter!!.list = (it as MutableList<SolicitudesDisponibles>).toList()

        adapter.notifyDataSetChanged()
    }


}
