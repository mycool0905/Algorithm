package Jump_Game_IV

// Jump Game IV
// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3582/

import java.util.LinkedList
import java.util.Queue

class Point(val index: Int, val step: Int)

class Solution {
    fun minJumps(arr: IntArray): Int {
        val queue: Queue<Point> = LinkedList()
        val visited = BooleanArray(arr.size)
        val link = mutableMapOf<Int, MutableList<Int>>()

        arr.forEachIndexed { index, value ->
            if (link[value] == null) {
                link[value] = mutableListOf()
            }
            link[value]!!.add(index)
        }

        visited[0] = true
        queue.offer(Point(0, 0))


        while (queue.isNotEmpty()) {
            val curPoint = queue.poll()
            val curIndex = curPoint.index
            val curStep = curPoint.step

            if (curIndex == arr.lastIndex) {
                return curStep
            }

            for (newIndex in link[arr[curIndex]]!!) {
                if (newIndex == curIndex) {
                    continue
                }

                if (visited[newIndex]) {
                    continue
                }

                visited[newIndex] = true
                queue.offer(Point(newIndex, curStep + 1))
            }

            link[arr[curIndex]]!!.clear()

            if (curIndex + 1 in arr.indices && !visited[curIndex + 1]) {
                visited[curIndex + 1] = true
                queue.offer(Point(curIndex + 1, curStep + 1))
            }
            if (curIndex - 1 in arr.indices && !visited[curIndex - 1]) {
                visited[curIndex - 1] = true
                queue.offer(Point(curIndex - 1, curStep + 1))
            }
        }

        return 0
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.minJumps(intArrayOf(7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,11))
}
