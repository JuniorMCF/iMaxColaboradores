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
import com.imaxcolaboradores.app.features.Principal.PrimerActivity
import com.imaxcolaboradores.app.models.SolicitudesDisponibles
import kotlinx.android.synthetic.main.cardview_disponible.view.*
import kotlinx.android.synthetic.main.cardview_pendientes.view.*

class PendientesAdapter:RecyclerView.Adapter<PendientesAdapter.MyViewHolder>() {

    var context : Context? = null
    var list : List<SolicitudesDisponibles>? = null

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
        holder.itemView.etTipoDisponible.text = list!![position].tipo
        if(list!![position].lugar == ""){
            holder.itemView.etEntregaDisponible.text  = ""
        }

        holder.itemView.cv_pendiente.setOnClickListener(){
            if(list!![position].estado == "1"){  // 1 :ir a recoger  2: ir a entregar  3:entregado  , el 0 es cuando esta disponible por aceptar
                val intent = Intent(context , SolicitudActivity::class.java)   //IR A RECOGER
                val bundle = Bundle()
                bundle.putSerializable("pedidoDisponible",list!![position])
                intent.putExtra("bundle",bundle)

                (context as PrimerActivity).startActivity(intent)
            }
            if(list!![position].estado == "2"){ //
                val intent = Intent(context , SolicitudActivity::class.java)    //  EN CAMINO
                val bundle = Bundle()
                bundle.putSerializable("pedidoDisponible",list!![position])
                intent.putExtra("bundle",bundle)

                (context as PrimerActivity).startActivity(intent)
            }
            if(list!![position].estado == "3"){
                val intent = Intent(context , SolicitudActivity::class.java)   // ENTREGADO
                val bundle = Bundle()
                bundle.putSerializable("pedidoDisponible",list!![position])
                intent.putExtra("bundle",bundle)
                (context as PrimerActivity).startActivity(intent)
            }

        }

    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}