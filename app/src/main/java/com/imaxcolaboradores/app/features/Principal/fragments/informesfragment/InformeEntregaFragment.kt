package com.imaxcolaboradores.app.features.Principal.fragments.informesfragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.Adapters.InformeIngresoAdapter
import com.imaxcolaboradores.app.models.InformeIngreso
import com.imaxcolaboradores.app.features.Principal.primerbottonViewModel
import kotlinx.android.synthetic.main.fragment_informe_entrega.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class InformeEntregaFragment : Fragment() {

    private val primerbottonViewModel: primerbottonViewModel by viewModel()

    private val adapter : InformeIngresoAdapter by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_informe_entrega, container, false)

        setObservers()


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        obtenerData()
    }

    private fun obtenerData() {
        primerbottonViewModel.getInforme()
    }

    private fun initAdapter(){
        adapter.context = context!!
        adapter.list = null
        view!!.rv_informeingreso.layoutManager = LinearLayoutManager(context)
        view!!.rv_informeingreso.adapter = adapter

    }



    private fun setObservers() {
        primerbottonViewModel.apply {
            informeentregaSuccess.observe(this@InformeEntregaFragment, informeentregaSuccessObserver)
        }
    }
    private val informeentregaSuccessObserver = Observer<Any>{

        Log.d("aca","data $it")
        adapter.list = (it as MutableList<InformeIngreso>).toList()

        adapter.notifyDataSetChanged()
    }
}
