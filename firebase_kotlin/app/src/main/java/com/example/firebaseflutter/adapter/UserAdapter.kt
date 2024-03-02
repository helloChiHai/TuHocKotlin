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
    // lắng nghe sự kiện click item trên recycleview

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener) {
        mListener = clickListener
    }

    // tạo viewholder
    class ViewHolder(itemView: View, clickListener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_user, parent, false)
        return ViewHolder(itemView, mListener)
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