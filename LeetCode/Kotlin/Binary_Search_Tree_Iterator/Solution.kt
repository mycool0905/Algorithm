package Binary_Search_Tree_Iterator

// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3560/

import java.util.Stack

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BSTIterator(root: TreeNode?) {

    private val list = mutableListOf<Int>()
    private var curIdx = 0

    init{
        inOrder(root)
    }

    private fun inOrder(cur: TreeNode?){
        if(cur==null) return

        inOrder(cur.left)
        list.add(cur.`val`)
        inOrder(cur.right)
    }

    fun next(): Int {
        return list[curIdx++]
    }

    fun hasNext(): Boolean {
        return curIdx < list.size
    }
}


class BSTIterator2(root: TreeNode?) {

    private val stack = Stack<TreeNode>()
    private var cur = root

    fun next(): Int {
        while(cur != null){
            stack.push(cur)
            cur = cur!!.left
        }
        val node = stack.pop()
        cur = node.right

        return node.`val`
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty() || cur != null
    }
}