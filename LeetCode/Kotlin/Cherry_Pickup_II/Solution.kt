package Cherry_Pickup_II

// Cherry Pickup II
// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3571/
// ref: https://blog.csdn.net/u013325815/article/details/106786164

class Solution {

    fun cherryPickup(grid: Array<IntArray>): Int {
        val dy = intArrayOf(-1, 0, 1)
        val rows = grid.size
        val columns = grid[0].size
        val dp = Array(70) {
            Array(70) {
                IntArray(70) {
                    0
                }
            }
        }

        fun backtracking(currentX: Int, currentY1: Int, currentY2: Int): Int {
            if (currentX == rows) return 0
            if (dp[currentX][currentY1][currentY2] != 0) {
                return dp[currentX][currentY1][currentY2]
            }
            var answer = 0

            for (d1 in dy) {
                for (d2 in dy) {
                    val newY1 = currentY1 + d1
                    val newY2 = currentY2 + d2

                    if (newY1 in 0 until columns && newY2 in 0 until columns) {
                        answer = maxOf(backtracking(currentX + 1, newY1, newY2), answer)
                    }
                }
            }

            answer += grid[currentX][currentY1]
            if (currentY1 != currentY2) {
                answer += grid[currentX][currentY2]
            }
            dp[currentX][currentY1][currentY2] = answer

            return dp[currentX][currentY1][currentY2]
        }

        return backtracking(0, 0, columns - 1)
    }
}
