package com.imaxcolaboradores.app.features.Entrega.fragments.Asignados


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.imaxcolaboradores.app.R

/**
 * A simple [Fragment] subclass.
 */
class EntregueAsignacionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entregue_asignacion, container, false)
    }


}
