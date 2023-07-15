package com.puppycrawl

interface Searcher {
    fun search(word: String): SearchResult
}
