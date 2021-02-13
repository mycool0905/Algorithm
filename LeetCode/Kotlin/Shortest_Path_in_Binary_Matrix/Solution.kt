package Shortest_Path_in_Binary_Matrix

// Shortest Path in Binary Matrix
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3638/

import java.util.LinkedList
import java.util.Queue

class Point(val x: Int, val y: Int, val step: Int)

class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val dxList = arrayOf(-1, 0, 1)
        val dyList = arrayOf(-1, 0, 1)
        val queue: Queue<Point> = LinkedList()
        val visited = Array(grid.size) {
            BooleanArray(grid[0].size) {
                false
            }
        }

        if (grid[0][0] == 0) {
            visited[0][0] = true
            queue.offer(Point(0, 0, 1))
        }

        while (queue.isNotEmpty()) {
            val newPoint = queue.poll()
            if (newPoint.x == grid.lastIndex && newPoint.y == grid[0].lastIndex) {
                return newPoint.step
            }

            for (dx in dxList) {
                for (dy in dyList) {
                    if (dx == 0 && dy == 0) {
                        continue
                    }

                    val newX = dx + newPoint.x
                    val newY = dy + newPoint.y

                    if (newX !in grid.indices || newY !in grid[0].indices || grid[newX][newY] == 1 || visited[newX][newY]) {
                        continue
                    }

                    visited[newX][newY] = true
                    queue.offer(Point(newX, newY, newPoint.step + 1))
                }
            }
        }

        return -1
    }
}