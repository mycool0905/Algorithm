package Pacific_Atlantic_Water_Flow

// Pacific Atlantic Water Flow
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3684/

import java.util.LinkedList
import java.util.Queue

data class Point(val x: Int, val y: Int)

class Solution {

    fun pacificAtlantic(matrix: Array<IntArray>): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return answer
        }
        val rowLastIndex = matrix.lastIndex
        val columnLastIndex = matrix[0].lastIndex
        val visitedSet = Array(matrix.size) {
            Array(matrix[0].size) {
                mutableSetOf<Char>()
            }
        }

        val pacificStartList = mutableListOf<Point>()
        for (i in 0..rowLastIndex) {
            pacificStartList.add(Point(i, 0))
        }
        for (i in 0..columnLastIndex) {
            pacificStartList.add(Point(0, i))
        }

        val atlanticStartList = mutableListOf<Point>()
        for (i in 0..rowLastIndex) {
            atlanticStartList.add(Point(i, columnLastIndex))
        }

        for (i in 0..columnLastIndex) {
            atlanticStartList.add(Point(rowLastIndex, i))
        }

        flow(matrix, visitedSet, pacificStartList, 'P')
        flow(matrix, visitedSet, atlanticStartList, 'A')

        for (i in visitedSet.indices) {
            for (j in visitedSet[0].indices) {
                if (visitedSet[i][j].size == 2) {
                    answer.add(
                        listOf(i, j)
                    )
                }
            }
        }

        return answer
    }

    private fun flow(
        matrix: Array<IntArray>,
        visitedSet: Array<Array<MutableSet<Char>>>,
        startList: List<Point>,
        mark: Char
    ) {
        val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1)
        )
        val queue: Queue<Point> = LinkedList()
        startList.forEach {
            visitedSet[it.x][it.y].add(mark)
            queue.offer(it)
        }

        while (queue.isNotEmpty()) {
            val curPoint = queue.poll()

            for (dir in dirs) {
                val newX = curPoint.x + dir[0]
                val newY = curPoint.y + dir[1]

                if (newX !in matrix.indices || newY !in matrix[0].indices) {
                    continue
                }
                if (matrix[newX][newY] < matrix[curPoint.x][curPoint.y]) {
                    continue
                }
                if (visitedSet[newX][newY].contains(mark)) {
                    continue
                }

                queue.offer(Point(newX, newY))
                visitedSet[newX][newY].add(mark)
            }
        }
    }
}