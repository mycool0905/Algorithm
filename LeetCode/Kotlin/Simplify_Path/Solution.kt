package Simplify_Path

// Simplify Path
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3629/

class Solution {
    fun simplifyPath(path: String): String {
        val answer = mutableListOf("/")

        val directories = path.split('/')
            .filter { it != "" && it != "." }

        for(str in directories){
            if(str == ".."){
                if(answer.size == 1){
                    continue
                }
                answer.removeAt(answer.lastIndex)
                answer.removeAt(answer.lastIndex)
            }else{
                answer.add(str)
                if(str != directories.last()) {
                    answer.add("/")
                }
            }
        }

        if(answer.size != 1 && answer.last() == "/"){
            answer.removeAt(answer.lastIndex)
        }
        return answer.joinToString("")
    }
}

fun main(args: Array<String>) {
    println(Solution().simplifyPath("/a//b////c/d//././/.."))
}