package com.example.example5

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import com.example.example5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val colorList = arrayListOf<String>("#FF0000", "#00FF00", "#0000FF")
    var idx = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changeBackgroundBtn.setOnClickListener {
            idx++
            binding.linearLayout.setBackgroundColor(Color.parseColor(colorList[idx % 3]))
        }
    }
}