package Diagonal_Traverse

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3580/

enum class Direction(val dx: Int, val dy: Int) {
    UP_RIGHT(-1, 1),
    DOWN_LEFT(1, -1);
}

class Solution {
    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()

        if(matrix.isEmpty()) return answer.toIntArray()

        val lastX = matrix.lastIndex
        val lastY = matrix.first().lastIndex
        var curX = 0
        var curY = 0
        var curDir = Direction.UP_RIGHT


        while (true) {

            while (true) {
                answer.add(matrix[curX][curY])

                if (
                    (curDir == Direction.UP_RIGHT && (curX == 0 || curY == lastY))
                    ||
                    (curDir == Direction.DOWN_LEFT && (curX == lastX || curY == 0))
                ) {
                    break
                } else {
                    curX += curDir.dx
                    curY += curDir.dy
                }
            }

            if (curX == lastX && curY == lastY)
                break

            when (curDir) {
                Direction.UP_RIGHT -> {
                    if (curY == lastY) {
                        curX++
                    } else {
                        curY++
                    }
                    curDir = Direction.DOWN_LEFT
                }
                Direction.DOWN_LEFT -> {
                    if (curX == lastX) {
                        curY++
                    } else {
                        curX++
                    }
                    curDir = Direction.UP_RIGHT
                }
            }
        }

        return answer.toIntArray()
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.findDiagonalOrder(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    )
}