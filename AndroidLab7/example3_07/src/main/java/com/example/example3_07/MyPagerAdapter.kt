package com.example.example3_07

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.example3_07.databinding.ItemPagerBinding

class MyPagerViewHolder(val binding: ItemPagerBinding) : RecyclerView.ViewHolder(binding.root)

class MyPagerAdapter(val datas : MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = MyPagerViewHolder(
        ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyPagerViewHolder).binding
        // 뷰에 데이터 출력
        binding.itemPagerTextView.text = datas[position]
        when (position % 3) {
            0 -> binding.itemPagerTextView.setBackgroundColor(Color.RED)
            1 -> binding.itemPagerTextView.setBackgroundColor(Color.BLUE)
            2 -> binding.itemPagerTextView.setBackgroundColor(Color.GREEN)
        }
    }


}