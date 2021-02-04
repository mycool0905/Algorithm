package Insertion_Sort_List

// Insertion Sort List

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun insertionSortList(head: ListNode?): ListNode? {
        val list = mutableListOf<Int>()
        var headPtr = head

        while(headPtr != null){
            list.add(headPtr.`val`)
            headPtr = headPtr.next
        }

        list.sort()

        var answer: ListNode? = null
        var answerPtr: ListNode? = null

        list.forEachIndexed{
            idx, value ->
            if(idx==0){
                answer = ListNode(value)
                answerPtr = answer
            }else{
                answerPtr!!.next = ListNode(value)
                answerPtr = answerPtr!!.next
            }
        }

        return answer
    }
}

fun main(){
    val first = ListNode(4)
    val second = ListNode(2)
    val third = ListNode(1)
    val forth = ListNode(3)

    first.next = second
    second.next = third
    third.next = forth

    val solution = Solution()
    solution.insertionSortList(first)
}
