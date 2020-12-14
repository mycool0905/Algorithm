package Can_Place_Flowers

// URI: https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3555/

class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (flowerbed.isEmpty()) return false
        val newFlowerBed = flowerbed.toMutableList()

        if (flowerbed.first() == 0) {
            newFlowerBed.add(0, 0)
            newFlowerBed.add(0, 1)
        }
        if (flowerbed.last() == 0) {
            newFlowerBed.add(0)
            newFlowerBed.add(1)
        }

        var canPlaceCount = 0
        var curZeroCount = 0

        for (cur in newFlowerBed) {
            if (cur == 0) curZeroCount++
            else {
                canPlaceCount += (curZeroCount - 1) / 2
                if (canPlaceCount >= n) return true
                curZeroCount = 0
            }
        }

        return false
    }
}

fun main(args: Array<String>){
    val solution = Solution()
    solution.canPlaceFlowers(intArrayOf(1,0,0,0,1,0,0), 2)
}