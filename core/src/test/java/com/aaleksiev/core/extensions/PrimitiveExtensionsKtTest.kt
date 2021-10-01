package com.aaleksiev.core.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class PrimitiveExtensionsKtTest {

    @Test
    fun `given null int value then orZero wil return 0`() {
        val underTest: Int? = null

        assertEquals(0, underTest.orZero())
    }

    @Test
    fun `given not null int value then orZero wil return the value`() {
        val underTest: Int? = 10

        assertEquals(10, underTest.orZero())
    }
}