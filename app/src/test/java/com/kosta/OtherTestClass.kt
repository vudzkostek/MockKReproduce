package com.kosta

import com.kosta.mockkreproduction.OtherSealedClass
import com.kosta.mockkreproduction.Repository
import com.kosta.mockkreproduction.SomeResult
import com.kosta.mockkreproduction.SubjectUsecaseClass
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class OtherTestClass {

    @MockK
    private lateinit var repository: Repository

    @MockK
    private lateinit var otherSealedClass: OtherSealedClass

    private lateinit var subject: SubjectUsecaseClass

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        subject = SubjectUsecaseClass(repository)
    }

    @Test
    fun test() = runTest {
        val someResult = mockk<SomeResult>()
        val otherSealedClass = mockk<OtherSealedClass>()
        coEvery { repository.fetchBy(otherSealedClass) } returns Result.success(someResult)

        val result = subject(otherSealedClass)

        assertThat(result.isSuccess).isTrue
        assertThat(result.getOrThrow()).isEqualTo(someResult)
    }
}