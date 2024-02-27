package com.example.contextmenu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.contextmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // đăng ký context option menu
        registerForContextMenu(binding.tvContextMenu)
    }

    // khởi tạo option menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // add(int groupId, int itemId, int order(thứ tự hiển thị), Char title)
        menu?.add(1, 1, 1, "Red")
        menu?.add(1, 2, 2, "Blue")
        menu?.add(1, 3, 3, "Black")

        // sub menu
        var subMenu = menu?.addSubMenu("Giới tính")
        // set mặc định mới vào là chọn Male
        subMenu?.add(2, 21, 1, "Male")?.setChecked(true)
        subMenu?.add(2, 20, 2, "FeMale")
        //setGroupCheckable(groupId,
        // true: cho phép dấu kiểu, false: không cho phép, mặc định là false
        // true: cho phép chọn 1 item, false: cho phép chọn nhiều item
        subMenu?.setGroupCheckable(2, true, true)

        return super.onCreateOptionsMenu(menu)
    }

    // xử lý khi chọn vào option menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                binding.tvOptionMenu.setTextColor(Color.RED)
            }

            2 -> {
                binding.tvOptionMenu.setTextColor(Color.BLUE)
            }

            3 -> {
                binding.tvOptionMenu.setTextColor(Color.BLACK)
            }

            // tương tác với sub menu
            21 -> {
                binding.tvOptionMenu.setText("Male")
            }

            20 -> {
                binding.tvOptionMenu.setText("FeMale")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // khởi tạo context menu
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu?.add(3, 100, 1, "650+ Toeic")
        menu?.add(3, 101, 2, "700+ Toeic")
        menu?.add(3, 102, 3, "750+ Toeic")
        menu?.setHeaderTitle("Mời chọn điểm Toeic")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    // xử lý khi chọn vào context menu
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            100 -> {
                binding.tvContextMenu.setText("Chúc mừng bạn được 650 Toeic")
            }

            101 -> {
                binding.tvContextMenu.setText("Chúc mừng bạn được 700 Toeic")
            }

            102 -> {
                binding.tvContextMenu.setText("Chúc mừng bạn được 750 Toeic")
            }
        }
        return super.onContextItemSelected(item)
    }
}