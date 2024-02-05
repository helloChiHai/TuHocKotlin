package com.example.thuchanhthietkegiaodienwelcomevoishape

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thuchanhthietkegiaodienwelcomevoishape.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}