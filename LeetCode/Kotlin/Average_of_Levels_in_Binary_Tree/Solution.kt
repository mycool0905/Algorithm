package Average_of_Levels_in_Binary_Tree

// Average of Levels in Binary Tree
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3661/

import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Node(val treeNode: TreeNode?, val depth: Int)

class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val sumMap = mutableMapOf<Int, Double>()
        val cntMap = mutableMapOf<Int, Int>()

        val queue: Queue<Node> = LinkedList()
        queue.offer(Node(root, 0))

        while (queue.isNotEmpty()) {
            val curNode = queue.poll()
            val curTreeNode = curNode.treeNode ?: continue
            val curDepth = curNode.depth

            sumMap[curDepth] = sumMap.getOrDefault(curDepth, 0.0) + curTreeNode.`val`
            cntMap[curDepth] = cntMap.getOrDefault(curDepth, 0) + 1

            queue.offer(Node(curTreeNode.left, curDepth + 1))
            queue.offer(Node(curTreeNode.right, curDepth + 1))
        }

        val answer = DoubleArray(sumMap.size)

        for (key in sumMap.keys) {
            answer[key] = sumMap[key]!! / cntMap[key]!!
        }

        return answer
    }
}