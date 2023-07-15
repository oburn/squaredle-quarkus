package com.puppycrawl

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class DictionaryTest {

    @Test
    fun search() {
        val dict = Dictionary.fromFile(
            dictFile = Paths.get("src", "test", "resources", "sample.dict"),
            minLen = 4,
            maxLen = 5,
        )
        assertNotNull(dict)

        val r1 = dict.search("xx")
        assertEquals(false, r1.exactMatch)
        assertEquals(false, r1.partialMatch)
        val r2 = dict.search("aa")
        assertEquals(false, r2.exactMatch)
        assertEquals(true, r2.partialMatch)
        val r3 = dict.search("ab")
        assertEquals(false, r3.exactMatch)
        assertEquals(false, r3.partialMatch)
    }
}
