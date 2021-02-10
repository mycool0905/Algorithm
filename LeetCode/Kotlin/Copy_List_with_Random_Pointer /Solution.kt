package `Copy_List_with_Random_Pointer `

// Copy List with Random Pointer
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3635/

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class Solution {
    fun copyRandomList(node: Node?): Node? {
        if(node == null){
            return null
        }

        val answer = Node(-1)
        val srcRefMap = mutableMapOf<Node?, Int>()
        val srcMatchMap = mutableMapOf<Int, Int>()
        val dstIdxMap = mutableMapOf<Int, Node?>()

        var idx = 0
        var curSrc = node
        var curDst = answer
        while(curSrc != null){
            curDst.next = Node(curSrc.`val`)

            srcRefMap[curSrc] = idx
            dstIdxMap[idx++] = curDst.next

            curSrc = curSrc.next
            curDst = curDst.next!!
        }

        idx = 0
        curSrc = node

        while(curSrc != null){
            val from = idx
            val to = srcRefMap.getOrDefault(curSrc, -1)

            srcMatchMap[from] = to

            curSrc = curSrc.next
        }

        idx = 0
        curDst = answer

        while(curDst.next != null){
            val to = srcMatchMap[idx]!!

            if(to > 0){
                curDst.next!!.random = dstIdxMap[to]
            }

            curDst = curDst.next!!
        }

        return answer.next
    }
}