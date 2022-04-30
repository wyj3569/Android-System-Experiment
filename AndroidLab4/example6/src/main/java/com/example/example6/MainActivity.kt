package com.example.example6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.example6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            binding.btn1.visibility = View.INVISIBLE
            binding.btn2.visibility = View.VISIBLE
        }

        binding.btn2.setOnClickListener {
            binding.btn2.visibility = View.INVISIBLE
            binding.btn3.visibility = View.VISIBLE
        }

        binding.btn3.setOnClickListener {
            binding.btn3.visibility = View.INVISIBLE
            binding.btn4.visibility = View.VISIBLE
        }

        binding.btn4.setOnClickListener {
            binding.btn4.visibility = View.INVISIBLE
            binding.btn5.visibility = View.VISIBLE
        }

        binding.btn5.setOnClickListener {
            binding.btn5.visibility = View.INVISIBLE
            binding.btn1.visibility = View.VISIBLE
        }
    }
}