package com.puppycrawl

import java.nio.file.Files
import java.nio.file.Path

class Dictionary(private val words: List<String>) : Searcher {
    companion object {
        fun fromFile(dictFile: Path, minLen: Int, maxLen: Int): Dictionary {
            val words =
                Files.lines(dictFile).filter { it.length in minLen..maxLen }.filter { it.all { c -> c.isLowerCase() } }
                    .toList()
            return Dictionary(words)
        }
    }

    override fun search(word: String): SearchResult {
        var exactMatch = false
        var partialMatch = false

        for (w in words) {
            if (w == word) {
                exactMatch = true
            } else if (w.startsWith(word)) {
                partialMatch = true
            }
            if (exactMatch && partialMatch) {
                break
            }
            // should really check if gone past where a match is possible
        }

        return SearchResult(exactMatch, partialMatch)
    }
}
