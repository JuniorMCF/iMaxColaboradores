package com.imaxcolaboradores.app.features.Entrega.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Entrega.EntregaRealizadaActivity

/**
 * A simple [Fragment] subclass.
 */
class DetalleSolicitudFinal : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_detalle_solicitud_final, container, false)




        return view
    }


}
