package com.imaxcolaboradores.app.features.Principal.Adapters

import android.content.Context
import android.graphics.Color
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.models.AgenciasCheck
import kotlinx.android.synthetic.main.cardview_entregue_agencia.view.*

class AgenciasListAdapter: RecyclerView.Adapter<AgenciasListAdapter.MyViewHolder>() {

    var list: List<AgenciasCheck>?=null
    var context: Context?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_entregue_agencia, parent, false)
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
        holder.itemView.txtAgencia.text = "${list!![position].agencia}"
        holder.itemView.cbAgencia.visibility = View.INVISIBLE
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}