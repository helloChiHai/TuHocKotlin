package com.example.listview_basic

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listview_basic.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var ds: MutableList<String> = mutableListOf("Việt Nam", "Nga", "Cu ba", "Lào")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lvQuocGia.adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,
            ds
        )

        addEvents()
    }

    private fun addEvents() {
        // hiển thị danh sách cố định các quốc gia
//        hienThiListQuocGia_dsCoDinh()

        // hiển thị danh sách không cố định các quốc gia
        hienThiListQuocGia_dsKhongCoDinh()

        // thực hiêện chức năng thêm quốc gia
        xuLyThemQuocGia()
    }

    private fun xuLyThemQuocGia() {

        binding.btnXacNhanThemQG.setOnClickListener {

            var qgThem: String = binding.edtNhapQuocGia.text.toString()
            ds.add(qgThem)
            if (ds.add(qgThem)) {
                binding.lvQuocGia.adapter =
                    ArrayAdapter(this, android.R.layout.simple_list_item_1, ds)

                Toast.makeText(this, "Thêm quốc gia thành công", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Thêm quốc gia không thành công", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun hienThiListQuocGia_dsKhongCoDinh() {

    }

    // danh sách cố định
    private fun hienThiListQuocGia_dsCoDinh() {
        // khai báo arrayQuocGia, dùng resoure để lấy thông tin từ string
        var arrayQuocGia = resources.getStringArray(R.array.arrayQuocGia)

        // sử dụng adapter để lấy dữ liệu và hiển thị lên view
        binding.lvQuocGia.adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,
            arrayQuocGia
        )

        // thực hiện sự kiện lắng nghe khi người dùng click vào item của listview
        binding.lvQuocGia.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Bạn vừa chọn " + arrayQuocGia[position], Toast.LENGTH_SHORT)
                .show()
        }
    }


}