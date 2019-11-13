package com.imaxcolaboradores.app.features.Principal.fragments.solicitudesfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.Adapters.HistorialAdapter
import com.imaxcolaboradores.app.features.Principal.PrincipalViewModel
import com.imaxcolaboradores.app.models.SolicitudesHistorial
import kotlinx.android.synthetic.main.fragment_solicitudes_historial.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class SolicitudesHistorialFragment : Fragment() {

    private val principalViewModel: PrincipalViewModel by viewModel()

    private val adapter: HistorialAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_solicitudes_historial, container, false)


        setObservers()
        //initAdapter()
        //obtenerData()
        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        obtenerData()
    }


    private fun initAdapter(){
        adapter.context = context!!
        adapter.list = null
        view!!.rv_Historial.layoutManager = LinearLayoutManager(context)
        view!!.rv_Historial.adapter = adapter

    }

    private fun obtenerData() {
        principalViewModel.getHistorial()
    }

    private fun setObservers() {
        principalViewModel.apply {
            historialSuccess.observe(this@SolicitudesHistorialFragment,historialSuccessObserver)
        }
    }

    val historialSuccessObserver = Observer<Any>{
        adapter.list = (it as MutableList<SolicitudesHistorial>).toList()

        adapter.notifyDataSetChanged()
    }



}
