package com.imaxcolaboradores.app.features.Principal.Adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Entrega.SolicitudActivity

import com.imaxcolaboradores.app.models.SolicitudesDisponibles
import kotlinx.android.synthetic.main.cardview_disponible.view.*


class DisponiblesAdapter: RecyclerView.Adapter<DisponiblesAdapter.MyViewHolder>() {

    var context : Context?=null
    var list : List<SolicitudesDisponibles>? = null


    override fun getItemCount(): Int {
        if(list == null){
            return 0
        }else{
            return list!!.size
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.etLugarDisponible.text = list!![position].lugar
        holder.itemView.etTiempoDisponible.text = list!![position].tiempo
        holder.itemView.etTipo.text = list!![position].tipo

        if(list!![position].lugar == ""){
            holder.itemView.etEntregaDisponible.text  = ""
        }
        holder.itemView.cv_disponible.setOnClickListener{
            val intent = Intent(context , SolicitudActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("pedidoDisponible",list!![position])
            intent.putExtra("bundle",bundle)
            context!!.startActivity(intent)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_disponible, parent, false)
        return MyViewHolder(view)
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}