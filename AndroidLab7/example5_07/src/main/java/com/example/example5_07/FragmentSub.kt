package com.example.example5_07

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example5_07.databinding.FragmentSubBinding

class FragmentSub : Fragment() {

    lateinit var binding: FragmentSubBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubBinding.inflate(inflater, container, false)

        var datas = mutableListOf<String>()
        for (i in 1..20) {
            datas.add("Item $i")
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(inflater.context)
        binding.recyclerView.adapter = MyAdapter(datas)
        return binding.root
    }
}