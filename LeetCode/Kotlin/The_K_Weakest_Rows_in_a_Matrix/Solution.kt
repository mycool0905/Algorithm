package The_K_Weakest_Rows_in_a_Matrix

// The K Weakest Rows in a Matrix
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3641/

class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        return mat
            .map { row -> row.sum()}
            .withIndex()
            .sortedWith(compareBy { it.value })
            .map { it.index }
            .take(k)
            .toIntArray()
    }
}