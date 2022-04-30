package com.example.androidlab3
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import java.lang.Exception
import java.net.Inet4Address

fun main() {
    var data : String? = null
    val length = if (data == null) {
        0
    } else {
        data?.length
    }
    println("data length : ${length}")
}