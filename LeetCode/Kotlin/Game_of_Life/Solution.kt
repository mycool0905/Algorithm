package Game_of_Life

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3586/

class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val liveCellCount = Array(board.size) {
            IntArray(board.first().size)
        }

        for (curX in board.indices) {
            for (curY in board.first().indices) {
                for (dx in -1..1) {
                    for (dy in -1..1) {
                        if (dx == 0 && dy == 0) continue
                        val newX = curX + dx
                        val newY = curY + dy

                        if (newX !in board.indices || newY !in board.first().indices) continue
                        liveCellCount[curX][curY] += board[newX][newY]
                    }
                }
            }
        }

        for (curX in board.indices){
            for(curY in board.first().indices){
                when(board[curX][curY]){
                    1 -> {
                        if(liveCellCount[curX][curY] !in 2..3){
                            board[curX][curY] = 0
                        }
                    }
                    else -> {
                        if(liveCellCount[curX][curY]==3) {
                            board[curX][curY] = 1
                        }
                    }
                }
            }
        }
    }
}