package com.example.example6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Calculator {
    private var calResultList: MutableList<Double> = mutableListOf()

    private fun add(a: Double, b: Double): Double {
        return a + b
    }
    private fun subtract(a: Double, b: Double): Double {
        return a - b
    }
    private fun multiple(a: Double, b: Double): Double {
        return a * b
    }
    private fun division(a: Double, b: Double): Double {
        if (b == 0.0){
            println("ERROR : number can not be divided with zero.")
            return 0.0
        }
        return a / b
    }

    fun load() {
        for (num in calResultList)
            println(num)
    }

    fun cal(a: Double, b: Double, type: String) {
        var result: Double = 0.0
        when (type) {
            "add"      -> result = add(a, b)
            "subtract" -> result = subtract(a, b)
            "division" -> result = division(a, b)
            "multiple" -> result = multiple(a, b)
        }

        if (result != 0.0)
            calResultList.add(result)
    }

    fun print_calculated_number() {
        var len: Int = calResultList.size
        println(calResultList[len - 1])
    }
}

fun main() {
    var calculator = Calculator()
    calculator.cal(1.0, 2.0, "add")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "subtract")
    calculator.print_calculated_number()
    calculator.cal(1.0, 0.0, "division")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "division")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "multiple")
    calculator.print_calculated_number()
    println("--------------")
    calculator.load()
}