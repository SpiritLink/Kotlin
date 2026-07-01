package com.example.tripapp.settings

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.tripapp.R


// 설정 xml 을 등록시키기 위한 개발자 프래그먼트 (View)
// 이 클래스를 액티비티가 화면에 출력시켜야 한다..
class MySettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(
        savedInstanceState: Bundle?,
        rootKey: String?
    ) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        // 위 코드는 필수.. 화면 출력되고. 설정 내용 저장까지 다 된다..
        // 아래 코드는 필요하다면..

        // key 로 설정 객체 획득.. ==> 동적 제어
        val idPreference: EditTextPreference? = findPreference("id")
        val colorPreference: ListPreference? = findPreference("color")

        // summary 를 동적으로 지정하고 싶다.
        // case 1 : 유저 설정 값을 그대로 summary 에 출력 ..
        colorPreference?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()

        // case 2 : 설정 값을 참조해서 알고리즘으로 summary 지정 ..
        idPreference?.summaryProvider =
            Preference.SummaryProvider<EditTextPreference> { preference ->
                // 설정값 획득 ..
                val text = preference.text
                if (TextUtils.isEmpty(text)) {
                    "설정이 되지 않았습니다."
                } else {
                    "설정된 ID 는 $text 입니다." // 리턴시킨 문자열이 summary 에 출력..
                }
            }

        // 설정 값 변경 순간의 이벤트..
        // 값 저장은 자동으로 되지만 그 순간 추가 업무 진행을 위해서..
        idPreference?.setOnPreferenceChangeListener { preference, newValue ->
            Log.d("kkang", "key : ${preference.key}, value : ${newValue}")
            true
        }
    }
}
