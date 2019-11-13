package com.imaxcolaboradores.app.features.Principal.fragments.solicitudesfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.primerbottonviewActivity

/**
 * A simple [Fragment] subclass.
 */
class PendienteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (context as primerbottonviewActivity)
            .supportFragmentManager
            .beginTransaction()
            .add(R.id.ccPendiente,
                SolicitudesPendientesFragment(),"solicitudesdisponibles")
            .addToBackStack("null").commit()
        return inflater.inflate(R.layout.fragment_pendiente, container, false)
    }


}
