package com.example.listview_pro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.example.listview_pro.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // khai bao danh sach cac item
        var list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.img_1, "Nguyen van a", "xinh mlem mlem"))
        list.add(OutData(R.drawable.img_2, "Nguyen van b", "xinh mlem mlem"))
        list.add(OutData(R.drawable.img_3, "Nguyen van c", "xinh mlem mlem"))
        list.add(OutData(R.drawable.img_4, "Nguyen van d", "xinh mlem mlem"))

        customAdapter = CustomAdapter(this, list)

        // khai báo biến để link đến lvGaiXinh
        val lvGaiXinh = binding.lvGaiXinh
        lvGaiXinh.adapter = customAdapter

        // xu ly khi nhan vao item trong list gai xinh
        lvGaiXinh.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    this,
                    "Ban da click vao: " + list[position].title,
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
    }
}