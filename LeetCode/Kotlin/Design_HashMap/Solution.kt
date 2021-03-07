package Design_HashMap

// Design HashMap
// URI: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3663/

class MyHashMap() {

    /** Initialize your data structure here. */
    private val hashArray = Array<MutableList<KeyValue>>(9973) {
        mutableListOf()
    }

    data class KeyValue(val key: Int, var value: Int)

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        val hashIndex = getHashIndex(key)
        val indexOfFirst = hashArray[hashIndex].indexOfFirst { it.key == key }
        if (indexOfFirst == -1) {
            hashArray[hashIndex].add(KeyValue(key, value))
        } else {
            hashArray[hashIndex][indexOfFirst].value = value
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        val hashIndex = getHashIndex(key)
        val indexOfFirst = hashArray[hashIndex].indexOfFirst { it.key == key }
        return if (indexOfFirst == -1) -1 else hashArray[hashIndex][indexOfFirst].value
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        val hashIndex = getHashIndex(key)
        val indexOfFirst = hashArray[hashIndex].indexOfFirst { it.key == key }
        if (indexOfFirst != -1) {
            hashArray[hashIndex].removeAt(indexOfFirst)
        }
    }

    private fun getHashIndex(key: Int) = key % 199
}