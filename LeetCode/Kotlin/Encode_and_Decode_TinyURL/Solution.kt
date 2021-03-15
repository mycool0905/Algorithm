package Encode_and_Decode_TinyURL

// Encode and Decode TinyURL
// https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3673/

class Codec() {
    private val cache = mutableMapOf<String, String>()
    private val domain = "http://tinyurl.com/"

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        val shortUrl = domain + longUrl.hashCode().toString()
        cache[shortUrl] = longUrl
        return shortUrl
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return cache[shortUrl]!!
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var url = obj.encode(longUrl)
 * var ans = obj.decode(url)
 */