package com.example.recycleryretrofit

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleryretrofit.databinding.ItemAppBinding

class appViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding=ItemAppBinding.bind(view)
    fun bind(entry: Entry){
        binding.idnombre1.text=entry.api
        binding.idnombre2.text=entry.description
        binding.idnombre3.text="Cors: ${entry.cors}"
    }
}