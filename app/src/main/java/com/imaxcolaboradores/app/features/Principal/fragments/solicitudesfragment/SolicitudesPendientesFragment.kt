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
import com.imaxclientes.app.models.PedidoAgencia
import com.imaxclientes.app.models.PedidoCargo
import com.imaxclientes.app.models.PedidoDomicilio

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.Adapters.PendientesAdapter
import com.imaxcolaboradores.app.features.Principal.PrimerActivity
import com.imaxcolaboradores.app.features.Principal.PrincipalViewModel
import com.imaxcolaboradores.app.models.Pedido
import com.imaxcolaboradores.app.models.SolicitudesDisponibles
import kotlinx.android.synthetic.main.fragment_solicitudes_pendientes.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class SolicitudesPendientesFragment : Fragment() {

    private val principalViewModel : PrincipalViewModel by viewModel()

    private var adapter =  PendientesAdapter()
    private var listPendiente= ArrayList<SolicitudesDisponibles>()
    var rol = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_solicitudes_pendientes, container, false)
        rol = "motorizado"
        //setObservers()
        initAdapter(view)
        obtenerData()


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initAdapter(view:View) {
        adapter.context = context
        adapter.list = listPendiente

        view!!.rv_Pendientes.layoutManager = LinearLayoutManager(context)
        view!!.rv_Pendientes.adapter = adapter
    }

    private fun obtenerData() {
        (context as PrimerActivity).pendienteList!!.clear()

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
                            (context as PrimerActivity).pendienteList.add(pedido)
                            adapter.notifyDataSetChanged()

                        }
                        DocumentChange.Type.MODIFIED ->{
                            Log.d("aca", "Modified city: ${dc.document.data}")
                            for((i,data) in (context as PrimerActivity).pendienteList!!.withIndex()){
                                if(data.document!!.id == dc.document.id){
                                    (context as PrimerActivity).pendienteList[i].document = dc.document
                                    adapter.notifyDataSetChanged()
                                }
                            }
                        }
                        DocumentChange.Type.REMOVED -> {
                            Log.d("aca", "Removed city: ${dc.document.data}")
                            for((i, data) in (context as PrimerActivity).pendienteList!!.withIndex()){
                                if(data.document!!.id == dc.document.id){
                                    (context as PrimerActivity).pendienteList!!.removeAt(i)
                                    adapter.notifyDataSetChanged()
                                }
                            }


                        }
                    }
                }
                listPendiente.clear()
                actualizarData()
            }
    }

    private fun actualizarData() {


        for (data in  (context as PrimerActivity).pedidoList){
            var solicitudPendiente = SolicitudesDisponibles()



            //-------ACOPIADOR--------//  0
            if((context as PrimerActivity).tipoColaborador == "0" && data.document!!.get("estadoServicio")!="0"){  // Acopiador (menor a 500m)
                // posicion del colaborador - posicion de la solicitud

            }


            //-------MOTORIZADO--------//  1
            else if((context as PrimerActivity).tipoColaborador == "1" && data.document!!.get("estadoServicio")!="0"){ // Motorizado  (mayor a 500m)
                if(rol == "acopiador-motorizado"){
                    //se muestran agencia y recojo
                    if (data.tipo == "1"){   // 0 : domicilio  1: agencia 2: con recojo 3:sin recojo
                        solicitudPendiente.tipo = "AGENCIA LIMA"
                        solicitudPendiente.tiempo = data.tiempo!!.substring(11,19)
                        solicitudPendiente.lugar = data.recoger!!
                        solicitudPendiente.data = data.document!!.toObject(PedidoAgencia::class.java)
                        solicitudPendiente.idDocument = data.document!!.id
                        solicitudPendiente.estado = data.document!!.get("estadoServicio") as String
                        listPendiente!!.add(solicitudPendiente)
                    }
                    if (data.tipo == "2"){
                        solicitudPendiente.tipo = "CON RECOJO"
                        solicitudPendiente.tiempo = data.tiempo!!.substring(11,19)
                        solicitudPendiente.lugar = data.recoger!!
                        solicitudPendiente.data = data.document!!.toObject(PedidoCargo::class.java)
                        solicitudPendiente.idDocument = data.document!!.id
                        solicitudPendiente.estado = data.document!!.get("estadoServicio") as String
                        listPendiente!!.add(solicitudPendiente)
                    }
                }


                if(rol == "motorizado"){
                    //se muestra domicilio , agencia o recojo
                    if( data.tipo == "0"){
                        solicitudPendiente.tipo = "DOMICILIO"
                        solicitudPendiente.tiempo = data.tiempo!!.substring(11,19)
                        solicitudPendiente.lugar = data.recoger!!
                        solicitudPendiente.data = data.document!!.toObject(PedidoDomicilio::class.java)
                        solicitudPendiente.idDocument = data.document!!.id
                        solicitudPendiente.estado = data.document!!.get("estadoServicio") as String
                        /*if(data.document!!.get("estadoServicio") == "0"){
                        }
                        */
                        listPendiente!!.add(solicitudPendiente)
                    }
                    if (data.tipo == "1"){
                        solicitudPendiente.tipo = "AGENCIA LIMA"
                        solicitudPendiente.tiempo = data.tiempo!!.substring(11,19)
                        solicitudPendiente.lugar = data.recoger!!
                        solicitudPendiente.data = data.document!!.toObject(PedidoAgencia::class.java)
                        solicitudPendiente.idDocument = data.document!!.id
                        solicitudPendiente.estado = data.document!!.get("estadoServicio") as String
                        listPendiente!!.add(solicitudPendiente)
                    }
                    if (data.tipo == "2"){
                        solicitudPendiente.tipo = "CON RECOJO"
                        solicitudPendiente.tiempo = data.tiempo!!.substring(11,19)
                        solicitudPendiente.lugar = data.recoger!!
                        solicitudPendiente.data = data.document!!.toObject(PedidoCargo::class.java)
                        solicitudPendiente.idDocument = data.document!!.id
                        solicitudPendiente.estado = data.document!!.get("estadoServicio") as String
                        listPendiente!!.add(solicitudPendiente)
                    }

                }
            }

            //-------CONDUCTOR--------//   2
            else if((context as PrimerActivity).tipoColaborador == "2" && data.document!!.get("estadoServicio")=="0"){ // Conductor (furgon  mayor a  500m )
                if(rol == "acopiador-conductor"){
                    //se muestran agencia y recojo
                    if (data.tipo == "1"){
                        solicitudPendiente.tipo = "AGENCIA LIMA"
                        solicitudPendiente.tiempo = data.tiempo!!.substring(11,19)
                        solicitudPendiente.lugar = data.recoger!!
                        solicitudPendiente.data = data.document!!.toObject(PedidoAgencia::class.java)
                        solicitudPendiente.idDocument = data.document!!.id
                        solicitudPendiente.estado = data.document!!.get("estadoServicio") as String
                        listPendiente!!.add(solicitudPendiente)
                    }
                    if (data.tipo == "2"){
                        solicitudPendiente.tipo = "CON RECOJO"
                        solicitudPendiente.tiempo = data.tiempo!!.substring(11,19)
                        solicitudPendiente.lugar = data.recoger!!
                        solicitudPendiente.data = data.document!!.toObject(PedidoCargo::class.java)
                        solicitudPendiente.idDocument = data.document!!.id
                        solicitudPendiente.estado = data.document!!.get("estadoServicio") as String
                        listPendiente!!.add(solicitudPendiente)
                    }
                }

                if(rol == "conductor"){
                    //se muestra domicilio , agencia o recojo
                    if( data.tipo == "0"){
                        solicitudPendiente.tipo = "DOMICILIO"
                        solicitudPendiente.tiempo = data.tiempo!!.substring(11,19)
                        solicitudPendiente.lugar = data.recoger!!
                        solicitudPendiente.data = data.document!!.toObject(PedidoDomicilio::class.java)
                        solicitudPendiente.idDocument = data.document!!.id
                        /*if(data.document!!.get("estadoServicio") == "0"){

                        }
                        */
                        listPendiente!!.add(solicitudPendiente)
                    }
                    if (data.tipo == "1"){
                        solicitudPendiente.tipo = "AGENCIA LIMA"
                        solicitudPendiente.tiempo = data.tiempo!!.substring(11,19)
                        solicitudPendiente.lugar = data.recoger!!
                        solicitudPendiente.data = data.document!!.toObject(PedidoAgencia::class.java)
                        solicitudPendiente.idDocument = data.document!!.id
                        solicitudPendiente.estado = data.document!!.get("estadoServicio") as String
                        listPendiente!!.add(solicitudPendiente)
                    }
                    if (data.tipo == "2"){
                        solicitudPendiente.tipo = "CON RECOJO"
                        solicitudPendiente.tiempo = data.tiempo!!.substring(11,19)
                        solicitudPendiente.lugar = data.recoger!!
                        solicitudPendiente.data = data.document!!.toObject(PedidoCargo::class.java)
                        solicitudPendiente.idDocument = data.document!!.id
                        solicitudPendiente.estado = data.document!!.get("estadoServicio") as String
                        listPendiente!!.add(solicitudPendiente)
                    }
                }

            }



        }
        adapter!!.notifyDataSetChanged()

    }

    private fun setObservers() {
        principalViewModel.apply {
            pendienteSuccess.observe(this@SolicitudesPendientesFragment, pendienteSuccessObserver)
        }
    }

    val pendienteSuccessObserver = Observer<Any>{
        adapter.list = (it as MutableList<SolicitudesDisponibles>).toList()

        adapter.notifyDataSetChanged()
    }

}
