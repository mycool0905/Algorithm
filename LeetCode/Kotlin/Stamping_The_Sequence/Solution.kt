package Stamping_The_Sequence

// Stamping The Sequence
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/592/week-5-march-29th-march-31st/3691/
// ref: https://dev.to/seanpgallivan/solution-stamping-the-sequence-4fc7

fun CharArray.isFilledWith(char: Char): Boolean {
    return this.count { it == char } == this.size
}

class Solution {
    fun movesToStamp(stamp: String, target: String): IntArray {
        if (!target.contains(stamp)) {
            return intArrayOf()
        }
        if (stamp == target) {
            return intArrayOf(0)
        }

        val answer = mutableListOf<Int>()
        val stampCharArray = stamp.toCharArray()
        val targetCharArray = target.toCharArray()
        var isTargetChanged = true
        var isStamping = false

        while (isTargetChanged) {
            isTargetChanged = false
            for (i in targetCharArray.indices) {
                isStamping = false
                var count = 0
                for (j in stampCharArray.indices) {
                    if (i + j !in targetCharArray.indices) {
                        break
                    }
                    if (targetCharArray[i + j] == '?') {
                        count++
                        continue
                    } else if (targetCharArray[i + j] != stampCharArray[j]) {
                        break
                    } else {
                        count++
                        isStamping = true
                    }
                }
                if (count == stamp.length && isStamping) {
                    for (j in i until stamp.length + i) {
                        targetCharArray[j] = '?'
                    }
                    answer.add(i)
                    isTargetChanged = true
                }
            }
        }

        if (!targetCharArray.isFilledWith('?')) {
            return intArrayOf()
        }

        return answer.reversed().toIntArray()
    }
}

fun main(args: Array<String>) {
    val solution = Solution().movesToStamp("oz", "ooozz")
}