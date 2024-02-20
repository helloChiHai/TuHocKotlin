package com.example.recyclerview_staggered

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerview_staggered.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        xuLy()
    }

    private fun xuLy() {
        var dsGaiXinh = mutableListOf<Int>()
        dsGaiXinh.add(R.drawable.img_1)
        dsGaiXinh.add(R.drawable.img_2)
        dsGaiXinh.add(R.drawable.img_3)
        dsGaiXinh.add(R.drawable.img_4)

        // cấu hình layout
        binding.rcvGaiXinh.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )
        
        // tạo biến item adapter
        val itemAdapter = adapterGaiXinh(dsGaiXinh)

        // gán item adapter vào recyclerview adapter
        binding.rcvGaiXinh.adapter = itemAdapter
    }
}