package com.example.nevigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.nevigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // xử lý sự kiện click vào item menu của navigation
        binding.navLeftMenu.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_setting -> showToast("Setting")
                R.id.menu_message -> showToast("Message")
                R.id.menu_exit -> finish()
            }
            true
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}