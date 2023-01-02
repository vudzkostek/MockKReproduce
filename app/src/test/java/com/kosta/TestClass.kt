package com.kosta

import com.kosta.mockkreproduction.SomeSealedClass
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class TestClass {

    @MockK
    lateinit var someSealedClass: SomeSealedClass

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        every { someSealedClass.field1 } returns null
        every { someSealedClass.field2 } returns null
    }

    @Test
    fun test() {
        // doin' something
    }
}