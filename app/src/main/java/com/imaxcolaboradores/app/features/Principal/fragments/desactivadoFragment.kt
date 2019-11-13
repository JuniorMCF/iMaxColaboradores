package com.imaxcolaboradores.app.features.Principal.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.primerbottonviewActivity
import kotlinx.android.synthetic.main.fragment_desactivado.*

/**
 * A simple [Fragment] subclass.
 */
class desactivadoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_desactivado, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inflate the layout for this fragment
        btn_activar.setOnClickListener {

            (context as primerbottonviewActivity)
                .supportFragmentManager
                .beginTransaction()
                .add(R.id.frame_layaout,
                    activoFragment(),"desactivadofragment")
                .addToBackStack("null").commit()

        }
    }
}