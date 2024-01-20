package com.example.spiner_pro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.spiner_pro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpCustomSpiner()
    }

    private fun setUpCustomSpiner() {
        // khai báo list gái xinh vào listGaiXinh
        var listGaiXinh = mutableListOf<GaiXinhClass>()
        listGaiXinh.add(GaiXinhClass(R.drawable.img_1, "Em đào 1"))
        listGaiXinh.add(GaiXinhClass(R.drawable.img_2, "Em đào 2"))
        listGaiXinh.add(GaiXinhClass(R.drawable.img_3, "Em đào 3"))
        listGaiXinh.add(GaiXinhClass(R.drawable.img_4, "Em đào 4"))

        // tạo adapter gái xinh
        val adapterGaiXinh = Adapter_SpinerGaiXinh(this, listGaiXinh)

        // gán apdaterGaiXinh vào spiner gái xinh
        binding.spGaiXinh.adapter = adapterGaiXinh

        // xử lý click item vào list gái xinh
        binding.spGaiXinh.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                showToast(listGaiXinh[position].nameGaiXinh)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}