package com.imaxcolaboradores.app.features.Entrega.fragments.Agencia


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.imaxclientes.app.models.PedidoAgencia

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Entrega.SolicitudActivity
import com.imaxcolaboradores.app.features.Entrega.fragments.Domicilio.DomicilioEntregarFragment
import com.imaxcolaboradores.app.models.SolicitudesDisponibles
import kotlinx.android.synthetic.main.fragment_servicio_agencia.view.*

/**
 * A simple [Fragment] subclass.
 */
class ServicioAgenciaFragment : Fragment() {

    private lateinit var pedidoAgencia: PedidoAgencia
    private lateinit var solicitud: SolicitudesDisponibles


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_servicio_agencia, container, false)


        solicitud = (context as SolicitudActivity).solicitud



        if(solicitud!!.tipo=="AGENCIA LIMA"){
            pedidoAgencia = solicitud!!.data!! as PedidoAgencia
            (context as SolicitudActivity).supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,ServicioAgenciaFragment(),"servicio_agencia").commit()

        }

        //initButtons(view)






        return view
    }
    /*
    fun initButtons(view:View){

        view.btnRecogiAcopiadores.setOnClickListener{
            val builder = AlertDialog.Builder(ContextThemeWrapper(context, R.style.AlertDialogCustom))

            with(builder) {
                setTitle(solicitud.tipo)
                setMessage("¿Recogió el pedido?")
                setPositiveButton("Ok") { dialog, which ->
                    if (solicitud.tipo == "AGENCIA LIMA") {
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


                }


        }


    }

*/
}
