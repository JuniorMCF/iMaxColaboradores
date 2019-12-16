package com.imaxcolaboradores.app.features.Entrega.fragments.Domicilio


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.imaxcolaboradores.app.R
import kotlinx.android.synthetic.main.fragment_domicilio_realizado.*

/**
 * A simple [Fragment] subclass.
 */
class DomicilioRealizadoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_domicilio_realizado, container, false)
/*
        //enviado desde la actividad
        if (solicitudEntregado!!.tipo == "DOMICILIO") {
            pedidoDomicilio = solicitudEntregado!!.data!! as PedidoDomicilio


        } else if (solicitudEntregado!!.tipo == "AGENCIA LIMA") {
            pedidoAgencia = solicitudEntregado!!.data!! as PedidoAgencia


        } else if (solicitudEntregado!!.tipo == "CON RECOJO") {
            pedidoCargo = solicitudEntregado!!.data!! as PedidoCargo


        } else if (solicitudEntregado!!.tipo == "SIN RECOJO") {
            pedidoCargo = solicitudEntregado!!.data!! as PedidoCargo


        }
        //BOTONES PARA LOS TELEFONOS
        imgContactoPhone.setOnClickListener {

        }
        imgClientePhone.setOnClickListener {

        }




        btnEntregado.setOnClickListener{

        }
   */

        return view
    }


}
