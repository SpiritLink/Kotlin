package com.example.tripapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.tripapp.databinding.ActivityDetailBinding
import com.example.tripapp.detail.DetailMainFragment
import com.example.tripapp.detail.DetailNewsFragment

class DetailActivity : AppCompatActivity() {

    // ViewPager의 항목(화면)을 만들어주는 역할자..
    // 만드는 항목하나가 fragment 로 만들어진다면. FragmentStateAdapter 를 상속받아서 작성..
    // fragment 가 아닌 일반 뷰로 준비된다면 .. RecyclerView.Adapter 상속..
    class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
        val fragmets: List<Fragment>
        init {
            fragmets = listOf(DetailMainFragment(), DetailNewsFragment()) as List<Fragment>
        }

        override fun getItemCount(): Int = fragmets.size

        override fun createFragment(position: Int): Fragment = fragmets[position]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // viewpager에게 adapter 적용
        val adapter = MyFragmentPagerAdapter(this)
        binding.viewpager.adapter = adapter
    }
}