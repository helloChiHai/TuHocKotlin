package com.example.intent_bundle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.intent_bundle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnGoToScreen2.setOnClickListener {
            val intent = Intent(this, ManHinh2::class.java)

//            // CÁCH 1: dùng bình thường putExtra
//            // truyền dữ liệu sang màn hình 2
//            intent.putExtra("fullName", "Hai dep trai")
//            intent.putExtra("age", 21)
//            intent.putExtra("address", "Ho Chi Minh")

            // CÁCH 2: dùng bundle - để bỏ dữ liệu trong 1 cái túi
            val bundle = Bundle()
            bundle.putString("fullName", null)
            bundle.putInt("age", 22)
            bundle.putString("address", "Hồ Chí Minh")

            intent.putExtras(bundle)

            startActivity(intent)
        }
    }
}