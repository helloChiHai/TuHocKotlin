package com.example.firebaseflutter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseflutter.databinding.ActivityDetailUserBinding
import com.example.firebaseflutter.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setValueToView()

        binding.btnDelete.setOnClickListener {
            deleteUser(intent.getStringExtra("idUser").toString())
        }
    }

    private fun deleteUser(id: String) {
        val db = FirebaseDatabase.getInstance().getReference("User").child(id)
        val mTask = db.removeValue()
        mTask.addOnSuccessListener {
            showToast("Delete user ${intent.getStringExtra("nameUser").toString()} successful")
            val intent = Intent(this, fetchDataActivity::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener { e ->
            showToast("Delete user ${e.message}")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setValueToView() {
        binding.tvIdUser.text = intent.getStringExtra("idUser")
        binding.tvNameUser.text = intent.getStringExtra("nameUser")
        binding.tvAgeUser.text = intent.getStringExtra("ageUser")
        binding.tvAddressUser.text = intent.getStringExtra("addressUser")
    }
}