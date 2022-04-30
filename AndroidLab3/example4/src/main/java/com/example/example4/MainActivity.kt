package com.example.example4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

fun change(str: String) : String {
    var flag: Boolean = true
    var extraList: MutableList<Char> = mutableListOf()

    for (i in 0 until str.length) {
        if (!('a' <= str[i] && str[i] <= 'z')) {
            flag = false
            extraList.add(str[i])
        }
    }

    if (flag) {
        return str.toUpperCase()
    } else {
        print("error with = ")
        for (ch in extraList) print(ch)
    }
    return ""
}

fun main() {
    var a = "abcd"
    println(change(a))

    var b = "EfgH"
    println(change(b))

    var c = "!@%$"
    println(change(c))
}