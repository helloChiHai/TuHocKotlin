package com.example.firebaseflutter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseflutter.R
import com.example.firebaseflutter.UserModel

class UserAdapter(private val ds: ArrayList<UserModel>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_user, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ds.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.tv_name).text = ds[position].name
            findViewById<TextView>(R.id.tv_address).text = ds[position].address
            findViewById<TextView>(R.id.tv_age).text = ds[position].age
        }
    }
}