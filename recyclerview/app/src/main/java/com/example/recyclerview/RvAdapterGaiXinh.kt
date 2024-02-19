package com.example.recyclerview

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapterGaiXinh(var ds: List<GaiXinhModel>, val onGaiXinhClick: IGaiXinh) :
    RecyclerView.Adapter<RvAdapterGaiXinh.GaiXinhHolder>() {
    // class holder
    inner class GaiXinhHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaiXinhHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return GaiXinhHolder(view)
    }

    override fun onBindViewHolder(holder: GaiXinhHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.tvName_gaiXinh).text = ds[position].name
            findViewById<TextView>(R.id.tvAge_gaiXinh).text = ds[position].age.toString()
            findViewById<ImageView>(R.id.img_gaiXinh).setImageResource(ds[position].img)

            // lang nghe su kien click item
            holder.itemView.setOnClickListener {
                onGaiXinhClick.onClickItemGaiXinh(position)
            }
        }

    }

    override fun getItemCount(): Int {
        return ds.size
    }
}