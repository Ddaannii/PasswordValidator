package com.kata.password.rules

import com.kata.password.PasswordValidator
import com.kata.password.model.Password
import com.kata.password.model.Tolerance
import com.kata.password.rules.Rule.Type
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class FourthRuleTest {

    lateinit var sut: PasswordValidator

    @Before
    fun setup() {
        val rule = Rule.fromType(Type.Fourth)
        sut = PasswordValidator(rule, Tolerance(1))
    }

    @Test
    fun `password validator, with an empty input, should return false`() {

        val result = sut.validate(Password(""))

        Assert.assertEquals(false, result.isValid)
    }

    @Test
    fun `password validator, with an input of less than 8 characters with lowerCapitalNumberUnder, should return true`() {

        val result = sut.validate(Password("Hola12_"))

        Assert.assertEquals(true, result.isValid)
    }

    @Test
    fun `password validator, with an input of less than 8 characters, no Capital with lowerNumberUnder, should return false`() {

        val result = sut.validate(Password("hola12_"))

        Assert.assertEquals(false, result.isValid)
    }

}