package com.imaxcolaboradores.app.features.Entrega.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Entrega.SolicitudActivity
import com.imaxcolaboradores.app.features.Principal.PrimerActivity
import kotlinx.android.synthetic.main.fragment_rechazo_pedido.view.*

/**
 * A simple [Fragment] subclass.
 */
class RechazoPedidoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view =  inflater.inflate(R.layout.fragment_rechazo_pedido, container, false)

        view!!.imgCancelAlert.setOnClickListener{

        }



        view!!.btn_enviar.setOnClickListener{



        }


        return view
    }


}
