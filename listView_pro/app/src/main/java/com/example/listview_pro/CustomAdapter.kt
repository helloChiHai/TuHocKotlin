package com.example.listview_pro

import android.annotation.SuppressLint
import android.app.Activity
import android.icu.text.CaseMap.Title
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(val activity: MainActivity, val list: List<OutData>) :
    ArrayAdapter<OutData>(activity, R.layout.list_item) {
    // alt + insert

    // getCount là quy định vẽ bao nhiêu dòng lên view
    override fun getCount(): Int {
        return list.size // vẽ lên view hết tất cả các dòng có trong list
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val contexts =
            activity.layoutInflater // layoutInflater có tác dụng chuyển file xml thành view

        val rowView = contexts.inflate(R.layout.list_item, parent, false)

        val images = rowView.findViewById<ImageView>(R.id.img)
        val title = rowView.findViewById<TextView>(R.id.title)
        val description = rowView.findViewById<TextView>(R.id.description)

        title.text = list[position].title
        description.text = list[position].description
        images.setImageResource(list[position].img)

        return rowView
    }
}