package Balanced_Binary_Tree

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3577/

import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        val queue: Queue<TreeNode> = LinkedList()

        queue.offer(root)

        while (queue.isNotEmpty()) {
            val cur = queue.poll() ?: continue

            if (maxDepth(cur.left, 0) - maxDepth(cur.right, 0) !in -1..1) return false

            queue.offer(cur.left)
            queue.offer(cur.right)
        }

        return true
    }

    private fun maxDepth(cur: TreeNode?, depth: Int): Int =
        if (cur == null) depth
        else maxOf(maxDepth(cur.left, depth + 1), maxDepth(cur.right, depth + 1))
}