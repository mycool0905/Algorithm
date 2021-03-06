package Short_Encoding_of_Words

// Short Encoding of Words
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3662/

import java.util.TreeMap

data class TrieNode(val childNodes: TreeMap<Char, TrieNode> = TreeMap<Char, TrieNode>())

class Trie(private val rootNode: TrieNode = TrieNode()) {

    fun insert(input: String): Int {
        var curNode = rootNode
        var isNew = false

        input.forEach {
            if (curNode.childNodes[it] == null) {
                curNode.childNodes[it] = TrieNode()
                isNew = true
            }
            curNode = curNode.childNodes[it]!!
        }

        return if (isNew) input.length + 1 else 0
    }
}

class Solution {

    fun minimumLengthEncoding(words: Array<String>): Int {
        val sortedWords = words.sortedByDescending { it.length }
        val trie = Trie()
        var answer = 0

        sortedWords.forEach {
            answer += trie.insert(it.reversed())
        }

        return answer
    }
}

fun main(args: Array<String>){
    Solution().minimumLengthEncoding(arrayOf("me","time"))
}