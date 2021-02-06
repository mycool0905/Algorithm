package Binary_Tree_Right_Side_View

// Binary Tree Right Side View
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3630/

class TreeNode(var `val`: Int) {
      var left: TreeNode? = null
      var right: TreeNode? = null
}

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val answer = mutableMapOf<Int,Int>()

        fun inOrder(cur: TreeNode?, depth: Int){
            if(cur==null){
                return
            }

            inOrder(cur.left, depth+1)
            answer[depth] = cur.`val`
            inOrder(cur.right, depth+1)
        }

        inOrder(root, 1)

        return answer.toSortedMap().map { it.value }
    }
}