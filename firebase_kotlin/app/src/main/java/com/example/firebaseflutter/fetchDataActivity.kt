package com.example.firebaseflutter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebaseflutter.adapter.UserAdapter
import com.example.firebaseflutter.databinding.ActivityFetchDataBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class fetchDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFetchDataBinding

    private lateinit var ds: ArrayList<UserModel>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFetchDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        // reverseLayout: đảo ngược vị trí của mảng
        layoutManager.reverseLayout = true
        // stackFromEnd: cho phép đảo ngược vị tríbawstt đầu của layout
        layoutManager.stackFromEnd = true
        binding.rvUser.layoutManager = layoutManager
        // setHasFixedSize: đặt RecyclerView có id có kích thước cố định
        binding.rvUser.setHasFixedSize(true)
        ds = arrayListOf<UserModel>()

        getInformationUser()
    }

    private fun getInformationUser() {
        binding.rvUser.visibility = View.GONE
        binding.tvLoading.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("User")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                ds.clear()
                // nếu snapshot có dữ liệu (true: là có dữ liệu, false: không có dữ liệu
                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val userData = userSnapshot.getValue(UserModel::class.java)
                        ds.add(userData!!)
                    }
                    val mAdapter = UserAdapter(ds)
                    binding.rvUser.adapter = mAdapter

                    // thay đổi khi có dữ liệu
                    binding.rvUser.visibility = View.VISIBLE
                    binding.tvLoading.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}