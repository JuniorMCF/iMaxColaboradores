package com.imaxcolaboradores.app.features.Principal.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Entrega.EntregaPendienteActivity
import com.imaxcolaboradores.app.features.Principal.primerbottonviewActivity
import com.imaxcolaboradores.app.models.SolicitudesPendientes
import kotlinx.android.synthetic.main.cardview_pendientes.view.*

class PendientesAdapter:RecyclerView.Adapter<PendientesAdapter.MyViewHolder>() {

    var context : Context? = null
    var list : List<SolicitudesPendientes>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_pendientes, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(list == null){
            return 0
        }else{
            return list!!.size
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.etLugarPendientes.text = list!![position].lugar
        holder.itemView.etTiempoPendientes.text = list!![position].tiempo

        holder.itemView.cv_pendiente.setOnClickListener(){
            val intent = Intent(context , EntregaPendienteActivity::class.java)
            (context as primerbottonviewActivity).startActivity(intent)
        }

    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}