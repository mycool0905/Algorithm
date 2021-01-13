package Boats_to_Save_People

// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3602/

class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        var arr = people.sorted()
        var low = 0
        var high = arr.lastIndex
        var answer = 0

        while (arr[high] == limit) {
            high--
            answer++
        }

        while (low < high) {
            val curValue = arr[low] + arr[high]
            if (curValue <= limit) {
                low++
            }
            high--
            answer++
        }

        if (low == high) answer++


        return answer
    }
}