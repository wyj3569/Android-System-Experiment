package com.example.example1_07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragButton = findViewById<Button>(R.id.fragBut1)
        val fragmentManager : FragmentManager = supportFragmentManager // Fragment 동적 제어를 위한 객체 할당
        var onClicked = false

        fragButton.setOnClickListener {
            if (onClicked) { // Fragment를 뷰에서 제거
                onClicked = false
                val transaction : FragmentTransaction = fragmentManager.beginTransaction()
                val frameLayout = supportFragmentManager.findFragmentById(R.id.fragment_content)
                transaction.remove(frameLayout!!).commit()
            } else { // Fragment를 뷰에 할당
                onClicked = true
                val transaction : FragmentTransaction = fragmentManager.beginTransaction()
                transaction.add(R.id.fragment_content, OneFragment()).commit() // Fragment 추가 및 적용
            }
        }
    }
}