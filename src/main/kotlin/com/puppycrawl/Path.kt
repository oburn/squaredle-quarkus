package com.puppycrawl

data class Path(val word: String, val steps: List<Pt>) {
    fun visited(pt: Pt): Boolean = steps.contains(pt)
    fun addStep(pt: Pt, char: Char): Path {
        return Path(word = word + char, steps = steps + pt)
    }
}
