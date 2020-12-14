package Linked_List_Random_Node

// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3552/

import kotlin.random.Random

class ListNode(var `val`: Int){
    var next: ListNode? = null
}
class Solution(head: ListNode?) {

    private val linkedList = head

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    private fun getSize(head: ListNode?): Int {
        var result = 0
        var check = head

        while(check != null){
            result++
            check = check.next
        }

        return result
    }

    private fun getNthListNode(n: Int): Int{
        var cur = linkedList
        for(i in 0 until n){
            cur = cur!!.next
        }

        return cur!!.`val`
    }

    /** Returns a random node's value. */
    fun getRandom(): Int {
        val size = getSize(linkedList)
        val n = Random.nextInt(size)


        return getNthListNode(n)
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(head)
 * var param_1 = obj.getRandom()
 */