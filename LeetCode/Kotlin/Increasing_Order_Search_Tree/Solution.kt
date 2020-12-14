package Increasing_Order_Search_Tree

// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3553/

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    private var answer: TreeNode? = null

    private fun inOrderRecursive(cur: TreeNode?) {
        if (cur == null) return

        inOrderRecursive(cur.left)
        addToRoot(cur.`val`)
        inOrderRecursive(cur.right)
    }

    private fun addToRoot(newValue: Int){
        if(answer==null){
            answer = TreeNode(newValue)
        }else{
            var cur = answer
            while(cur?.right!=null){
                cur = cur.right
            }
            cur!!.right = TreeNode(newValue)
        }
    }

    fun increasingBST(root: TreeNode?): TreeNode? {
        inOrderRecursive(root)

        return answer
    }
}