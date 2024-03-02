package com.example.firebaseflutter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseflutter.databinding.ActivityInsertBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class insertActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInsertBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbRef = FirebaseDatabase.getInstance().getReference("User")

        // xu ly su kien lick save data
        binding.btnSaveData.setOnClickListener {
            saveDataUser()
        }
    }

    private fun saveDataUser() {
        // get value
        val nameUser = binding.edtName.text.toString()
        val ageUser = binding.edtAge.text.toString()
        val addressUser = binding.edtAddress.text.toString()

        // đẩy dữ liệu
        val idUser = dbRef.push().key!!
        val user = UserModel(idUser, nameUser, ageUser, addressUser)

        if (checkValueEditText(nameUser, ageUser, addressUser)) {
            dbRef.child(idUser).setValue(user)
                .addOnCompleteListener {
                    showToast("Add user successful")
                }
                .addOnFailureListener { e ->
                    showToast("Add user failure: ${e.message}")
                }
        } else {
            showToast("Please enter complete information")
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun checkValueEditText(name: String, age: String, address: String): Boolean {
        return !(name.isEmpty() || age.isEmpty() || address.isEmpty())
    }
}