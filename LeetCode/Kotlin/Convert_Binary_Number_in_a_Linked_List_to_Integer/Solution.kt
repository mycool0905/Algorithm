package Convert_Binary_Number_in_a_Linked_List_to_Integer

// Convert Binary Number in a Linked List to Integer

import kotlin.math.pow

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        var result = 0
        var cur: ListNode? = head
        val list = mutableListOf<Int>()

        while (cur != null) {
            list.add(cur.`val`)
            cur = cur.next
        }

        list.reversed()
            .mapIndexed { idx, value ->
                value * (2.0.pow(idx.toDouble())).toInt()
            }.forEach {
                result += it
            }

        return result
    }
}
