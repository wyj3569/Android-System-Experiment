package com.example.example7
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

// 신용등급
enum class CreditGrade{F, E, D, C, B, A}

class MyAccount(var myName: String, var myBalance: Int ,var myCreditGrade: CreditGrade) {
    private val scanner = Scanner(System.`in`)
    private var iceAccount: Boolean = false // 계좌 동결 여부 판단

    // 메뉴를 보여줌
    fun showMenu() {
        println("----선택하세요----")
        println("|(I) 계좌정보    |")
        println("|(D) 입금       |")
        println("|(W) 출금       |")
        println("|(E) 종료       |")
        println("---------------")
    }

    // 메뉴를 선택 (종료하면 false 반환)
    fun checkMenu(): Boolean {
        var menu: String = scanner.next()
        menu = menu.toUpperCase()

        when (menu) {
            "I" -> {
                showMyInfo()
            }
            "D" -> {
                Deposite()
            }
            "W" -> {
                // 계좌가 동결되면 출금이 불가
                if (iceAccount)
                    println("동결된 계좌에서 출금하실 수 없습니다.")
                else Withdraw()
            }
            "E" -> {
                println("종료합니다.")
                return false
            }
        }
        return true
    }

    // 내 계좌 정보를 출력
    fun showMyInfo() {
        println("계좌정보는 다음과 같습니다")
        println("|이름:        ${myName} |")
        println("|계좌잔액:     ${myBalance}   |")
        println("|신용등급:     ${myCreditGrade}   |")
        println("----------------------\n\n")
    }

    fun Deposite() {
        println("입금하실 금액을 말하세요.")
        var depositeMoney = scanner.nextInt()
        myBalance += depositeMoney // 계좌가 동결돼도 입금은 계속 가능

        // 입금 후 동결한 계좌의 계좌 잔액이 0 이상이면, 계좌의 동결 상태를 해제
        // 하지만 0이상이 아니라면 계속 동결
        if (iceAccount && myBalance >= 0) {
            iceAccount = false
            println("동결계좌가 열렸습니다.")
        }

        // 입금 후, 계좌 잔액이 0 이상이면 신용 등급이 한 단계 상승
        if (myBalance >= 0 && myCreditGrade < CreditGrade.A) {
            upGrade()
        }
        println("${depositeMoney} 원을 입금하였습니다. 잔액 : ${myBalance}")
    }

    fun Withdraw() {
        println("출금하실 금액을 말하세요")
        val withdrawMoney = scanner.nextInt()

        // 신용등급이 F이면 계좌는 동결되고 입금만 가능한 상태가 된다.
        if (myCreditGrade <= CreditGrade.F) {
            println("최저 등급의 신용을 가지고 있습니다.")
            println("계좌가 동결됩니다.")
            println("계좌가 마이너스 되었습니다.")
            iceAccount = true
        }

        // 동결 상태가 아니면 출금이 가능함
        // 동결 상태라면 출금이 불가능함
        myBalance -= withdrawMoney // 출금

        // 출금 후, 계좌 잔액이 -1000 이상 0 미만이면 신용등급이 한 단계 하락
        if (-1000 <= myBalance && myBalance < 0 && myCreditGrade > CreditGrade.F) {
            println("계좌가 마이너스 되었습니다.")
            downGrade()
        }
        // 출금 후, 계좌 잔액이 -1000 미만이라면 잔액이 부족하다는 에러를 출력
        if (myBalance < -1000) {
            println("잔액이 부족합니다.")
        }
        println("${withdrawMoney} 원을 출금하였습니다. 잔액 : ${myBalance}")
    }

    fun downGrade() {
        when (myCreditGrade) {
            CreditGrade.A -> {
                print("신용등급이 \'${myCreditGrade}->${CreditGrade.B}\'로 한단계 떨어집니다.")
                myCreditGrade = CreditGrade.B
            }
            CreditGrade.B -> {
                print("신용등급이 \'${myCreditGrade}->${CreditGrade.C}\'로 한단계 떨어집니다.")
                myCreditGrade = CreditGrade.C
            }
            CreditGrade.C -> {
                print("신용등급이 \'${myCreditGrade}->${CreditGrade.D}\'로 한단계 떨어집니다.")
                myCreditGrade = CreditGrade.D
            }
            CreditGrade.D -> {
                print("신용등급이 \'${myCreditGrade}->${CreditGrade.E}\'로 한단계 떨어집니다.")
                myCreditGrade = CreditGrade.E
            }
            CreditGrade.E -> {
                print("신용등급이 \'${myCreditGrade}->${CreditGrade.F}\'로 한단계 떨어집니다.")
                myCreditGrade = CreditGrade.F
            }
        }
    }

    fun upGrade() {
        when (myCreditGrade) {
            CreditGrade.F -> {
                println("신용등급이 \'${myCreditGrade}->${CreditGrade.E}\'로 한단계 상승합니다.")
                myCreditGrade = CreditGrade.E
            }
            CreditGrade.E -> {
                println("신용등급이 \'${myCreditGrade}->${CreditGrade.D}\'로 한단계 상승합니다.")
                myCreditGrade = CreditGrade.D
            }
            CreditGrade.D -> {
                println("신용등급이 \'${myCreditGrade}->${CreditGrade.C}\'로 한단계 상승합니다.")
                myCreditGrade = CreditGrade.C
            }
            CreditGrade.C -> {
                println("신용등급이 \'${myCreditGrade}->${CreditGrade.B}\'로 한단계 상승합니다.")
                myCreditGrade = CreditGrade.B
            }
            CreditGrade.B -> {
                println("신용등급이 \'${myCreditGrade}->${CreditGrade.A}\'로 한단계 상승합니다.")
                myCreditGrade = CreditGrade.A
            }
        }
    }
}

fun main() {
    var myAccount = MyAccount("Kim", 0, CreditGrade.C)

    while (true) {
        // 메뉴를 보여주고
        myAccount.showMenu()

        // 메뉴를 선택한다
        // E를 선택하면 false를 반환하고, 프로그램 종료
        if (!myAccount.checkMenu())
            break
    }
}
