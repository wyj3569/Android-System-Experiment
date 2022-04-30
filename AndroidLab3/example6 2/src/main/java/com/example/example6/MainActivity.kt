package com.example.example6
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception
import java.lang.NumberFormatException
import java.util.*

val sc : Scanner = Scanner(System.`in`)

class VendingMachine {
    var money : Int = 0

    fun getChange(menu : Int) : Int? {
        money -= getPrice(menu)

        return if (money < 0) {
            println("현금이 부족합니다.")
            null
        } else {
            println("감사합니다. 잔돈반환:$money")
            1
        }
    }

    fun getCoin(): Int? {
        println("Insert Coin")
        val input = sc.nextLine()
        val coin = input.toIntOrNull()

        if (coin == null) {
            return null
        }
        else {
            money = coin
            println("${coin} 원을 넣었습니다.")
        }
        return 1
    }

    fun getMenu(): Int? {
        println("========== MENU ==========")
        println("| (1) 참깨라면   - 1,000원\t|")
        println("| (2) 햄버거     - 1,500원\t|")
        println("| (3) 콜라      - 800원\t  |")
        println("| (4) 핫바      - 1,200원\t|")
        println("| (5) 초코우유   - 1,500원\t|")
        println("Choose Menu:")

        when (val inputMenu : String = sc.nextLine()) {
            "1" -> return inputMenu.toInt()
            "2" -> return inputMenu.toInt()
            "3" -> return inputMenu.toInt()
            "4" -> return inputMenu.toInt()
            "5" -> return inputMenu.toInt()
            else -> return null
        }
    }

    fun getPrice(menu : Int) : Int {
        return when (menu) {
            1 -> 1000
            2 -> 1500
            3 -> 800
            4 -> 1200
            5 -> 1500
            else -> 0
        }
    }
}

fun main() {
    val vendingMachine = VendingMachine()

    while (true) {
        val menu = vendingMachine.getMenu()
        if (menu == null) {
            println("아무것도 선택하지 않았습니다.")
            println("다시 선택해주세요.")
        } else {
            when (menu) {
                1 -> println("참깨라면이 선택되었습니다.")
                2 -> println("햄버거가 선택되었습니다.")
                3 -> println("콜라가 선택되었습니다.")
                4 -> println("핫바가 선택되었습니다.")
                5 -> println("초코우유가 선택되었습니다.")
            }

            var coinResult = vendingMachine.getCoin()
            while (true) {
                if (coinResult != null) break
                else {
                    println("돈을 넣지 않았습니다.")
                    println("다시 돈을 넣어주세요.")
                    coinResult = vendingMachine.getCoin()
                }
            }

            vendingMachine.getChange(menu) ?: break
        }
    }
}