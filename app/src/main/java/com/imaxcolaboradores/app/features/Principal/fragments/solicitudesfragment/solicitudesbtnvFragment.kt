package com.imaxcolaboradores.app.features.Principal.fragments.solicitudesfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.imaxcolaboradores.app.R

/**
 * A simple [Fragment] subclass.
 */
class solicitudesbtnvFragment : Fragment() {

    lateinit var diponiblefragment : DisponibleFragment
    lateinit var historiafragment : HistoriaFragment
    lateinit var pendientefragment : PendienteFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_solicitudesbtnv, container, false)

        val bottomNavigationView : BottomNavigationView = view.findViewById(R.id.btnv_solicitudes)

        diponiblefragment =
            DisponibleFragment()
        childFragmentManager
        .beginTransaction()
            .replace(R.id.solicitudes_layout, diponiblefragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){
                R.id.Disponibles ->{
                    diponiblefragment =
                        DisponibleFragment()
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.solicitudes_layout, diponiblefragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.Pendientes ->{
                    pendientefragment =
                        PendienteFragment()
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.solicitudes_layout, pendientefragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.Historial ->{
                    historiafragment =
                        HistoriaFragment()
                    childFragmentManager
                        .beginTransaction()
                        .replace(R.id.solicitudes_layout, historiafragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }

            }
            true
        }
        return view

    }


}
