package com.example.tripapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeDeveloperScreen(
                        onBackClick = { finish() }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeDeveloperScreen(onBackClick: () -> Unit) {
    val context = LocalContext.current
    var clickCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // 안드로이드 초록색 느낌의 컬러 박스 로고
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(Color(0xFF3DDC84), RoundedCornerShape(4.dp))
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Android Developers",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFE8F5E9), // 연한 안드로이드 그린 계열 배경
                            MaterialTheme.colorScheme.background
                        ),
                        endY = 600f
                    )
                ),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // 1. Hero Section
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Jetpack Compose",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF073042), // 안드로이드 브랜드 다크 네이비
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Android의 현대적인 네이티브 UI 툴킷",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF3DDC84), // 안드로이드 그린
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Jetpack Compose는 네이티브 UI를 빌드하기 위한 Android의 권장 최신 도구 키트입니다. 적은 양의 코드, 강력한 도구, 직관적인 Kotlin API로 앱에 신속하게 생명을 불어넣을 수 있어 Android의 UI 개발을 간소화하고 가속화합니다.",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/compose?hl=ko"))
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF073042))
                        ) {
                            Text("시작하기", color = Color.White)
                        }
                        OutlinedButton(
                            onClick = {
                                Toast.makeText(context, "Compose 빌드 환경 세팅 완료!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF073042))
                        ) {
                            Text("문서 보기")
                        }
                    }
                }
            }

            // 2. Interactive Demo Section (선언형 UI 상태 체감)
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "💡 선언형 UI 인터랙션 체험",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF073042)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "아래 버튼을 누르면 상태(State)가 변하고, 화면이 실시간으로 재구성(Recomposition)됩니다. XML 바인딩이나 findViewById 없이 코드 몇 줄로 즉각적인 상태 연동이 완성됩니다.",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                            lineHeight = 16.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFF282C34), RoundedCornerShape(8.dp))
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "var clicks by remember { mutableStateOf(0) }",
                                    color = Color(0xFFABB2BF),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily.Monospace
                                )
                                Text(
                                    text = "Button(onClick = { clicks++ }) {",
                                    color = Color(0xFF61AFEF),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily.Monospace
                                )
                                Text(
                                    text = "    Text(\"클릭 횟수: \$clicks\")",
                                    color = Color(0xFF98C379),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily.Monospace
                                )
                                Text(
                                    text = "}",
                                    color = Color(0xFF61AFEF),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(
                                onClick = { clickCount++ },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3DDC84))
                            ) {
                                Text("클릭: $clickCount", color = Color(0xFF073042), fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            // 3. Why Jetpack Compose (4대 핵심 이점)
            item {
                Text(
                    text = "Jetpack Compose를 사용해야 하는 이유",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF073042),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            val features = listOf(
                FeatureData(
                    icon = Icons.Default.Code,
                    title = "코드 감소 (Less code)",
                    description = "기존 UI 대비 최대 60%의 코드양이 감소합니다. 완전히 Kotlin으로만 작성되며 XML 레이아웃 파일, 바인딩 어댑터 등을 관리할 필요가 없습니다."
                ),
                FeatureData(
                    icon = Icons.Default.Info,
                    title = "직관적 (Intuitive)",
                    description = "UI를 완전히 선언형(Declarative)으로 설계합니다. 데이터의 상태 변화가 일어나면, Compose가 알아서 해당 화면 영역만 효율적으로 업데이트합니다."
                ),
                FeatureData(
                    icon = Icons.Default.Speed,
                    title = "빠른 개발 가속화 (Accelerate development)",
                    description = "기존 뷰 시스템과의 100% 상호 호환성을 가집니다. 따라서 기존 프로젝트에 점진적으로 적용하기 쉬우며, 실시간 프리뷰 기능으로 즉각 확인이 가능합니다."
                ),
                FeatureData(
                    icon = Icons.Default.Star,
                    title = "강력한 성능 (Powerful)",
                    description = "Material Design 컴포넌트, 복잡한 애니메이션 효과, 반응형 제스처 처리가 기본 제공되어 풍부하고 완성도 높은 앱 UI를 쉽게 제작할 수 있습니다."
                )
            )

            items(features.size) { index ->
                FeatureCard(feature = features[index])
            }
        }
    }
}

data class FeatureData(
    val icon: ImageVector,
    val title: String,
    val description: String
)

@Composable
fun FeatureCard(feature: FeatureData) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFFE8F5E9), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = feature.icon,
                    contentDescription = null,
                    tint = Color(0xFF073042),
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = feature.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF073042)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = feature.description,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 18.sp
                )
            }
        }
    }
}
