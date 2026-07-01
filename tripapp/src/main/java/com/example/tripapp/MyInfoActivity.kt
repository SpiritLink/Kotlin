package com.example.tripapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tripapp.databinding.ActivityMyInfoBinding
import com.example.tripapp.db.insertInfo
import com.example.tripapp.db.selectInfo

class MyInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityMyInfoBinding

    var email: String? = null
    var phone: String? = null
    var photo: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMyInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 액티비티가 실행되면서 db 저장된 데이터가 있다면 .. select 해서 출력..
        // let {}, run {}, with {}, apply {}
        var cursor = selectInfo(this)
        cursor?.let {
            // not null......
            if(cursor.moveToFirst()){
                binding.run {
                    email = cursor.getString(1)
                    phone = cursor.getString(2)
                    photo = cursor.getString(3)

                    // 화면 출력
                    myInfoEmail.setText(email)
                    myInfoPhone.setText(phone)
                }
            }
        }

        binding.testSaveButton.setOnClickListener {
            // 유저 입력 데이터 획득 ..
            binding.run {
                email = myInfoEmail.text.toString()
                phone = myInfoPhone.text.toString()
            }

            if(email?.isNotEmpty() ?: false){
                if(insertInfo(this, email ?: "", phone, photo)){
                    Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()
                    // 액티비티 종료시켜서.. 이전 화면으로 자동 전환되게..
                    finish()
                } else {
                    Toast.makeText(this, "저장에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "이메일은 필수 입력 항목입니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}