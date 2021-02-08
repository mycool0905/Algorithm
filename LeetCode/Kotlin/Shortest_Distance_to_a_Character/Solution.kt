package Shortest_Distance_to_a_Character

// Shortest Distance to a Character
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3631/

class Solution {
    fun shortestToChar(s: String, c: Char): IntArray {
        val answer = IntArray(s.length){ -1 }
        val idxList = s.mapIndexed{ index, c -> Pair(index, c) }.filter { it.second == c }.map { it.first}

        idxList.forEach { answer[it] = 0 }
        idxList.forEach {
            var toDownIdx = it - 1
            var toUpIdx = it + 1
            while(toDownIdx in answer.indices){
                if(answer[toDownIdx] == answer[toDownIdx+1] + 1 || answer[toDownIdx] == answer[toDownIdx+1] || answer[toDownIdx] == 0){
                    break
                }
                answer[toDownIdx] = answer[toDownIdx+1] + 1
                toDownIdx--
            }
            while(toUpIdx in answer.indices){
                if(answer[toUpIdx] == answer[toUpIdx-1] + 1 || answer[toUpIdx] == answer[toUpIdx-1] || answer[toUpIdx] == 0){
                    break
                }
                answer[toUpIdx] = answer[toUpIdx-1] + 1
                toUpIdx++
            }

        }

        return answer
    }
}