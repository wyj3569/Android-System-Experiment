package com.example.example4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.example4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var num1 : String
    lateinit var num2 : String
    var result : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            num1 = binding.edit1.text.toString()
            num2 = binding.edit2.text.toString()
            result = num1.toInt() + num2.toInt()
            binding.resultTv.text = "계산 결과 : " + result.toString()
        }

        binding.subBtn.setOnClickListener {
            num1 = binding.edit1.text.toString()
            num2 = binding.edit2.text.toString()
            result = num1.toInt() - num2.toInt()
            binding.resultTv.text = "계산 결과 : " + result.toString()
        }

        binding.mulBtn.setOnClickListener {
            num1 = binding.edit1.text.toString()
            num2 = binding.edit2.text.toString()
            result = num1.toInt() * num2.toInt()
            binding.resultTv.text = "계산 결과 : " + result.toString()
        }

        binding.divBtn.setOnClickListener {
            num1 = binding.edit1.text.toString()
            num2 = binding.edit2.text.toString()
            if (num2.toInt() != 0){
                result = num1.toInt() / num2.toInt()
                binding.resultTv.text = "계산 결과 : " + result.toString()
            } else
                binding.resultTv.text = "계산 결과 : "
        }
    }
}