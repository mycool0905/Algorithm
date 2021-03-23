package `3Sum_With_Multiplicity`

// 3Sum With Multiplicity
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3682/

class Solution {
    fun threeSumMulti(arr: IntArray, target: Int): Int {
        var answer = 0
        val modulo = 1_000_000_000 + 7
        val map = arr.sorted().groupingBy{ it }.eachCount()
        val keys = map.keys.toList()

        for (i in 0..keys.lastIndex) {
            val iValue = keys[i]
            val iCount = map.getOrDefault(iValue, 0)
            for (j in i..keys.lastIndex) {
                val jValue = keys[j]
                val jCount = map.getOrDefault(jValue, 0)
                for (k in j..keys.lastIndex) {
                    val kValue = keys[k]
                    val kCount = map.getOrDefault(kValue, 0)

                    if (iValue + jValue + kValue > target) {
                        break
                    }

                    if (iValue + jValue + kValue != target) {
                        continue
                    }

                    if (i != j && j != k) {
                        answer += iCount * jCount * kCount
                        answer %= modulo
                    } else if (i == j && j != k) {
                        answer += SumFromFirst(iCount - 1) * kCount
                        answer %= modulo
                    } else if (i != j && j == k) {
                        answer += iCount * SumFromFirst(jCount - 1)
                        answer %= modulo
                    } else if (i == j && j == k) {
                        for (m in 1..iCount - 2) {
                            answer += SumFromFirst(m)
                            answer %= modulo
                        }
                    }
                }
            }
        }
        return answer
    }

    private fun SumFromFirst(input: Int): Int {
        var result = 0
        for (i in 1..input) {
            result += i
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = Solution().threeSumMulti(intArrayOf(3,3,1), 7)
}