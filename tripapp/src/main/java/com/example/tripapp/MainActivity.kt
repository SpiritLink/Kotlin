package com.example.tripapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tripapp.databinding.ActivityMainBinding
import com.example.tripapp.settings.MySettingFragment
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    var initTime = 0L // back button 이 눌린 시간
    var myToast: Toast? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // object : 익명 클래스 선언 예약어
        // class A {} ==> object {}
        // class A : B () {} ==> object : b()
//        binding.mainEvent.setOnClickListener(object : View.OnClickListener {
//            override  fun onClick(p0: View?) {
//                TODO("Not yet implemented")
//                Log.d("Anonymous")
//            }
//        } )

        // 추상 함수가 하나인 인터페이스 구현한 익명 클래스를 선언할 때는 추상 함수 내용만 람다함수로
        binding.mainEvent.setOnClickListener({
            Log.d("kkang", "Anonymous")
        })

        // 어느 함수를 호출할 때, 함수의 매개변수중 마지막 매개변수가 함수 타입이라면 .. () 밖에 선언 가능 ..
//        fun some(arg1: Int, arg2: (Int) -> Int) {} ==> some(10, 20)
//        fun some(arg1: Int, arg2: (Int) -> Int) {}
//        some(10, { 10})
//        some(10){2}
        binding.mainEvent.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        // about activity 전환 용
        binding.testAboutButton.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        // myInfo activity 전환 용
        binding.testMyInfoButton.setOnClickListener {
            val intent = Intent(this, MyInfoActivity::class.java)
            startActivity(intent)
        }

        // setting activity 전환 용
        binding.testSettingButton.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

        // back button 이벤트 처리의 기본은 onKeyDown() 으로.. 키 이벤트 처리가 기본..
        // 앱에서 백버튼 이벤트 처리 비율이 높고.. 이벤트 처리 로직이 여러개 인 경우가 있어서 ...
        // api 33 에서 onKeyDown() 으로 백버튼 이벤트 처리가 deprecated 되었고 .. addCallback 으로 별도 callback 등록 방법 권장
        // api 36부터는 onKeyDown 으로 백버튼 이벤트 처리는 더이상 지원하지 않는다.
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (System.currentTimeMillis() - initTime > 3000) {
                    initTime = System.currentTimeMillis()
                    val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                    myToast?.cancel()
                    myToast = Toast.makeText(this@MainActivity, "종료하려면 한 번 더 누르세요. ${sdf.format(initTime)}", Toast.LENGTH_SHORT)
                    myToast?.show()
                } else {
                    // 현 액티비티 종료시켜라
                    myToast?.cancel()
                    myToast = Toast.makeText(this@MainActivity, "종료되었습니다.", Toast.LENGTH_SHORT)
                    myToast?.show()
                    finish()
                }
            }
        })

    }
}