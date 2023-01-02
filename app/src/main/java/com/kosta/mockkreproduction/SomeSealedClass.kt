package com.kosta.mockkreproduction

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Field1(
    val component: String,
) : Parcelable


@Parcelize
data class Field2(
    val component: String,
) : Parcelable

sealed class SomeSealedClass : Parcelable {

    abstract val field1: Field1?
    abstract val field2: Field2?
    abstract val field3: String

    @Parcelize
    data class Subclass1(
        override val field1: Field1?,
        override val field2: Field2?,
        override val field3: String,
        val field4: Long,
    ) : SomeSealedClass()

    @Parcelize
    data class Subclass2(
        override val field1: Field1?,
        override val field2: Field2?,
        override val field3: String,
        val field4: String,
    ) : SomeSealedClass()

    @Parcelize
    data class Subclass3(
        override val field1: Field1? = null,
        override val field2: Field2? = null,
        override val field3: String,
        val field4: Field1,
        val field5: Field2,
    ) : SomeSealedClass()
}