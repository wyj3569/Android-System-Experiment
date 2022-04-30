package com.example.example8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.example8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        var count = 0
    }
    lateinit var binding: ActivityMainBinding
    lateinit var num1 : String
    lateinit var num2 : String
    var result : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("0회 계산기")

        binding.addBtn.setOnClickListener {
            num1 = binding.num1Et.text.toString()
            num2 = binding.num2Et.text.toString()

            if (num1 != "" && num2 != "") {
                result = num1.toInt() + num2.toInt()
                binding.resultTv.text = "계산 결과 : $result"
                changeResultToNum1(result)
                changeTitle()
            }
        }

        binding.subBtn.setOnClickListener {
            num1 = binding.num1Et.text.toString()
            num2 = binding.num2Et.text.toString()

            if (num1 != "" && num2 != "") {
                result = num1.toInt() - num2.toInt()
                binding.resultTv.text = "계산 결과 : $result"
                changeResultToNum1(result)
                changeTitle()
            }
        }

        binding.mulBtn.setOnClickListener {
            num1 = binding.num1Et.text.toString()
            num2 = binding.num2Et.text.toString()

            if (num1 != "" && num2 != "") {
                result = num1.toInt() * num2.toInt()
                binding.resultTv.text = "계산 결과 : $result"
                changeResultToNum1(result)
                changeTitle()
            }
        }

        binding.divBtn.setOnClickListener {
            num1 = binding.num1Et.text.toString()
            num2 = binding.num2Et.text.toString()

            if (num1 != "" && num2 != "") {
                if (num2.toInt() != 0) {
                    result = num1.toInt() / num2.toInt()
                    binding.resultTv.text = "계산 결과 : $result"
                    changeResultToNum1(result)
                    changeTitle()
                }
            }
        }

        binding.modBtn.setOnClickListener {
            num1 = binding.num1Et.text.toString()
            num2 = binding.num2Et.text.toString()

            if (num1 != "" && num2 != "") {
                result = num1.toInt() % num2.toInt()
                binding.resultTv.text = "계산 결과 : $result"
                changeResultToNum1(result)
                changeTitle()
            }
        }

        binding.changeBtn.setOnClickListener {
            num1 = binding.num1Et.text.toString()
            num2 = binding.num2Et.text.toString()
            changeNum1AndNum2(num1, num2)
        }
    }

    fun changeResultToNum1(result : Int?) {
        binding.num1Et.setText(result.toString())
        binding.num2Et.setText("")
    }

    fun changeTitle() {
        count++
        supportActionBar?.setTitle("${count}회 계산기")
    }

    fun changeNum1AndNum2(num1 : String, num2 : String) {
        binding.num1Et.setText(num2)
        binding.num2Et.setText(num1)
    }
}