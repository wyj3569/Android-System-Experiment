package com.example.example2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Matrix(private val matrixString: String) {
    val datas: List<List<Int>>

    init {
        datas = matrixString
            .replace("[ ]+".toRegex(), " ")
            .split("\n")
            .map {
                it.trim().split(" ").map { it.toInt() }
            }
    }

    fun column(colNr: Int) : List<Int> {
        return datas.map { it[colNr - 1] }
    }

    fun row(rowNr : Int) : List<Int> {
        return datas.get(rowNr - 1)
    }
}

fun main() {

    val inputString = "1 2 3\n4 5 6\n7 8 9"

    println("매트릭스 문자열")
    println(inputString)

    val matrix = Matrix(inputString)

    println("\n매트릭스 클래스")
    println(matrix.row(2))
    println(matrix.column(1))
}