package Spiral_Matrix_II

// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3557/

class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val answer = Array<IntArray>(n) { IntArray(n) }
        var curX = 0
        var curY = 0
        var cnt = 1

        answer[curX][curY] = cnt++
        while(true){
            val checkCnt = cnt

            while(true){
                curY++
                if(curY==n || answer[curX][curY] != 0){
                    curY--
                    break
                }
                answer[curX][curY] = cnt++
            }

            while(true){
                curX++
                if(curX==n || answer[curX][curY] != 0){
                    curX--
                    break
                }
                answer[curX][curY] = cnt++
            }

            while(true){
                curY--
                if(curY==-1 || answer[curX][curY] != 0){
                    curY++
                    break
                }
                answer[curX][curY] = cnt++
            }

            while(true){
                curX--
                if(curX==-1 || answer[curX][curY] != 0){
                    curX++
                    break
                }
                answer[curX][curY] = cnt++
            }

            if(cnt==checkCnt)
                break
        }

        return answer
    }
}

fun main(args: Array<String>){
    val solution = Solution()
    solution.generateMatrix(4)
}