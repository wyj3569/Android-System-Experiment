package com.example.example5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dx = listOf<Int>(+0, +0, -1, +1)
val dy = listOf<Int>(-1, +1, +0, +0)
val br = BufferedReader(InputStreamReader(java.lang.System.`in`))

val input = readLine()!!.split(" ").map { it.toInt() }
val n = input[0]
val m = input[1]

val graph      = Array(n, {IntArray(m, {0})})
var copy_graph = Array(n, {IntArray(m, {0})})
var answer: Int = 0

fun main() = with(br) {
    for (y in 0 until n) {
        var line = StringTokenizer(readLine(), " ")
        for (x in 0 until m)
            graph[y][x] = line.nextToken().toInt()
    }
    put_wall(0)
    println(answer)
}

fun DFS(a:Int, b:Int) {
    for (i in 0 until 4) {
        val nx = a + dx[i]
        val ny = b + dy[i]

        if (nx <= -1 || nx >= n || ny <= -1 || ny >= m)
            continue
        if (copy_graph[nx][ny] == 1 || copy_graph[nx][ny] == 2)
            continue

        if (copy_graph[nx][ny] == 0) {
            copy_graph[nx][ny] = 2
            DFS(nx, ny)
        }
    }
}

fun put_wall(count:Int) {
    if (count >= 3) {
        for (y in 0 until n) {
            for (x in 0 until m) {
                copy_graph[y][x] = graph[y][x]
            }
        }
        for (y in 0 until n) {
            for (x in 0 until m) {
                if (copy_graph[y][x] == 2)
                    DFS(y, x)
            }
        }

        var safe_zone = 0
        for (y in 0 until n) {
            for (x in 0 until m) {
                if (copy_graph[y][x] == 0)
                    safe_zone++
            }
        }
        if (safe_zone >= answer)
            answer = safe_zone

        return
    }

    for (y in 0 until n) {
        for (x in 0 until m) {
            if (graph[y][x] == 0) {
                graph[y][x] = 1
                put_wall(count + 1)
                graph[y][x] = 0
            }
        }
    }
}