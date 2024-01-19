package com.example.imagebuton_imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.imagebuton_imageview.databinding.ActivityMainBinding

private lateinit var binding:ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        addEvents()
    }

    private fun addEvents() {
        binding.rdoImg1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                binding.imgHinhAnhDuocChon.setImageResource(R.drawable.img_1)
            }
        }
        binding.rdoImg2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                binding.imgHinhAnhDuocChon.setImageResource(R.drawable.img_2)
            }
        }
    }
}