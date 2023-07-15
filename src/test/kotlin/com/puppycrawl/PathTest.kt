package com.puppycrawl

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PathTest {

    @Test
    fun visited() {
        assertEquals(true, Path(word = "", steps = listOf(Pt(0, 0))).visited(Pt(0, 0)))
        assertEquals(false, Path(word = "", steps = listOf(Pt(0, 0))).visited(Pt(0, 1)))
        assertEquals(true, Path(word = "", steps = listOf(Pt(0, 0), Pt(1, 1))).visited(Pt(0, 0)))
        assertEquals(false, Path(word = "", steps = listOf(Pt(0, 0), Pt(1, 1))).visited(Pt(0, 1)))
        assertEquals(true, Path(word = "", steps = listOf(Pt(0, 0), Pt(1, 1))).visited(Pt(1, 1)))
    }

    @Test
    fun addStep() {
        assertEquals(
            Path(word = "ab", steps = listOf(Pt(0, 0), Pt(1,1))),
            Path(word = "a", steps = listOf(Pt(0, 0))).addStep(pt = Pt(1,1), char = 'b')
        )
    }
}