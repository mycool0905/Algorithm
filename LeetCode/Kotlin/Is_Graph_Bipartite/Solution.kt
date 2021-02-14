package Is_Graph_Bipartite

// Is Graph Bipartite?
// URI: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3639/

import java.util.LinkedList
import java.util.Queue

class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val mapping = mutableMapOf<Int, Int>()
        val queue: Queue<Int> = LinkedList()
        val visited = BooleanArray(graph.size)


        for (cur in graph.indices) {
            if (graph[cur].isEmpty() || visited[cur]) {
                continue
            }

            queue.offer(cur)
            visited[cur] = true

            while (queue.isNotEmpty()) {
                val u = queue.poll()

                for (v in graph[u]) {
                    if (mapping.containsKey(u)) {
                        if (mapping.containsKey(v)) {
                            if (mapping[u] == mapping[v]) {
                                return false
                            }
                        } else {
                            mapping[v] = -1 * mapping[u]!!
                        }
                    } else {
                        if (mapping.containsKey(v)) {
                            mapping[u] = -1 * mapping[v]!!
                        } else {
                            mapping[u] = 1
                            mapping[v] = -1
                        }
                    }

                    if (!visited[v]) {
                        queue.offer(v)
                        visited[v] = true
                    }
                }
            }
        }

        return true
    }
}

fun main(args: Array<String>) {
    Solution().isBipartite(
        arrayOf(
            intArrayOf(1),
            intArrayOf(0, 3),
            intArrayOf(3),
            intArrayOf(1, 2)
        )
    )
}