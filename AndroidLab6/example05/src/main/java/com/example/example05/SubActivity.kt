package com.example.example05

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.example05.databinding.ActivityMainBinding
import com.example.example05.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        binding.profileIv.setImageBitmap(intent.getParcelableExtra<Bitmap>("resize"))
        binding.korNameTv.setText(intent.getStringExtra("korName"))
        binding.engNameTv.setText(intent.getStringExtra("engName"))
        binding.phoneTv.setText(intent.getStringExtra("phoneNumber"))
        binding.emailTv.setText(intent.getStringExtra("eMail"))
        binding.addressTv.setText(intent.getStringExtra("address"))

        binding.resumeBtn.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}