package Generate_Random_Point_in_a_Circle

// Generate Random Point in a Circle
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3675/
// ref: Google search: Generate Random Point in a Circle

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

class Solution(radius: Double, x_center: Double, y_center: Double) {

    private val r = radius
    private val centerX = x_center
    private val centerY = y_center

    fun randPoint(): DoubleArray {
        val radius = r * sqrt(Random.nextDouble())
        val theta = 2 * PI * Random.nextDouble()

        val dx = radius * sin(theta)
        val dy = radius * cos(theta)

        return doubleArrayOf(centerX + dx, centerY + dy)
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(radius, x_center, y_center)
 * var param_1 = obj.randPoint()
 */