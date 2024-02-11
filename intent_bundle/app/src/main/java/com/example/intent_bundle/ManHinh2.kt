package com.example.intent_bundle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.intent_bundle.databinding.ActivityManHinh2Binding

class ManHinh2 : AppCompatActivity() {
    private lateinit var bindingManhinh2: ActivityManHinh2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingManhinh2 = ActivityManHinh2Binding.inflate(layoutInflater)
        setContentView(bindingManhinh2.root)

//        // lấy dữ liệu từ main activity - dùng putExtra
//        val i = intent
//        val fullName_user = i.getStringExtra("fullName")
//        val age_user = i.getIntExtra("age", 0)
//        val address_user = i.getStringExtra("address")

//        Log.d("full name", fullName_user.toString())

        // CÁCH 2: LẤY DỮ LIỆU TỪ BUNDLE
        val i = intent
        val bundle = i.extras
        if(bundle != null){
            val fullName_user = bundle.getString("fullName")
            val age_user = bundle.getInt("age", 0)
            val address_user = bundle.getString("address")

            // gán giá trị vừa nhận vào tv
            bindingManhinh2.tvName.text = fullName_user
            bindingManhinh2.tvAge.text = age_user.toString()
            bindingManhinh2.tvAddress.text = address_user
        }


    }
}