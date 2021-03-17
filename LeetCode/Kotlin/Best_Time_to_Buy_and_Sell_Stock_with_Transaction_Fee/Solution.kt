package Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee

// Best Time to Buy and Sell Stock with Transaction Fee
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3674/
// ref: https://github.com/cherryljr/LeetCode/blob/master/Best%20Time%20to%20Buy%20and%20Sell%20Stock%20with%20Transaction%20Fee.java

class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var notHold = 0
        var hold = -123456789

        for (i in prices.indices) {
            hold = maxOf(hold, notHold - prices[i]);
            notHold = maxOf(notHold, hold + prices[i] - fee);
        }

        return notHold
    }
}