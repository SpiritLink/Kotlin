package com.example.tripapp.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tripapp.databinding.FragmentDetailMainBinding

class DetailMainFragment : Fragment() {

    // 액티비티에 의해 프래그먼트가 출력될 때 프래그먼트가 뿌리는 화면을 결정하기 위해서 자동 호출 ..
    // 이 함수에서 리턴시킨 뷰가 프래그먼트에 출력된다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailMainBinding.inflate(inflater, container, false)
        return binding.root
    }
}