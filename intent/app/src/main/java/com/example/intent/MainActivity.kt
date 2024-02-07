package com.example.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        SwitchToScreenSignIn()

        SwitchToScreenUrl()
    }

    // click chuyen sang man hinh signIn
    private fun SwitchToScreenSignIn() {
        binding.btnSignIn.setOnClickListener {
            val intent = Intent(this, ScreenSignIn::class.java)
            startActivity(intent)
        }
    }

    // click chuyen sang url
    private fun SwitchToScreenUrl() {
        binding.btnSwitchToUrl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/helloChiHai"))
            startActivity(intent)
        }
    }

}