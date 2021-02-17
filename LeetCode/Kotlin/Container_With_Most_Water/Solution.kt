package Container_With_Most_Water

// Container With Most Water
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3643/

class Solution {
    fun maxArea(height: IntArray): Int {
        var answer = Int.MIN_VALUE

        var left = 0
        var right = height.lastIndex

        while (left < right) {
            answer = maxOf(answer, minOf(height[left], height[right]) * (right - left))
            if (height[left] > height[right]) {
                right--
            } else {
                left++
            }
        }

        return answer
    }
}