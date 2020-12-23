package Next_Greater_Element_III

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3578/

class Solution {
    fun nextGreaterElement(n: Int): Int {
        var flag = false
        val answer = StringBuilder()
        val sortedString = n.toString().toList().sorted().let{
            charArray->
            val retStr = StringBuilder("")
            charArray.forEach{
                retStr.append(it)
            }
            retStr.toString()
        }
        val visited = BooleanArray(sortedString.length){ false }

        fun permutation(){
            if(answer.length==sortedString.length){
                if(answer.toString().toLong() > Int.MAX_VALUE) {
                    return
                }
                if(answer.toString().toInt() > n){
                    flag = true
                    return
                }
            }

            for(idx in sortedString.indices){
                if(visited[idx]) continue
                visited[idx] = true
                answer.append(sortedString[idx])
                permutation()
                if(flag) return
                answer.deleteCharAt(answer.lastIndex)
                visited[idx] = false
            }
        }

        permutation()

        return if(answer.isEmpty()) -1 else answer.toString().toInt()
    }
}