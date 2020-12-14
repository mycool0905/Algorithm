package Smallest_Subtree_with_all_the_Deepest_Nodes

// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3563/

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    private val MAX_NODE_COUNT = 500
    private val MAX_LOG = 10
    private var deepestDepth = -1
    private val deepestNodes = mutableListOf<Int>()
    private val valueToNode = mutableMapOf<Int, TreeNode>()
    private val depthArray = IntArray(MAX_NODE_COUNT + 1)
    private val parentArray = Array(MAX_NODE_COUNT + 1) {
        IntArray(MAX_LOG)
    }

    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        dfs(root, 0)
        for (j in 1 until MAX_LOG) {
            for (i in 0 until MAX_NODE_COUNT) {
                parentArray[i][j] = parentArray[parentArray[i][j - 1]][j - 1]
            }
        }
        return valueToNode[LCA()]
    }

    private fun dfs(cur: TreeNode?, depth: Int) {
        if (cur == null) return
        valueToNode[cur.`val`] = cur
        depthArray[cur.`val`] = depth
        if (depth > deepestDepth) {
            deepestNodes.clear()
            deepestDepth = depth
        }
        if (depth == deepestDepth) deepestNodes.add(cur.`val`)


        if (cur.left != null) {
            parentArray[cur.left!!.`val`][0] = cur.`val`
            dfs(cur.left, depth + 1)
        }
        if (cur.right != null) {
            parentArray[cur.right!!.`val`][0] = cur.`val`
            dfs(cur.right, depth + 1)
        }
    }

    private fun LCA(): Int {
        if (deepestNodes.size == 1) return deepestNodes.first()
        var cur = deepestNodes.first()

        for (idx in 1 until deepestNodes.size) {
            var other = deepestNodes[idx]

            for (i in MAX_LOG - 1 downTo 0) {
                if (depthArray[other] - depthArray[cur] >= (1 shl i)) {
                    other = parentArray[other][i]
                }
            }

            if (cur == other) return cur
            for (i in MAX_LOG - 1 downTo 0) {
                if (parentArray[cur][i] != parentArray[other][i]) {
                    cur = parentArray[cur][i]
                    other = parentArray[other][i]
                }
            }
        }

        return parentArray[cur][0]
    }
}

class Solution2 {

    private fun getDeepestDepth(cur: TreeNode?): Int =
        if (cur == null) {
            0
        } else {
            maxOf(getDeepestDepth(cur.left), getDeepestDepth(cur.right)) + 1
        }

    private fun getLCA(cur: TreeNode?, depth: Int, deepestDepth: Int): TreeNode? {
        if(cur == null) return null
        if(cur.left == null && cur.right==null && depth == deepestDepth) return cur

        val left = getLCA(cur.left, depth+1, deepestDepth)
        val right = getLCA(cur.right, depth+1, deepestDepth)

        return when{
            left != null && right != null -> cur
            left != null -> left
            else -> right
        }
    }

    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        return getLCA(root, 1, getDeepestDepth(root))
    }
}