package Check_Array_Formation_Through_Concatenation

// Check Array Formation Through Concatenation
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3589/

class Solution {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        val piecesMap = pieces.groupBy { it.first() }
        var curIdx = 0

        while(curIdx in arr.indices){

            val curPiecesArray =  piecesMap[arr[curIdx]] ?: return false
            for(curPiece in curPiecesArray.first()){
                if(curPiece != arr[curIdx++]) return false
            }
        }

        return true
    }
}

fun main(args: Array<String>) {
    Solution().canFormArray(intArrayOf(2,4,6), arrayOf(intArrayOf(1),intArrayOf(3), intArrayOf(5)))
}
