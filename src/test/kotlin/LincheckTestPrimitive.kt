package com.example.linchecksample

import NaiveConcurrentDataStructure
import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.ModelCheckingOptions
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import kotlin.test.Test

class LincheckTestPrimitive {

    private val dataStructure = NaiveConcurrentDataStructure<Int>()

    @Operation
    fun save(value: Int) = dataStructure.save(value)

    @Operation
    fun remove(value: Int) = dataStructure.remove(value)

    @Operation
    fun count() = dataStructure.count()

    @Test
    fun stressTest() = StressOptions().check(this::class)
}

