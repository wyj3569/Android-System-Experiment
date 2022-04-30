package com.example.example03

import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.core.net.toUri
import com.example.example03.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val bitmap = intent.getParcelableExtra<Bitmap>("image")

        binding.photo.setImageBitmap(bitmap)
        binding.nameTv.text = intent.getStringExtra("name")
        binding.ageTv.text = intent.getStringExtra("age")
        binding.phoneTv.text = intent.getStringExtra("phone")
        binding.addressTv.text = intent.getStringExtra("address")
        binding.memoTv.text = intent.getStringExtra("memo")

        binding.completeBtn.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}