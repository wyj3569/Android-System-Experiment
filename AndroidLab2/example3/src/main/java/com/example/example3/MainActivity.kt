package com.example.example3
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

fun Year(number : Int) : Int {
    if (number % 4 == 0 && number % 100 == 0 && number % 400 == 0)
        return 1
    else if (number % 4 == 0 && number % 100 == 0)
        return 0
    else if (number % 4 == 0)
        return 1
    return 0
}
fun printer(number : Int) {
    if (number == 0) println("윤년이 아닙니다.")
    else if (number == 1) println("윤년이 맞습니다.")
}
fun main() {
    println("2000년은 윤년 일까?")
    printer(Year(2000)) // 윤

    println("1900년은 윤년 일까?")
    printer(Year(1900)) // 평년

    println("20020년은 윤년 일까?")
    printer(Year(20020)) // 윤

    println("2013년은 윤년 일까?")
    printer(Year(2013)) // 평
}