package Validate_Binary_Search_Tree

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3568/

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    private var answer: Boolean = true
    private var lastPickedValue: Long = Int.MIN_VALUE.toLong() - 1

    fun isValidBST(root: TreeNode?): Boolean {
        inOrder(root)
        return answer
    }

    private fun inOrder(cur: TreeNode?) {
        if (!answer || cur == null) return

        inOrder(cur.left)
        if (lastPickedValue < cur.`val`) lastPickedValue = cur.`val`.toLong()
        else answer = false
        inOrder(cur.right)
    }

    private fun devideAndConquer(cur: TreeNode?, min: Long, max: Long): Boolean{
        if(cur == null) return true

        if(cur.`val` < min || cur.`val` > max) return false

        return devideAndConquer(cur.left, min, cur.`val`.toLong()-1) && devideAndConquer(cur.right, cur.`val`.toLong()+1, max)
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val root = TreeNode(-2147483648)
    root.left = TreeNode(-2147483648)

    solution.isValidBST(root)
}