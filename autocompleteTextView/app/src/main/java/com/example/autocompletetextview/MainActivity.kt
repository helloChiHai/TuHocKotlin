package com.example.autocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.autocompletetextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // khai báo danh sách tỉnh thành
        val listTinhThanh = resources.getStringArray(R.array.arrayTinhThanh)

        // khai báo adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listTinhThanh)

        // gán adapter vào adapter autocompleteTexTView
        binding.autoCompleteTinhThanh.setAdapter(adapter)

        // xử lý khi chọn vào autocompleTextView
        binding.autoCompleteTinhThanh.setOnItemClickListener { parent, view, position, id ->
            showToast("Bạn đã chọn vào: " + binding.autoCompleteTinhThanh.text.toString())
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}