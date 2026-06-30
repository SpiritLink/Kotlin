package com.example.androidlab

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlab.databinding.ActivityMainBinding

// 버전 호환성을 위해 AppCompatActivity 를 상속받는다.
class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
//    lateinit var button: Button
//    lateinit var editView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 액티비티가 시스템 영역까지 차지하라..
        // 상단 시간 나오는 곳이 status bar 하단 버튼나오는 곳이 navigation bar
        // 두개를 합쳐서 system 영역이라 부른다.
        enableEdgeToEdge()

        // View Binding 이전 코드
//        // 화면 출력 명령.. : inflate(xml 에 명시된 뷰 객체 생성, 메모리에 올리는 작업)
//        setContentView(R.layout.activity_main)
//
//        // 필요한 뷰 객체 획득
//        textView = findViewById(R.id.textView)
//        button = findViewById(R.id.Button)
//        editView = findViewById(R.id.editView)
//
//        // 뷰에 이벤트 등록
//        button.setOnClickListener {
//            // 유저 입력값 획득
//            val data = editView.text.toString()
//            Log.d("kkang", data)
//            textView.text = editView.text.toString()
//        }

        // XXX Binding 클래스에 일은 시켜야 한다 .. 객체를 메모리에 올려달라 ..
        var binding = ActivityMainBinding.inflate(layoutInflater)

        // 화면 출력..
        setContentView(binding.root)

        // id 로 변수명
        binding.Button.setOnClickListener {
            var data = binding.editView.text.toString();
            Log.d("kkang", data)
        }

        // 시스템 영역에서 액티비티 컨텐츠를 보호해서 출력하기 위한 설정..
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}