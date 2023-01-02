package com.kosta.mockkreproduction

sealed class OtherSealedClass { // should be sealed interface but doesn't really matter in term of reproducing issue
    data class Subtype1(val value: String) : OtherSealedClass()
    data class Subtype2(val value: String) : OtherSealedClass()
}