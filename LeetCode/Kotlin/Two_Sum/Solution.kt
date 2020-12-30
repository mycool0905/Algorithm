package Two_Sum

// URI: https://leetcode.com/problems/two-sum/

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val answer = mutableListOf<Int>()
        val map = mutableMapOf<Int, MutableList<Int>>()

        nums.forEachIndexed { index, value ->
            if (map[value] == null) {
                map[value] = mutableListOf()
            }
            map[value]!!.add(index)
        }

        for (value in nums) {
            val find = target - value
            if (map[find] == null) {
                continue
            }

            if (find == value) {
                if (map[find]!!.size < 2) {
                    continue
                }
                answer.addAll(map[find]!!.take(2))
            } else {
                answer.add(map[value]!!.first())
                answer.add(map[find]!!.first())
            }
            break
        }

        return answer.toIntArray()
    }
}

fun main(args: Array<String>) {
    Solution().twoSum(intArrayOf(2, 2, 7, 11, 15), 9)
}