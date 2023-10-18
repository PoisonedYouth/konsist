package com.lemonappdev.sample

import com.lemonappdev.sample.LibClassTest

/**
 * Lib KDoc Test
 */
@Suppress("lib_argument_test")
class LibClassTest(val libParameterTest: String) : LibInterfaceTest {
    constructor(otherParameterTest: Int) : this(otherParameterTest.toString())

    init {
        val libVariableTest = ""
        println("Lib test init block")
    }
}

interface LibInterfaceTest

var libPropertyTest: LibClassTest = LibClassTest("")
    get() {
        val libVariableTest = ""
        return LibClassTest("lib value test")
    }
    private set(value) {
        val libVariableTest = ""
        if (true) field = value
    }

object LibObjectTest

enum class LibEnumClassTest {
    APP_CONSTANT {
        val libVariableTest = ""
    }
}

fun libFunctionTest() {
    @Suppress("detekt.UnusedPrivateProperty")
    val libVariableTest = ""
    println("some text")
}

typealias libTypeAliasTest = String
