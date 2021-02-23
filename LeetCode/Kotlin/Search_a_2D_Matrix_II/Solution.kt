package Search_a_2D_Matrix_II

// Search a 2D Matrix II
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3650/

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var maxX = 0
        var maxY = 0

        while (maxX in matrix.indices && matrix[maxX][0] <= target) {
            maxX++
        }
        while (maxY in matrix[0].indices && matrix[0][maxY] <= target) {
            maxY++
        }

        for(x in maxX-1 downTo 0){
            for(y in maxY-1 downTo 0){
                if(matrix[x][y] == target){
                    return true
                }
                else if(matrix[x][y] < target){
                    break
                }
            }
        }

        return false
    }
}

fun main(args: Array<String>){
    Solution().searchMatrix(arrayOf(intArrayOf(-5)),-5)
}