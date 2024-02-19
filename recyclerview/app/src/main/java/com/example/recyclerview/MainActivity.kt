package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // tao danh sach gai xinh
        val dsGaiXinh = mutableListOf<GaiXinhModel>()
        dsGaiXinh.add(GaiXinhModel(R.drawable.img_1, "Gai Xinh 1", 20))
        dsGaiXinh.add(GaiXinhModel(R.drawable.img_2, "Gai Xinh 2", 18))
        dsGaiXinh.add(GaiXinhModel(R.drawable.img_3, "Gai Xinh 3", 21))
        dsGaiXinh.add(GaiXinhModel(R.drawable.img_4, "Gai Xinh 4", 19))

        // them ds vua tao vao adapter
        val adapter = RvAdapterGaiXinh(dsGaiXinh, object : IGaiXinh {
            override fun onClickItemGaiXinh(position: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "Ban da click vao: ${dsGaiXinh[position].name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        binding.rcvGaiXinh.adapter = adapter

        // hien thi theo kieu linearlayout
//        binding.rcvGaiXinh.layoutManager = LinearLayoutManager(
//            this, LinearLayoutManager.VERTICAL, false
//        )

        // hien thi theo kieu gridview
        binding.rcvGaiXinh.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
    }
}