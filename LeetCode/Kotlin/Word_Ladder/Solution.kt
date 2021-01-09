package Word_Ladder

// URI: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3598/

import java.util.LinkedList
import java.util.Queue

class Node(val word: String, val step: Int)

class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet = wordList.toMutableSet()
        val removeList = mutableListOf<String>()
        val queue: Queue<Node> = LinkedList()

        queue.add(Node(beginWord,1))

        while(queue.isNotEmpty()){
            val curNode = queue.poll()
            val curWord = curNode.word
            val curStep = curNode.step

            if(curWord == endWord) return curStep

            wordSet.forEach {
                if(canChange(curWord,it)){
                    queue.add(Node(it, curStep+1))
                    removeList.add(it)
                }
            }

            removeList.forEach {
                wordSet.remove(it)
            }
        }

        return 0
    }

    fun canChange(word1: String, word2: String): Boolean {
        var diffCount = 0

        for(idx in word1.indices){
            if(word1[idx]!=word2[idx]) diffCount++
            if(diffCount >= 2) return false
        }

        return true
    }
}