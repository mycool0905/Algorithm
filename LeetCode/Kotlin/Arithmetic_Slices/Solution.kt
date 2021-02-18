package Arithmetic_Slices

// Arithmetic Slices
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3644/

class Solution {
    fun numberOfArithmeticSlices(A: IntArray): Int {
        var answer = 0

        for (start in 0..A.lastIndex-2){
            for (end in start+2..A.lastIndex){
                if(checkIfArithmetic(A, start, end)){
                    answer++
                }else{
                    break
                }
            }
        }

        return answer
    }

    private fun checkIfArithmetic(A: IntArray, start: Int, end: Int): Boolean{
        val diff = A[start+1] - A[start]
        var curIdx = start+1
        while(curIdx <= end-1){
            if(A[curIdx+1]-A[curIdx] != diff){
                return false
            }
            curIdx++
        }
        return true
    }
}

fun main(args: Array<String>){
    Solution().numberOfArithmeticSlices(intArrayOf(1,2,3,4))
}