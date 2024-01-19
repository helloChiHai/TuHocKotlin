package com.example.spiner_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.spiner_basic.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setUpSpinerCoBan()

        crudSpiner()
    }

    private fun crudSpiner() {
        val listSoThich = mutableListOf<String>()
        val adapterSoThich = ArrayAdapter(this, android.R.layout.simple_spinner_item, listSoThich)

        binding.spSoThich.adapter = adapterSoThich

        eventClickThemSoThich(listSoThich, adapterSoThich)
    }

    private fun eventClickThemSoThich(
        listSoThich: MutableList<String>,
        adapterSoThich: ArrayAdapter<String>
    ) {
        binding.btnThemSoThich.setOnClickListener {
            if (binding.edtSoThich.text.toString().isNotEmpty()) {
                listSoThich.add(binding.edtSoThich.text.toString())
                // dữ liệu đã thay đổi và cần phải cập nhật giao diện
                adapterSoThich.notifyDataSetChanged()
                showToast("Thêm sở thích thành công")
            } else {
                showToast("Thêm sở thích thất bại")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setUpSpinerCoBan() {
        // tạo 1 list ngôn ngữ
        val listNgonNgu = resources.getStringArray(R.array.ngonNgu)

        // tạo 1 array adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listNgonNgu)

        // gán adapter vào spiner adapter
        binding.spNgonNgu.adapter = adapter

        // thực hiện sự kiện click khi click vào item trong spiner
        binding.spNgonNgu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            // thực hiện khi click vào spiner
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                showToast(listNgonNgu[position])
            }

            // thực hện khi không click vào spiner
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}