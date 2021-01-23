package Sort_the_Matrix_Diagonally

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3614/

class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val answer = Array<IntArray>(mat.size) {
            IntArray(mat[0].size)
        }

        if (mat.size == 1 || mat[0].size == 1) return mat

        for (i in mat[0].lastIndex downTo 0) {
            fillMatrix(0, i, mat, answer)
        }

        for (i in 1..mat.lastIndex) {
            fillMatrix(i, 0, mat, answer)
        }

        return answer
    }

    private fun fillMatrix(startX: Int, startY: Int, mat: Array<IntArray>, answer: Array<IntArray>) {
        var curX = startX
        var curY = startY
        val temp = mutableListOf<Int>()

        while (curX in mat.indices && curY in mat[0].indices) {
            temp.add(mat[curX++][curY++])
        }

        temp.sort()

        curX = startX
        curY = startY

        for (value in temp) {
            answer[curX++][curY++] = value
        }
    }
}