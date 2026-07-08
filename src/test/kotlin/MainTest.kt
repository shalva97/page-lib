package org.example

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainTest {
    @Test
    fun testPrintHelloWorld() {
        assertDoesNotThrow {
            printHelloWorld()
        }
    }
}