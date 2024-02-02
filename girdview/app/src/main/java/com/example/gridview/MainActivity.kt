package com.example.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.example.gridview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // khai bao list
        val list = mutableListOf<GaiXinhModel>()
        list.add(GaiXinhModel(R.drawable.img_1, "mlem 1"))
        list.add(GaiXinhModel(R.drawable.img_2, "mlem 2"))
        list.add(GaiXinhModel(R.drawable.img_3, "mlem 3"))
        list.add(GaiXinhModel(R.drawable.img_4, "mlem 4"))

        val customGV = CustomGridView(this, list)
        binding.gvGaiXinh.adapter = customGV

        binding.gvGaiXinh.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            showToast("ten cua em la: " + list[position].name_gaiXinh)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}