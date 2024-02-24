package com.example.tablayout_viewpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.lifecycle.Lifecycle
import com.example.tablayout_viewpage.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // tạo adapter pager
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        // gán viewPagerAdapter vào pager
        binding.pagerGaiXinh.adapter = viewPagerAdapter

        // xử lý tablayout
        TabLayoutMediator(
            binding.tabGaiXinh,
            binding.pagerGaiXinh
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "Gái xinh 1"
                1 -> tab.text = "Gái xinh 2"
                2-> tab.text = "Gái xinh 3"
            }
        }.attach()
    }
}