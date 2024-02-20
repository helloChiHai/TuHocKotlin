package com.example.recyclerview_staggered

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class adapterGaiXinh(val ds: List<Int>) : RecyclerView.Adapter<adapterGaiXinh.itemViewHolder>() {
    class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_gaixinh,
            parent, false
        )
        return itemViewHolder(view)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<ImageView>(R.id.img_gaiXinh).setImageResource(ds[position])
        }
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}