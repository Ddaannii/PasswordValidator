package com.kata.password.rules

import com.kata.password.PasswordValidator
import com.kata.password.model.Password
import com.kata.password.rules.Rule.Type
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ThirdRuleTest {

    lateinit var sut: PasswordValidator

    @Before
    fun setup() {
        val rule = Rule.fromType(Type.Third)
        sut = PasswordValidator(rule)
    }

    @Test
    fun `password validator, with an empty input, should return false`() {

        val result = sut.validate(Password(""))

        Assert.assertEquals(false, result.isValid)
    }

    @Test
    fun `password validator, with an input of less than 15 characters, should return false`() {

        val result = sut.validate(Password("Hola12_asdfasd"))

        Assert.assertEquals(false, result.isValid)
    }

    @Test
    fun `password validator, with an input 16 characters, should return true`() {

        val result = sut.validate(Password(VALID_STRING))

        Assert.assertEquals(true, result.isValid)
    }

    @Test
    fun `password validator, with an input 17 characters, should return true`() {

        val result = sut.validate(Password("Hola12_asdfasdfas"))

        Assert.assertEquals(true, result.isValid)
    }

    @Test
    fun `password validator, with at with no capital letters, should return false`() {

        val result = sut.validate(Password("holaholahola"))

        Assert.assertEquals(false, result.isValid)
    }

    @Test
    fun `password validator, with at least one capital letter, should return true`() {

        val result = sut.validate(Password(VALID_STRING))

        Assert.assertEquals(true, result.isValid)
    }

    @Test
    fun `password validator, with at least one lowercase letter, should return true`() {

        val result = sut.validate(Password(VALID_STRING))

        Assert.assertEquals(true, result.isValid)
    }

    @Test
    fun `password validator, with a string with all capital letters, should return false`() {

        val result = sut.validate(Password("HOLAHOLAHOLA"))

        Assert.assertEquals(false, result.isValid)
    }

    @Test
    fun `password validator, with at least one number, should return true`() {

        val result = sut.validate(Password(VALID_STRING))

        Assert.assertEquals(true, result.isValid)
    }

    @Test
    fun `password validator, with a string with all letters, should return false`() {

        val result = sut.validate(Password(WRONG_STRING))

        Assert.assertEquals(false, result.isValid)
    }


    companion object {
        const val VALID_STRING = "Hola12_asdfasdfa"
        const val WRONG_STRING = "HOLAHOLAHOLA"
    }

}