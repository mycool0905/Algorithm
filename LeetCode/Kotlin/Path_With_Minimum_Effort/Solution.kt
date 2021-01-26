package Path_With_Minimum_Effort

// Path With Minimum Effort
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3617/

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

class Direction(val x: Int, val y: Int)

class Point(val x: Int, val y: Int)

class Solution {

    val dirs = arrayOf(
        Direction(-1, 0),
        Direction(0, 1),
        Direction(1, 0),
        Direction(0, -1)
    )

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        if (heights.size == 1 && heights[0].size == 1) {
            return 0
        }
        val kSet = mutableSetOf<Int>()

        for (curX in heights.indices) {
            for (curY in heights[0].indices) {
                for (dir in dirs) {
                    val newX = curX + dir.x
                    val newY = curY + dir.y
                    if (newX !in heights.indices || newY !in heights[0].indices) {
                        continue
                    }
                    val diff = abs(heights[newX][newY] - heights[curX][curY])
                    kSet.add(diff)
                }
            }
        }

        fun bfs(k: Int): Boolean {
            val queue: Queue<Point> = LinkedList()
            val visited = Array(heights.size) {
                BooleanArray(heights[0].size)
            }

            visited[0][0] = true
            queue.offer(Point(0, 0))

            while (queue.isNotEmpty()) {
                val curPoint = queue.poll()
                if (curPoint.x == heights.lastIndex && curPoint.y == heights[0].lastIndex) {
                    return true
                }

                for (dir in dirs) {
                    val newX = curPoint.x + dir.x
                    val newY = curPoint.y + dir.y
                    if (newX !in heights.indices || newY !in heights[0].indices || visited[newX][newY]) {
                        continue
                    }

                    val curDiff = abs(heights[curPoint.x][curPoint.y] - heights[newX][newY])
                    if (curDiff <= k) {
                        visited[newX][newY] = true
                        queue.offer(Point(newX, newY))
                    }
                }
            }

            return false
        }

        val kList = kSet.toMutableList().sorted()
        var start = 0
        var end = kList.size

        while (start < end) {
            val mid = (start + end) / 2

            if (bfs(kList[mid])) {
                end = mid
            } else {
                start = mid + 1
            }
        }

        return kList[start]
    }
}

fun main(args: Array<String>) {
    Solution().minimumEffortPath(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 8, 4),
            intArrayOf(5, 3, 5)
        )
    )
}

