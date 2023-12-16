package com.example.recycleryretrofit

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class appAdapter(val entries: List<Entry>) : RecyclerView.Adapter<appViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): appViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return  appViewHolder(layoutInflater.inflate(R.layout.item_app,parent,false))
    }

    override fun getItemCount(): Int =entries.size

    override fun onBindViewHolder(holder: appViewHolder, position: Int) {
        val item= entries[position]
        holder.bind(item)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetalleApp::class.java)
            intent.putExtra("nombre", item.api)
            intent.putExtra("Descripcion", item.description)
            intent.putExtra("autorización", item.auth)
            intent.putExtra("Cors", item.cors)
            intent.putExtra("Link", item.link)
            intent.putExtra("Categoria", item.category)
            holder.itemView.context.startActivity(intent)
        }
    }


}