package Vertical_Order_Traversal_of_a_Binary_Tree

// Vertical Order Traversal of a Binary Tree
// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/583/week-5-january-29th-january-31st/3621/

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Point(var `val`: Int, var y: Int) : Comparable<Point> {
    override fun compareTo(other: Point): Int =
        if (y == other.y)
            `val` - other.`val`
        else
            other.y - y
}

class Solution {

    val verticalMap = mutableMapOf<Int, MutableList<Point>>()

    fun inOrder(curNode: TreeNode?, curX: Int, curY: Int) {
        if (curNode == null) {
            return;
        }

        if(verticalMap[curX] == null){
            verticalMap[curX] = mutableListOf()
        }
        verticalMap[curX]!!.add(Point(curNode.`val`,curY))

        if (curNode.left != null) {
            inOrder(curNode.left, curX - 1, curY - 1)
        }
        if (curNode.right != null) {
            inOrder(curNode.right, curX + 1, curY - 1)
        }
    }

    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        inOrder(root, 0, 0)

        val answer = mutableListOf<List<Int>>()
        verticalMap.toSortedMap().forEach {
            (k,v) -> answer.add(v.sorted().map{ it.`val` })
        }

        return answer
    }
}