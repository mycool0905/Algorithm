package Get_Maximum_in_Generated_Array

// Get Maximum in Generated Array
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3605/

class Solution {
    fun getMaximumGenerated(n: Int): Int {
        if(n==0) return 0
        if(n==1) return 1

        var answer = Int.MIN_VALUE
        val arr = IntArray(n+1)
        arr[0] = 0
        arr[1] = 1

        for(i in 2..n) {
            if (i % 2 == 0) {
                arr[i] = arr[i / 2]
            } else {
                arr[i] = arr[i / 2 + 1] + arr[i / 2]
            }
            answer = maxOf(answer,arr[i])
        }

        return answer
    }
}
