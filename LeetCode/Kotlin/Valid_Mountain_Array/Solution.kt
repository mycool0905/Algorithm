package Valid_Mountain_Array

// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3561/

class Solution {
    fun validMountainArray(arr: IntArray): Boolean {
        var changeIdx = -1

        if(arr.size < 3) return false
        if(arr[0] >= arr[1]) return false

        for (i in 0 until arr.lastIndex) {
            if (arr[i] > arr[i + 1]) {
                changeIdx = i + 1
                break
            }
            if (arr[i] == arr[i + 1]) return false
        }

        if(changeIdx==-1) return false

        for (i in changeIdx until arr.lastIndex) {
            if (arr[i] <= arr[i + 1]) return false
        }

        return true
    }
}