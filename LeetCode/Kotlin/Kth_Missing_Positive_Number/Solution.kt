package Kth_Missing_Positive_Number

// Kth Missing Positive Number
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3594/

class Solution {

    fun findKthPositive(arr: IntArray, k: Int): Int {
        return forLoopSolution(arr, k)
    }

    fun forLoopSolution(arr: IntArray, k: Int): Int {
        var last = k
        var start = 0
        var end = 0
        val newArr = mutableListOf(0)
        newArr.addAll(arr.toMutableList())

        for(idx in 0 until newArr.lastIndex){
            start = newArr[idx]
            end = newArr[idx+1]

            if(end-start-1 < last){
                last -= end-start-1
            }else{
                return start+last
            }
        }

        return end+last
    }

    fun binarySearchSolution(arr: IntArray, k: Int): Int {
        var start = 0
        var end = arr.size-1

        while (start <= end) {
            val mid = start + (end-start)/2
            if (arr[mid]-mid-1 < k) {
                start = mid+1
            } else {
                end = mid-1
            }
        }

        return start+k
    }
}

fun main(args: Array<String>){
    println(Solution().findKthPositive(intArrayOf(2,3,4,7,11),5))
}
