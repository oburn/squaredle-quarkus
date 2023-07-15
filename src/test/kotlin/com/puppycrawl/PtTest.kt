package com.puppycrawl

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PtTest {

    @Test
    fun adjacent() {
        assertEquals(Pt(0, 0).adjacent(4, 4), listOf(Pt(1, 0), Pt(1, 1), Pt(0, 1)))
        assertEquals(Pt(3, 3).adjacent(4, 4), listOf(Pt(2, 2), Pt(3, 2), Pt(2, 3)))
        assertEquals(Pt(0, 3).adjacent(4, 4), listOf(Pt(0, 2), Pt(1, 2), Pt(1, 3)))
        assertEquals(Pt(3, 0).adjacent(4, 4), listOf(Pt(3, 1), Pt(2, 1), Pt(2, 0)))
        assertEquals(Pt(1, 0).adjacent(4, 4), listOf(Pt(2, 0), Pt(2, 1), Pt(1, 1), Pt(0, 1), Pt(0, 0)))
        assertEquals(
            Pt(1, 1).adjacent(4, 4),
            listOf(Pt(0, 0), Pt(1, 0), Pt(2, 0), Pt(2, 1), Pt(2, 2), Pt(1, 2), Pt(0, 2), Pt(0, 1))
        )
    }
}