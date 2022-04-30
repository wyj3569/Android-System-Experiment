package com.example.example2_07

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.example2_07.databinding.ItemMainBinding

// 각 항목에 해당하는 뷰 객체를 가지는 뷰 홀더
class MyViewHolder(val binding : ItemMainBinding) : RecyclerView.ViewHolder(binding.root)

class MyAdapter(val datas : MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // 리스트 원소 개수 반환
    // 항목의 개수를 판단하려고 자동으로 호출됩니다.
    override fun getItemCount(): Int = datas.size

    // 리사이클러뷰 객체 할당
    // 항목의 뷰를 가지는 뷰 홀더를 준비하려고 자동으로 호출됩니다.
    // onCreateViewHolder() 함수에서 반환한 뷰 홀더 객체는 자동으로 onBindViewHolder() 함수의 매개변수로 전달됩니다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = MyViewHolder(
        ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    // Adapter의 각 요소에 데이터 삽입
    // 뷰 홀더의 뷰에 데이터를 출력하려고 자동으로 호출됩니다.
    // getItemCount() 함수가 반환한 숫자만큼 onBindViewHolder() 함수가 호출되어 항목을 만듭니다.
    // 매개변수로 전달된 뷰 홀더 객체의 뷰에 데이터를 출력하거나 필요한 이벤트를 등록합니다.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("kkang", "onBindViewHolder : $position")
        val binding = (holder as MyViewHolder).binding
        // 뷰에 데이터 출력
        binding.itemData.text = datas[position]
        // 뷰에 이벤트 추가
        binding.itemRoot.setOnClickListener {
            Log.d("kkang", "item root click : $position")
        }
    }

}