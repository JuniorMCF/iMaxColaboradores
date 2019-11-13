package com.imaxcolaboradores.app.features.Principal.fragments.solicitudesfragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.Adapters.DisponiblesAdapter
import com.imaxcolaboradores.app.features.Principal.PrincipalViewModel
import com.imaxcolaboradores.app.models.SolicitudesDisponibles
import kotlinx.android.synthetic.main.fragment_solicitudes_disponible.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 */
class SolicitudesDisponibleFragment : Fragment() {

    private val principalViewModel: PrincipalViewModel by viewModel()

    private val adapter: DisponiblesAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_solicitudes_disponible, container, false)

        setObservers()


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        obtenerData()
    }

    private fun obtenerData() {
        principalViewModel.getDisponibles()
    }

    private fun initAdapter(){
        adapter.context = context!!
        adapter.list = null
        view!!.rv_Disponible.layoutManager = LinearLayoutManager(context)
        view!!.rv_Disponible.adapter = adapter

    }



    private fun setObservers() {
        principalViewModel.apply {
            disponibleSuccess.observe(this@SolicitudesDisponibleFragment, disponibleSuccessObserver)
        }
    }

    private val disponibleSuccessObserver = Observer<Any>{
        Log.d("aca","data $it")
        adapter.list = (it as MutableList<SolicitudesDisponibles>).toList()

        adapter.notifyDataSetChanged()
    }


}
