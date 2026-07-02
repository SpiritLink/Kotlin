package com.example.tripapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ComposeActivity : ComponentActivity() { // AppCompatActivity 대신 ComponentActivity 권장
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MyComposeScreen {
                    finish() // 버튼 클릭 시 액티비티 종료
                }
            }
        }
    }
}

@Composable
fun MyComposeScreen(onBackClick: () -> Unit) {
    Column(modifier = Modifier.padding(24.dp)) {
        Text(
            text = "이 화면은 Jetpack Compose로 만들어졌습니다!",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "기존 View 시스템과 함께 사용할 수 있어요.",
            modifier = Modifier.padding(top = 8.dp)
        )
        Button(
            onClick = onBackClick,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("뒤로 가기")
        }
    }
}