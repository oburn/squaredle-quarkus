package com.puppycrawl

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class DictionaryTest {

    @Test
    fun search() {
        val dict = Dictionary.fromFile(
            dictFile = Paths.get("/Users/oburn/work/squaredle-quarkus/src/test/resources/sample.dict"),
            minLen = 3,
            maxLen = 5,
        )
        assertNotNull(dict)
    }
}
