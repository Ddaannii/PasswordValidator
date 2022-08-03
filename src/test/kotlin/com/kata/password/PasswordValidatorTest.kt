package com.kata.password

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PasswordValidatorTest {
    lateinit var sut: PasswordValidator

    @Before
    fun setup() {
        sut = PasswordValidator()
    }

    @Test
    fun `password validator, with an empty input, should return false`() {

        val result = sut.validate(input = "")

        Assert.assertEquals(false, result)
    }


    @Test
    fun `password validator, with an input of less than 8 characters, should return false`() {

        val result = sut.validate(input = "hola")

        Assert.assertEquals(false, result)
    }
    

    @Test
    fun `password validator, with an input of more than 8 characters, should return true`() {

        val result = sut.validate(input = VALID_STRING)

        Assert.assertEquals(true, result)
    }

    @Test
    fun `password validator, with at with no capital letters, should return false`() {

        val result = sut.validate(input = "holaholahola")

        Assert.assertEquals(false, result)
    }

    @Test
    fun `password validator, with at least one capital letter, should return true`() {

        val result = sut.validate(input = VALID_STRING)

        Assert.assertEquals(true, result)
    }

    @Test
    fun `password validator, with at least one lowercase letter, should return true`() {

        val result = sut.validate(input = VALID_STRING)

        Assert.assertEquals(true, result)
    }

    @Test
    fun `password validator, with a string with all capital letters, should return false`() {

        val result = sut.validate(input = "HOLAHOLAHOLA")

        Assert.assertEquals(false, result)
    }

    @Test
    fun `password validator, with at least one number, should return true`() {

        val result = sut.validate(input = VALID_STRING)

        Assert.assertEquals(true, result)
    }

    @Test
    fun `password validator, with a string with all letters, should return false`() {

        val result = sut.validate(input = WRONG_STRING)

        Assert.assertEquals(false, result)
    }

    @Test
    fun `password validator, with at least one underscore, should return true`() {

        val result = sut.validate(input = VALID_STRING)

        Assert.assertEquals(true, result)
    }

    @Test
    fun `password validator, with a string with no underscores, should return false`() {

        val result = sut.validate(input = WRONG_STRING)

        Assert.assertEquals(false, result)
    }

    companion object {
        const val VALID_STRING = "HOLAhola1234Hola_"
        const val WRONG_STRING = "HOLAHOLAHOLA"
    }

}