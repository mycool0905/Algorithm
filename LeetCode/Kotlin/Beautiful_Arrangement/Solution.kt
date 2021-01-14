package Beautiful_Arrangement

// Beautiful Arrangement
// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3591/

class Solution {
    fun countArrangement(n: Int): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()
        val visited = BooleanArray(n+1)
        var answer = 0

        for(i in 1..n){
            map[i] = mutableListOf()
            for(value in 1..n){
                if(i%value == 0 || value%i == 0){
                    map[i]!!.add(value)
                }
            }
        }

        fun backtracking(curIdx: Int){
            if(curIdx > n){
                answer++
                return
            }

            for(value in map[curIdx]!!){
                if(!visited[value]){
                    visited[value] = true
                    backtracking(curIdx+1)
                    visited[value] = false
                }
            }
        }

        backtracking(1)

        return answer
    }
}

fun main(args: Array<String>){
    println(Solution().countArrangement(15))
}
