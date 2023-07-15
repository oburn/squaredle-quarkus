package com.puppycrawl

data class Pt(val x: Int, val y: Int) {
    fun adjacent(width: Int, height: Int): List<Pt> {
        return listOf(
            Pt(x - 1, y - 1),
            Pt(x, y - 1),
            Pt(x + 1, y - 1),
            Pt(x + 1, y),
            Pt(x + 1, y + 1),
            Pt(x, y + 1),
            Pt(x - 1, y + 1),
            Pt(x - 1, y),
        )
            .filter { it.x >= 0 }
            .filter { it.x < width }
            .filter { it.y >= 0 }
            .filter { it.y < height }
    }
}
