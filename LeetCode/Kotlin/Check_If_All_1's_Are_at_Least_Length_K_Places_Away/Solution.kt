package `Check_If_All_1's_Are_at_Least_Length_K_Places_Away`

// Check If All 1's Are at Least Length K Places Away
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3616/

class Solution {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var startBool = false
        var before = 0

        for (curIdx in nums.indices) {
            if (nums[curIdx] == 1) {
                if (startBool.not()) {
                    startBool = true
                    before = curIdx
                } else {
                    if(curIdx-before <= k){
                        return false
                    }
                    before = curIdx
                }
            }
        }

        return true
    }
}
