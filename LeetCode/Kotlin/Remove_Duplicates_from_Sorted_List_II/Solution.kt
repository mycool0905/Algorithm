package Remove_Duplicates_from_Sorted_List_II

// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3593/

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val answer = ListNode(Int.MIN_VALUE)
        val check = mutableSetOf<Int>()

        var cur: ListNode? = head ?: return null
        while(cur!!.next != null){
            if(cur.`val` == cur.next!!.`val`){
                check.add(cur.`val`)
            }
            cur = cur.next
        }

        var curNode = head
        var answerNext = answer
        while(curNode != null){
            if(curNode.`val` !in check){
                answerNext.next = curNode
                curNode = curNode.next
                answerNext = answerNext.next!!
                answerNext.next = null
            }else {
                curNode = curNode.next
            }
        }

        return answer.next
    }
}

fun main(args: Array<String>) {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(2)
    Solution().deleteDuplicates(head)
}