package Pseudo_Palindromic_Paths_in_a_Binary_Tree

// URI: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3585/

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        val check = mutableMapOf<Int, Int>()
        var answer = 0

        fun dfs(curNode: TreeNode?) {
            // Never run this
            if (curNode == null) {
                return
            }

            check[curNode.`val`] = check.getOrDefault(curNode.`val`, 0).plus(1)

            // Leaf Node
            if (curNode.left == null && curNode.right == null) {
                if (checkIfPseudoPalindrome(check)) {
                    answer++
                }
            }

            // Left Child
            if (curNode.left != null) {
                dfs(curNode.left)
            }
            // Right Child
            if (curNode.right != null) {
                dfs(curNode.right)
            }

            check[curNode.`val`] = check[curNode.`val`]!!.minus(1)
            if(check[curNode.`val`]==0) check.remove(curNode.`val`)
        }

        dfs(root)

        return answer
    }

    private fun checkIfPseudoPalindrome(check: MutableMap<Int, Int>): Boolean {
        val totalCount = check.map { it.value }.reduce { acc, i -> acc + i }

        if (totalCount == 1) return true

        val oddCount = check.count { it.value % 2 == 1 }

        return if (totalCount % 2 == 0) oddCount == 0
        else oddCount == 1
    }
}

fun main(args: Array<String>){
    val root = TreeNode(2)
    root.left = TreeNode(3)
    root.right = TreeNode(1)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(1)
    root.right!!.right = TreeNode(1)
    println(Solution().pseudoPalindromicPaths(root))
}