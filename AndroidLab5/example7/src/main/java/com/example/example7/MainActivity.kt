package com.example.example7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.example7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var phoneNumberList = arrayListOf<String>()
    var cursor : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.oneBtn.setOnClickListener {
            phoneNumberList.add("1")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.twoBtn.setOnClickListener {
            phoneNumberList.add("2")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.threeBtn.setOnClickListener {
            phoneNumberList.add("3")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.fourBtn.setOnClickListener {
            phoneNumberList.add("4")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.fiveBtn.setOnClickListener {
            phoneNumberList.add("5")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.sixBtn.setOnClickListener {
            phoneNumberList.add("6")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.sevenBtn.setOnClickListener {
            phoneNumberList.add("7")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.eightBtn.setOnClickListener {
            phoneNumberList.add("8")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.nineBtn.setOnClickListener {
            phoneNumberList.add("9")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.zeroBtn.setOnClickListener {
            phoneNumberList.add("0")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.starBtn.setOnClickListener {
            phoneNumberList.add("*")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.sharpBtn.setOnClickListener {
            phoneNumberList.add("#")
            cursor += 1
            if (cursor % 4 == 3) {
                phoneNumberList.add("-")
            }
            showPhoneNumber()
        }

        binding.backIb.setOnClickListener {
            if (phoneNumberList[phoneNumberList.size-1] == "-") {
                cursor -= 2
            }
            else
                cursor -= 1

            deletePhoneNumber()
        }
    }

    fun showPhoneNumber() {
        var phoneNumber : String = ""

        for (num in phoneNumberList) {
            phoneNumber += num
        }
        binding.numberEt.setText(phoneNumber)
    }

    fun deletePhoneNumber() {
        var phoneNumber : String = ""

        if (phoneNumberList[phoneNumberList.size - 1] == "-") {
            phoneNumberList.removeAt(phoneNumberList.size - 1)
        }
        phoneNumberList.removeAt(phoneNumberList.size - 1)

        if (phoneNumberList.isEmpty()) {
            cursor = 0
        }

        for (num in phoneNumberList) {
            phoneNumber += num
        }

        binding.numberEt.setText(phoneNumber)
    }
}