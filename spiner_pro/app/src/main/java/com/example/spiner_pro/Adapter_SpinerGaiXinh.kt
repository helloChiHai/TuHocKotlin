package com.example.spiner_pro

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter_SpinerGaiXinh(val activity: MainActivity, val list: List<GaiXinhClass>) :
    ArrayAdapter<GaiXinhClass>(activity, R.layout.list_gaixinh) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // position: Int: vị trí của item nằm trong list
        // convertView: View: chế độ xem từng mục của spiner
        // parent: ViewGroup: view group cha đang chứa spiner
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    // hàm xử lý view
    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexts = activity.layoutInflater
        // chuyển đổi file xml thành view
        val rowView = contexts.inflate(R.layout.list_gaixinh, parent, false)

        val imgGaiXinh = rowView.findViewById<ImageView>(R.id.img_gaiXinh)
        val nameGaiXinh = rowView.findViewById<TextView>(R.id.tv_nameGaiXinh)

        imgGaiXinh.setImageResource(list[position].imgGaiXinh)
        nameGaiXinh.text = list[position].nameGaiXinh

        return rowView
    }
}