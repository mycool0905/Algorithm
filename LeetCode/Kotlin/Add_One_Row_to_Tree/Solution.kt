package Add_One_Row_to_Tree

// Add One Row to Tree
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3666/

import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    class Node(val node: TreeNode?, val depth: Int)

    fun addOneRow(root: TreeNode?, v: Int, d: Int): TreeNode? {
        if (d == 1) {
            val newRoot = TreeNode(v)
            newRoot.left = root

            return newRoot
        } else {
            val queue: Queue<Node> = LinkedList()
            queue.offer(Node(root, 1))

            while (queue.isNotEmpty()) {
                val cur = queue.poll()

                if (cur.node == null) {
                    continue
                }

                if (cur.depth == d - 1) {
                    val leftNode = cur.node.left
                    cur.node.left = TreeNode(v)
                    cur.node.left!!.left = leftNode

                    val rightNode = cur.node.right
                    cur.node.right = TreeNode(v)
                    cur.node.right!!.right = rightNode
                } else {

                    if (cur.node.left != null) {
                        queue.offer(Node(cur.node.left, cur.depth + 1))
                    }
                    if (cur.node.right != null) {
                        queue.offer(Node(cur.node.right, cur.depth + 1))
                    }
                }
            }

            return root
        }
    }
}