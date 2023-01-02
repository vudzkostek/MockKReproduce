package com.kosta.mockkreproduction

data class SomeResult(val value: String)

interface Repository {

    suspend fun fetchBy(input: OtherSealedClass): Result<SomeResult>
}