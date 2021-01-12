package Add_Two_Numbers

// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3601/

class ListNode(var `val`: Int) {
      var next: ListNode? = null
 }

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val answer = ListNode(-1)
        var remain = 0

        var cur = answer
        var cur1 = l1
        var cur2 = l2

        while(cur1 != null && cur2 != null){
            val curValue = cur1.`val` + cur2.`val` + remain
            remain = curValue / 10
            cur.next = ListNode(curValue%10)
            cur = cur.next!!
            cur1 = cur1.next
            cur2 = cur2.next
        }

        fun singleListProcess(curList: ListNode?){
            var curNode = curList
            while(curNode != null){
                val curValue = curNode.`val` + remain
                remain = curValue / 10
                cur.next = ListNode(curValue%10)
                cur = cur.next!!
                curNode = curNode.next
            }
        }

        singleListProcess(cur1)
        singleListProcess(cur2)

        if(remain != 0){
            cur.next = ListNode(remain)
        }

        return answer.next
    }
}

fun main(args: Array<String>){
    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(3)

    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next!!.next = ListNode(4)
    Solution().addTwoNumbers(l1,l2)
}