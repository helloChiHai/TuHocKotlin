package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // khỏi tạo biến fragment
        val fr1 = Fragment1()
        val fr2 = Fragment2()

        // khỏi tạo fragment hiển thị mặc định
        supportFragmentManager.beginTransaction().apply {
            // thay thế cái fragment có id là fl1 bằng fragment1
            replace(R.id.fl1, fr1)
            commit()
        }

        // click vào button fr1 để chuyển sang fragment 1
        binding.btnFr1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1, fr1)
                commit()
            }
        }

        // click vào button fr2 để chuyển sang fragment 2
        binding.btnFr2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1, fr2)
                commit()
            }
        }
    }
}