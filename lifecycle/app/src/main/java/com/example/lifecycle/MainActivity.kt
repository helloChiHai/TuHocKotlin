package com.example.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.lifecycle.databinding.ActivityMain2Binding
import com.example.lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showToast("onCreate")

        Log.d("onCreate", "onCreate")

        chuyenSangManHinh2()

        chuyeSangManHinh3()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun chuyenSangManHinh2() {
        binding.btnSangManHinh2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun chuyeSangManHinh3() {
        binding.btnSangManHinh3.setOnClickListener {
            val i = Intent(this, MainActivity3::class.java)
            startActivity(i)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart", "onStart")
        showToast("onStart")
    }

    override fun onResume() {
        super.onResume()
        showToast("onResume")
        Log.d("onResume", "onResume")
    }

    override fun onPause() {
        super.onPause()
        showToast("onPause")
        Log.d("onPause", "onPause")

    }

    override fun onStop() {
        super.onStop()
        showToast("onStop")
        Log.d("onStop", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("onDestroy")
        Log.d("onDestroy", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        showToast("onReStart")
        Log.d("onRestart", "onRestart")
    }
}