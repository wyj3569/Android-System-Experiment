package com.example.example4
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    var T = IntArray(N + 10)
    var P = IntArray(N + 10)
    var dp = IntArray(N + 10)
    var max = 0

    for (i in 1..N) {
        val input = readLine().split(" ").map { it.toInt() }
        T.set(i, input.get(0))
        P.set(i, input.get(1))
    }

    // 만약 마지막 날의 시간이 1일이면 dp[마지막날]에 급여값을 넣는다.
    if (T[N] == 1)
        dp[N] = P[N]

    for (i in N-1 downTo 1) {
        var remain = (N - i) + 1 // 남은 일 수
        // 시간이 남은 일 수보다 작거나 같다면
        if (T[i] <= remain) {
            dp[i] = P[i]
            if (i + T[i] <= N)
                dp[i] += dp[i + T[i]]
        }
        else
            dp[i] = 0

        max = max(max, dp[i])
    }

    println(max)
    close()
}