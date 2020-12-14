package Remove_Duplicates_from_Sorted_Array_II

// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3562/

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val check = mutableMapOf<Int, Int>()
        var remove = 0
        var curIdx = 0


        while (curIdx + remove < nums.size) {
            val curValue = nums[curIdx + remove]
            if (check.getOrDefault(curValue, 0) < 2) {
                check[curValue] = check.getOrDefault(curValue, 0) + 1
                nums[curIdx] = nums[curIdx + remove]
                curIdx++
            } else {
                remove++
            }
        }

        return nums.size - remove
    }
}

fun main(args: Array<String>){
    val solution = Solution()
    solution.removeDuplicates(intArrayOf(0,0,1,1,1,1,2,3,3))
}