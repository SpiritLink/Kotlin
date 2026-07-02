plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.tripapp"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.tripapp"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // 선언하는 것만으로 layout xml 파일 하나당 XXXBinding 클래스 자동으로 만들어진다..
    viewBinding.enable = true

    buildFeatures {
        compose = true // Compose 활성화
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.fragment)
    implementation(libs.material)
    implementation(libs.protolite.well.known.types)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    val composeBom = platform("androidx.compose:compose-bom:2024.02.01")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.activity:activity-compose:1.9.0")

    // 외부 라이브러리 등록 .. 다운로드 .. sync now 하는 순간..

    // group id:artifact id:version

    // androidx 라이브러리의 경우.. 동일 이름의 라이브러리가 2개 제공..
    // aaa : 자바로 만든 라이브러리
    // aaa-ktx : 코틀린으로 만든 라이브러리

    // 하나의 프로젝트내에 여러 모듈, 여러 모듈에 동일 라이브러리 동일 버전이 적용..
    // 아래처럼 작성하는 것이 기본인데..
    // 라이브러리를 libs.versions.toml 에 등록하고 이용하는 곳에서 링크만 걸어서 사용
    implementation("androidx.preference:preference-ktx:1.2.1")
}