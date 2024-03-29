package com.imaxcolaboradores.app.features.Principal.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.firebase.firestore.DocumentChange

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.fragments.solicitudesfragment.SolicitudesDisponibleFragment
import com.imaxcolaboradores.app.features.Principal.fragments.solicitudesfragment.SolicitudesHistorialFragment
import com.imaxcolaboradores.app.features.Principal.fragments.solicitudesfragment.SolicitudesPendientesFragment
import com.imaxcolaboradores.app.features.Principal.PrimerActivity
import com.imaxcolaboradores.app.models.Pedido
import kotlinx.android.synthetic.main.fragment_solicitudes.*
import kotlinx.android.synthetic.main.fragment_solicitudes.view.*

/**
 * A simple [Fragment] subclass.
 */
class SolicitudesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_solicitudes, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inflate the layout for this fragment

        val fragmentManager = (context as PrimerActivity).supportFragmentManager
        val adapter = ViewPagerSolicitudes(fragmentManager)
        adapter.addFragment(SolicitudesDisponibleFragment(),"Disponibles")
        adapter.addFragment(SolicitudesHistorialFragment(),"Historial")
        adapter.addFragment(SolicitudesPendientesFragment(),"Pendiente")
        vpSolicitudes.offscreenPageLimit = 0
        vpSolicitudes.adapter = adapter
        tlSolicitudes.setupWithViewPager(view.vpSolicitudes)


    }


    class ViewPagerSolicitudes(manager:FragmentManager) : FragmentPagerAdapter(manager) {

        private var fragmentList :MutableList<Fragment> = ArrayList()
        private var titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }
        fun addFragment(fragment:Fragment,title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }


    }
}
