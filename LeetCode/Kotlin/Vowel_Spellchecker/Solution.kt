package Vowel_Spellchecker

// Vowel Spellchecker
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3681/

import java.util.TreeMap

class Solution {

    class TrieNode(val childNode: TreeMap<Char, TrieNode> = TreeMap<Char, TrieNode>())

    class Trie(
        private val root: TrieNode = TrieNode(),
        private val firstWord: TreeMap<String, String> = TreeMap<String, String>()
    ) {
        fun insert(input: String) {
            var curNode = root

            input.forEach {
                if (curNode.childNode[it] == null) {
                    curNode.childNode[it] = TrieNode()
                }
                curNode = curNode.childNode[it]!!
            }

            val lowerCase = input.toLowerCase()
            if (firstWord[lowerCase] == null) {
                firstWord[lowerCase] = input
            }

            val noVowel = lowerCase.replace(("[aeiou]").toRegex(), "*")
            if (firstWord[noVowel] == null) {
                firstWord[noVowel] = input
            }
        }

        fun exactFind(input: String): Boolean {
            var curNode = root

            for (char in input) {
                if (curNode.childNode[char] == null) {
                    return false
                } else {
                    curNode = curNode.childNode[char]!!
                }
            }
            return true
        }

        fun caseInsensitiveFind(input: String): String {
            val lowerCase = input.toLowerCase()
            if (firstWord[lowerCase] != null) {
                return firstWord[lowerCase]!!
            }

            return ""
        }

        fun vowelErrorFind(input: String): String {
            val vowelError = input.toLowerCase().replace(("[aeiou]").toRegex(), "*")
            if (firstWord[vowelError] != null) {
                return firstWord[vowelError]!!
            }

            return ""
        }
    }

    fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        val trie = Trie()
        val answer = Array(queries.size) { "" }

        wordlist.forEach {
            trie.insert(it)
        }

        queries.forEachIndexed { idx, str ->
            var inserted = false
            var result = ""

            if (trie.exactFind(str)) {
                result = str
                inserted = true
            }

            if (!inserted) {
                result = trie.caseInsensitiveFind(str)
                if (result != "") {
                    inserted = true
                }
            }

            if (!inserted) {
                result = trie.vowelErrorFind(str)
            }

            answer[idx] = result
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val solution = Solution().spellchecker(
        arrayOf(
            "KiTe", "kite", "hare", "Hare"
        ),
        arrayOf(
            "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"
        )
    )
}