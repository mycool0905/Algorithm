package Convert_BST_to_Greater_Tree

// Convert BST to Greater Tree
// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3634/

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    var accumulated = 0

    fun convertBST(root: TreeNode?): TreeNode? {

        reversedInOrder(root)

        return root
    }

    fun reversedInOrder(cur: TreeNode?) {
        if(cur == null) return

        reversedInOrder(cur.right)
        accumulated += cur.`val`
        cur.`val` = accumulated
        reversedInOrder(cur.left)
    }
}