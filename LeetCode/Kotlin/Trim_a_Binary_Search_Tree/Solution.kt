package Trim_a_Binary_Search_Tree

// Trim a Binary Search Tree
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3626/

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    var isChanged = false

    fun trimBSTFaster(root: TreeNode?, low: Int, high: Int): TreeNode? {
        if(root == null) return null
        if(root.`val` > high) return trimBST(root.left, low, high)
        if(root.`val` < low) return trimBST(root.right, low, high)

        root.left = trimBST(root.left, low, high)
        root.right = trimBST(root.right, low, high)
        return root
    }

    fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
        val curRoot = findRoot(root, low, high)

        do {
            isChanged = false
            attachLowBound(curRoot, low)
            attachHighBound(curRoot, high)
        }while(isChanged)

        return curRoot
    }

    fun findRoot(root: TreeNode?, low: Int, high: Int): TreeNode? {
        var cur = root

        while (cur != null) {
            when (cur.`val`) {
                in low..high -> {
                    return cur
                }
                in 0 until low -> {
                    cur = cur.right
                }
                in high + 1..10000 -> {
                    cur = cur.left
                }
            }
        }

        return cur
    }

    fun attachLowBound(root: TreeNode?, low: Int) {
        var cur = root

        while (cur!!.left != null) {
            if (low > cur.left!!.`val`) {
                isChanged = true
                break
            }
            cur = cur.left
        }

        val attached = cur
        var find = cur.left

        while (find != null) {
            if (find.`val` >= low) {
                break
            }
            find = find.right
        }
        attached.left = find
    }

    fun attachHighBound(root: TreeNode?, high: Int) {
        var cur = root

        while (cur!!.right != null) {
            if (high < cur.right!!.`val`) {
                isChanged = true
                break
            }
            cur = cur.right
        }

        val attached = cur
        var find = cur.right

        while (find != null) {
            if (find.`val` <= high) {
                break
            }
            find = find.left
        }
        attached.right = find
    }
}

fun main(args: Array<String>){
    val root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(2)
    Solution().trimBST(root,1,2)
}