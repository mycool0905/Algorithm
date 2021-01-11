package Merge_Sorted_Array

// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3600/

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if (n == 0) return
        if (m == 0) {
            nums2.forEachIndexed { index, i -> nums1[index] = i }; return
        }

        var start1 = m - 1
        var start2 = n - 1
        var insert = nums1.lastIndex

        while (insert >= 0 && start1 >= 0 && start2 >= 0) {
            if (nums1[start1] <= nums2[start2]) {
                nums1[insert] = nums2[start2--]
            } else {
                nums1[insert] = nums1[start1--]
            }
            insert--
        }

        while (start1 >= 0) {
            nums1[insert--] = nums1[start1--]
        }
        while (start2 >= 0) {
            nums1[insert--] = nums2[start2--]
        }
    }
}

fun main(args: Array<String>) {
    Solution().merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3)
}