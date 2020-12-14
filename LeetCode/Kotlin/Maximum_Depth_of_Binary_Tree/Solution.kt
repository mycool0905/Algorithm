package Maximum_Depth_of_Binary_Tree

// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3551/

import java.util.LinkedList
import java.util.Queue

class TreeNode(var `var`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

data class QueueNode(val treeNode: TreeNode, val depth: Int)

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        val queue: Queue<QueueNode> = LinkedList<QueueNode>()
        var answer = 0

        if (root == null) return answer
        queue.offer(QueueNode(root, 1))

        while (queue.isNotEmpty()) {
            val curQueueNode = queue.poll()
            val curTreeNode = curQueueNode.treeNode
            val curDepth = curQueueNode.depth

            if (curDepth > answer) answer = curDepth

            curTreeNode.left?.let { queue.offer(QueueNode(it, curDepth + 1)) }
            curTreeNode.right?.let { queue.offer(QueueNode(it, curDepth + 1)) }
        }

        return answer
    }
}