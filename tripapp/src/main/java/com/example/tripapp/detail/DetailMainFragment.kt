package com.example.tripapp.detail

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tripapp.R
import com.example.tripapp.databinding.FragmentDetailMainBinding
import com.example.tripapp.databinding.ItemRecyclerviewBinding

// 각 항목 데이터 추상화 ..
class Product(val photo: Int, val title: String, val desc: String)

// 항목을 구성하기 위한 뷰를 가지는 역할자..
class MyHolder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

// View Holder를 이용해 각 항목을 만드는 역할자
class MyAdapter(val datas: MutableList<Product>) : RecyclerView.Adapter<MyHolder>() {
    // 항목 갯수 판단위해 자동 호출
    override fun getItemCount(): Int {
        return datas.size // 1000 개가 리턴되었다고 하더라도.. onBindViewHolder를 1000 번 호출하지 않는다.
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        return MyHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val product = datas.get(position)
        holder.binding.run {
            itemTitleView.text = product.title
            itemDescView.text = product.desc
            itemImageView.setImageResource(product.photo)
        }
    }
}

class MyDecoration(val context: Context): RecyclerView.ItemDecoration() {
    // 각 항목을 꾸미기 위해서 호출
    // outRect - 항목 구성 사각형 정보
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        // 매개변수에 몇번째 항목을 위해서 호출된 것인지 전달이 되지 않아서..
        val index = parent.getChildAdapterPosition(view) + 1
        if(index % 3 == 0){
            outRect.set(10, 10, 10, 60)
        } else {
            outRect.set(10, 10, 10, 0)
        }
    }
}

class DetailMainFragment : Fragment() {

    // 액티비티에 의해 프래그먼트가 출력될 때 프래그먼트가 뿌리는 화면을 결정하기 위해서 자동 호출 ..
    // 이 함수에서 리턴시킨 뷰가 프래그먼트에 출력된다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailMainBinding.inflate(inflater, container, false)

        val datas = mutableListOf<Product>()
        for (i in 1..1000) {
            if (i % 3 == 0) {
                datas.add(Product(R.drawable.item1, "($i) 스위스/이탈리아 9일", "터키항공 잔여석31 가이드동행"))
            } else if (i % 3 == 1) {
                datas.add(Product(R.drawable.item2, "($i) 서유럽 4국 9일", "아시아나항공 잔여석25 가이드동행"))
            } else {
                datas.add(Product(R.drawable.item3, "($i) 스위스 일주 9일", "대한항공 잔여석19 가이드동행"))
            }
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = MyAdapter(datas)
        binding.recyclerView.addItemDecoration(MyDecoration(activity as Context))

        return binding.root
    }
}