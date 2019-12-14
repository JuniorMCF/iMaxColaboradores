package com.imaxcolaboradores.app.features.Principal.Adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.QueryDocumentSnapshot

class PedidosAdapter(var pedidoList: ArrayList<QueryDocumentSnapshot>, var mContext: Context, var pedidoIdList: ArrayList<String>?) :
    RecyclerView.Adapter<PedidosAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}