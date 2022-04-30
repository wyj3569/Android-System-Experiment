package com.example.example7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.example7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var idx = R.drawable.a

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.leftBtn.setOnClickListener {
            Log.d("idx", "idx : ${idx}")
            idx--
            binding.img.setImageResource((idx % 26) + 2131165341)
        }

        binding.rightBtn.setOnClickListener {
            idx++
            binding.img.setImageResource((idx % 26) + 2131165341)
        }
    }
}