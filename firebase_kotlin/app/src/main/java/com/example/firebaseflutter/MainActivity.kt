package com.example.firebaseflutter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebaseflutter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // show srceen insert data
        showInsertData()
        // show srceen fetch data
        showFetchData()
    }

    // show srceen insert data
    private fun showInsertData() {
        binding.btnInsertData.setOnClickListener {
            val intent = Intent(this, insertActivity::class.java)
            startActivity(intent)
        }
    }

    // show srcenn fetch data
    private fun showFetchData() {
        binding.btnFetchData.setOnClickListener {
            val i = Intent(this, fetchDataActivity::class.java)
            startActivity(i)
        }
    }
}