package com.example.androidlab

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// 버전 호환성을 위해 AppCompatActivity 를 상속받는다.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 액티비티가 시스템 영역까지 차지하라..
        // 상단 시간 나오는 곳이 status bar 하단 버튼나오는 곳이 navigation bar
        // 두개를 합쳐서 system 영역이라 부른다.
        enableEdgeToEdge()

        // 화면 출력 명령..
        setContentView(R.layout.activity_main)

        // 시스템 영역에서 액티비티 컨텐츠를 보호해서 출력하기 위한 설정..
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}