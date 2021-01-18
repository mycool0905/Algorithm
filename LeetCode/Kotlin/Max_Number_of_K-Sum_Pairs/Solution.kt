package `Max_Number_of_K-Sum_Pairs`

// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3608/

class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val arr = nums.sorted().filter { it < k }
        var start = 0
        var end = arr.lastIndex
        var answer = 0

        while (start < end) {
            when {
                arr[start] + arr[end] < k
                ->
                    start++

                arr[start] + arr[end] == k
                -> {
                    start++
                    end--
                    answer++
                }
                else ->
                    end--
            }
        }

        return answer
    }
}