package com.example.datepicker_timepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datepicker_timepicker.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val today = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // 1. set thời gian khi click vào imgButton timePicker
        binding.btnTimePicker.setOnClickListener {
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                binding.tvTimePicker.setText("$hourOfDay : $minute")
            }, 0, 0, true).show()
        }

        // 2. set ngày tháng năm khi click vào imgButton datePicker
        binding.btnSchedule.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                binding.tvSchedule.setText("$dayOfMonth/${month + 1}/$year")
            }, 2024, 1,1).show()
        }
    }
}