package com.puppycrawl

data class Grid(val rows: List<String>, val searcher: Searcher) {
    fun solve(): List<Path> {
        val result = mutableListOf<Path>()

        rows.forEachIndexed { y, row ->
            row.forEachIndexed { x, ch ->
                result.addAll(wordsFrom(path = Path(steps = listOf(Pt(x, y)), word = "" + ch)))
            }
        }
        return result
    }

    fun wordsFrom(path: Path): List<Path> {
        val result = mutableListOf<Path>()

        if (path.word.length > 10) {
            return result
        }

        val sr = searcher.search(path.word)
        if (sr.exactMatch) {
            result.add(path)
        }

        if (sr.partialMatch) {
            path.steps.last()
                .adjacent(width = rows.first().length, height = rows.size)
                .filterNot { path.visited(it) }
                .map { path.addStep(it, rows[it.y][it.x]) }
                .flatMap { wordsFrom(it) }
                .forEach { result.add(it) }
        }
        return result
    }
}
