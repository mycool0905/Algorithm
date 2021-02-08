package Peeking_Iterator

// Peeking Iterator
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3633/

// Kotlin Iterator reference:
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/

class PeekingIterator(iterator: Iterator<Int>) : Iterator<Int> {

    /*
    Simple Solution

    val iterList = mutableListOf<Int>()
    var idx = 0

    init {
        iterator.forEach {
            iterList.add(it)
        }
    }

    fun peek(): Int = iterList[idx]
    override fun next(): Int = iterList[idx++]
    override fun hasNext(): Boolean = idx < iterList.size
     */


    // Iterator Solution
    val curIterator = iterator
    var isPeeked: Boolean = false
    var peekedNumber: Int = -1

    fun peek(): Int {
        if(!isPeeked){
            isPeeked = true
            peekedNumber = curIterator.next()
        }
        return peekedNumber
    }

    override fun next(): Int =
        if(isPeeked){
            isPeeked = false
            peekedNumber
        }else{
            curIterator.next()
        }

    override fun hasNext(): Boolean =
        if(isPeeked){
            isPeeked
        } else {
            curIterator.hasNext()
        }
}

/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */