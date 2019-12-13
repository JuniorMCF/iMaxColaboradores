package com.imaxcolaboradores.app.features.Principal.fragments


import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.imaxcolaboradores.app.R
import kotlinx.android.synthetic.main.fragment_activo.*

/**
 * A simple [Fragment] subclass.
 */
class activoFragment : Fragment() {

    private var desactivado = false


     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_activo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inflate the layout for this fragment
        btnDesactivar.setOnClickListener {
            if(desactivado){
                btnDesactivar.text = "Activar"
                txtTitulo.text = "Recuerda que cuanto más tiempo permanezcas ACTIVADO ganarás mas..."
                txtActivate.visibility = View.VISIBLE

            }else{
                btnDesactivar.text = "Desactivar"
                txtTitulo.text = "¡Excelente! sigue en este estado para que te lleguen solicitudes."
                txtActivate.visibility = View.GONE
            }
            desactivado = !desactivado

        }
    }
}
