package com.example.example5
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

fun main() {
    var num = 0
    var pairList: MutableList<Int> = mutableListOf()

    val sc : Scanner = Scanner(System.`in`)
    num = sc.nextLine().toInt()

    for (i: Int in 0 until num step 1) {
        var temp = sc.nextLine().toInt()
        pairList.add(temp)
    }

    for (i: Int in 0 until num step 1) {
        var now = pairList.get(i)
        print("Pairs fo ${now} : ")

        for (first in 1..now) {
            var second = now - first
            if (first < second) {
                print("(${first} ${second}),")
            }
        }
        print("\b")
        println()
    }
}