package Coin_Change

// Coin Change
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3668/
// ref: https://kimchanjung.github.io/algorithm/2020/05/08/Coin-Change/

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val amounts = IntArray(amount + 1)
        val result = recursive(coins, amounts, amount)

        return if (result > amount) {
            -1
        } else {
            result
        }
    }

    fun recursive(coins: IntArray, amounts: IntArray, amount: Int): Int {

        if (amount < 0) return Int.MAX_VALUE - 1
        if (amount == 0) return 0
        if (amounts[amount] > 0) return amounts[amount]

        var min = Int.MAX_VALUE - 1

        for (coin in coins) {
            min = minOf(min, recursive(coins, amounts, amount - coin) + 1);
        }

        amounts[amount] = min

        return amounts[amount]
    }
}