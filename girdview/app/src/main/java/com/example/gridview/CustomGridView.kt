package com.example.gridview

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomGridView(val activity: MainActivity, val list: List<GaiXinhModel>) :
    ArrayAdapter<GaiXinhModel>(activity, R.layout.item_gaixinh) {
    override fun getCount(): Int {
        return list.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val context = activity.layoutInflater
        val rowView = context.inflate(R.layout.item_gaixinh, parent, false)

        val images = rowView.findViewById<ImageView>(R.id.img_gaiXinh)
        val nameGaiXinh = rowView.findViewById<TextView>(R.id.name_gaiXinh)

        images.setImageResource(list[position].img_gaiXinh)
        nameGaiXinh.text = list[position].name_gaiXinh

        return rowView
    }


}