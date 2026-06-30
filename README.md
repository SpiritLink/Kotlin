# Android App Development with Kotlin (AndroidLab)

이 프로젝트는 **Kotlin** 프로그래밍 언어 숙달 및 최신 **Android Framework**의 핵심 개념을 학습하고 실습하기 위해 구성된 멀티 모듈 안드로이드 프로젝트입니다.

---

## 📅 학습 개요 (Learning Overview)
- **학습 기간**: 2026.06.29 ~ 2026.07.03
- **학습 시간**: 09:00 ~ 17:00 (총 34시간)
- **주요 목표**:
  - Kotlin 언어 문법 및 객체지향/함수형 프로그래밍 이해
  - Android Studio를 활용한 앱 레이아웃 및 생명주기 관리
  - 최신 Android API(API 33+) 권장 사항(Edge-to-Edge, OnBackPressed) 적용
  - 멀티 모듈 환경에서의 코드 분리와 리소스 활용

---

## 🛠 개발 환경 및 기술 스택
- **IDE**: Android Studio
- **Language**: Kotlin (JDK 11)
- **Build System**: Gradle (Kotlin DSL)
- **Android SDK Specs**:
  - **Compile SDK**: 37 (Android 15)
  - **Target SDK**: 37 (Android 15)
  - **Min SDK**: 24 (Android 7.0 Nougat)
- **Core Library**: Jetpack (Activity, AppCompat, ConstraintLayout, Material)

---

## 📂 프로젝트 구조 및 주요 실습 내용

본 프로젝트는 두 개의 서브 모듈(`:app`, `:tripapp`)로 구성되어 학습 단계별로 실습이 나뉘어 진행되었습니다.

### 1. `:app` 모듈 (기초 UI & 컴포넌트 실습)
안드로이드의 기본적인 UI 구성 요소와 뷰 바인딩, 그리고 화면 공간 배치 방법에 대해 다룹니다.
- **주요 소스 파일**:
  - [MainActivity.kt](file:///d:/Projects/AndroidLab/app/src/main/java/com/example/androidlab/MainActivity.kt):
    - 전통적인 `findViewById()` 방식과 최신 **View Binding** 방식을 비교하며 UI 이벤트 처리를 다룹니다.
    - `enableEdgeToEdge()` 및 `WindowInsetsCompat`을 통해 화면의 시스템 영역(Status Bar/Navigation Bar) 대응 레이아웃 방식을 학습합니다.
  - [ConstraintTestActivity.kt](file:///d:/Projects/AndroidLab/app/src/main/java/com/example/androidlab/ConstraintTestActivity.kt):
    - 복잡한 뷰 배치를 효율적으로 구성할 수 있는 `ConstraintLayout`의 사용법을 실습합니다.

### 2. `:tripapp` 모듈 (여행 테마 화면 전환 & 제어 실습)
실제 화면 전환, 생명주기 대응, 다국어 지원, 사용자 동작 제어 등 심화 기능을 다룹니다.
- **주요 소스 파일**:
  - [MainActivity.kt](file:///d:/Projects/AndroidLab/tripapp/src/main/java/com/example/tripapp/MainActivity.kt):
    - **명시적 인텐트(Intent)**를 활용하여 여러 화면 간의 상태 전환 및 액티비티 이동을 제어합니다.
    - **뒤로가기 제어 (`OnBackPressedCallback`)**: API 33 이상에서 `onKeyDown()` 대신 새롭게 권장되는 `onBackPressedDispatcher`를 활용한 앱 종료 로직(3초 내 더블 탭 종료 확인 Toast 출력)을 구현했습니다.
  - [DetailActivity.kt](file:///d:/Projects/AndroidLab/tripapp/src/main/java/com/example/tripapp/DetailActivity.kt): 메인 화면에서 특정 항목을 선택했을 때 진입하는 상세 페이지 실습용 액티비티입니다.
  - [AboutActivity.kt](file:///d:/Projects/AndroidLab/tripapp/src/main/java/com/example/tripapp/AboutActivity.kt): 앱 정보 안내 페이지입니다.
- **주요 리소스 학습**:
  - **가로 모드 대응**: 가로 모드 시 최적화된 레이아웃을 제공하기 위해 별도의 가로 레이아웃([activity_about.xml (land)](file:///d:/Projects/AndroidLab/tripapp/src/main/res/layout-land/activity_about.xml))을 구성했습니다.
  - **다국어 지원 (Localization)**: 한국어와 영어 리소스를 분리하여 기기 언어 설정에 동적으로 대응하는 다국어 문자열([strings.xml (ko-rKR)](file:///d:/Projects/AndroidLab/tripapp/src/main/res/values-ko-rKR/strings.xml)) 구성을 학습했습니다.

---

## 🎯 핵심 학습 포인트 요약
1. **View Binding**: XML 레이아웃의 컴포넌트들을 타입 안정적이고 안전하게 제어하기 위한 뷰 바인딩 적용.
2. **최신 API 트렌드 적용**: API 33+ 기준의 `OnBackPressedDispatcher` 적용 및 `Edge-to-Edge` 화면 처리 실습.
3. **가로/세로 레이아웃 대응**: 반응형 앱 설계를 위한 리소스 디렉터리(`layout-land`) 활용.
4. **로컬라이징**: 다국어 리소스 구성을 통한 글로벌 앱 개발 기초 학습.
5. **Kotlin 문법 활용**: 고차 함수, 람다 표현식, 익명 클래스 선언(`object`) 문법 적용.

