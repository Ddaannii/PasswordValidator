package com.kata.password.rules

import com.kata.password.PasswordValidator
import com.kata.password.model.Tolerance
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class FourthRuleTest {
    lateinit var sut: PasswordValidator


    @Before
    fun setup() {
        val rule = FourthRule()
        sut = PasswordValidator(rule, Tolerance(1))
    }

    @Test
    fun `password validator, with an empty input, should return false`() {

        val result = sut.validate(input = "")

        Assert.assertEquals(false, result.isValid)
    }


    @Test
    fun `password validator, with an input of less than 8 characters with lowerCapitalNumberUnder, should return true`() {

        val result = sut.validate(input = "Hola12_")

        Assert.assertEquals(true, result.isValid)
    }


    @Test
    fun `password validator, with an input of less than 8 characters, no Capital with lowerNumberUnder, should return false`() {

        val result = sut.validate(input = "hola12_")

        Assert.assertEquals(false, result.isValid)
    }


}