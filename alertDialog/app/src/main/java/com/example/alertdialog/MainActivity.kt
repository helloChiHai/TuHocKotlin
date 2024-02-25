package com.example.alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        openDialog()
    }

    private fun openDialog() {
        binding.btnAlertDialog.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.apply {
                // tiêu đề
                setTitle("Confirm windowm")
                // nội dung thông báo
                setMessage("Do you want close app")
                // nút không đồng ý
                setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                // nút đồng ý
                setPositiveButton("YES"){ dialogInterface: DialogInterface, i: Int ->
                    finish()
                }
                // ngăn không cho bấm ra ngoài màn hình
                setCancelable(false)
            }
            dialog.show()
        }
    }


}