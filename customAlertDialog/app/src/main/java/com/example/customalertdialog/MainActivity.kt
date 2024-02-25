package com.example.customalertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.customalertdialog.databinding.ActivityMainBinding
import com.example.customalertdialog.databinding.LayoutCustomalertdialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowAlertDialog.setOnClickListener {
            showAlertDialogViewBinding()
        }
    }

    private fun showAlertDialogViewBinding() {
        val build = AlertDialog.Builder(this, R.style.ThemeCustom)
        val view = LayoutCustomalertdialogBinding.inflate(LayoutInflater.from(this))
        // set view
        build.setView(view.root)
        // khoi tao dialog
        dialog = build.create()

        // xu ly nhan nut close
        view.btnClose.setOnClickListener { dialog.dismiss() }

        // xu ly khi nhan nut join
        view.btnJoinNow.setOnClickListener {
            showToast("you joined!!!")
        }

        // show dialog
        dialog.show()
    }

    private fun showAlertDialogNormal() {
        val build = AlertDialog.Builder(this, R.style.ThemeCustom)
        // chuyen layout_customalertdialog thanh view
        val view = layoutInflater.inflate(R.layout.layout_customalertdialog, null)
        // set view
        build.setView(view)

        // xu ly khi nhan nut close
        val btnClose = view.findViewById<Button>(R.id.btn_close)
        btnClose.setOnClickListener {
            dialog.dismiss()
        }

        // xu ly khi nhan nut join
        val btnJoin = view.findViewById<Button>(R.id.btn_joinNow)
        btnJoin.setOnClickListener {
            showToast("You joined")
        }
        // khoi tao dialog
        dialog = build.create()
        // show dialog
        dialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}