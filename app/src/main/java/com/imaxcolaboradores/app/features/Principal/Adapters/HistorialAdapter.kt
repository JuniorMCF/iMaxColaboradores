package com.imaxcolaboradores.app.features.Principal.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.fragments.solicitudesfragment.HistorialDetalleFragment
import com.imaxcolaboradores.app.features.Principal.primerbottonviewActivity
import com.imaxcolaboradores.app.models.SolicitudesHistorial
import kotlinx.android.synthetic.main.cardview_historial.view.*

class HistorialAdapter: RecyclerView.Adapter<HistorialAdapter.MyViewHolder>() {



    var context : Context? = null
    var list : List<SolicitudesHistorial>? = null



    override fun getItemCount(): Int {
        if(list == null){
            return 0
        }else{
            return list!!.size
        }
    }

    override fun onBindViewHolder(holder: HistorialAdapter.MyViewHolder, position: Int) {
       holder.itemView.ettotalporentregar.text = list!![position].lugar
        holder.itemView.etPagoHistorial.text = list!![position].pago
        holder.itemView.etGanancia.text = list!![position].direccion
        holder.itemView.etCajasHistorial.text = list!![position].cajas


        holder.itemView.cv_historial.setOnClickListener{
            (context as primerbottonviewActivity).supportFragmentManager.beginTransaction().add(R.id.container_pantalla_total,HistorialDetalleFragment(),"historial_detalle_fragment").addToBackStack(null).commit()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_historial, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}