package com.imaxcolaboradores.app.features.Principal.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.models.InformeIngreso
import kotlinx.android.synthetic.main.cardview_informeingreso.view.*

    class InformeIngresoAdapter: RecyclerView.Adapter<InformeIngresoAdapter.ViewHolder>() {

    var context : Context?=null
    var list : List<InformeIngreso>? = null




    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_informeingreso, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        if(list == null){
            return 0
        }else{
            return list!!.size
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.etDia.text = list!![position].dia
        holder.itemView.etMes.text = list!![position].mes
        holder.itemView.ettotalServicio.text = list!![position].total
        holder.itemView.ettotalporentregar.text = list!![position].entregar
        holder.itemView.etentregado.text = list!![position].entregado
        holder.itemView.etganancia.text = list!![position].ganancia
    }

    class ViewHolder(view : View):RecyclerView.ViewHolder(view){
    }
}
