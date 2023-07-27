package com.example.linchecksample

import NaiveConcurrentDataStructure
import SomeClass
import org.jetbrains.kotlinx.lincheck.RandomProvider
import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.annotations.Param
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.paramgen.ParameterGenerator
import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.ModelCheckingOptions
import org.junit.jupiter.api.Test

const val PARAM_NAME = "param_some_class"

@Param(name = PARAM_NAME, gen = SomeClassGenerator::class)
class SampleLincheckTest {

    private val dataStructure = NaiveConcurrentDataStructure<SomeClass>()

    @Operation
    fun save(@Param(name = PARAM_NAME, conf = "Default") someClass: SomeClass) = dataStructure.save(someClass)

    @Operation
    fun remove(@Param(name = PARAM_NAME) someClass: SomeClass) = dataStructure.remove(someClass)

    @Operation
    fun count() = dataStructure.count()

    @Test
    fun modelCheckTest() = ModelCheckingOptions().check(this::class)
}

class SomeClassGenerator(
    private val randomProvider: RandomProvider,
    val configuration: String,
) : ParameterGenerator<SomeClass> {
    override fun generate(

    ): SomeClass {
        return SomeClass(randomProvider.createRandom().nextInt().toString())
    }
}