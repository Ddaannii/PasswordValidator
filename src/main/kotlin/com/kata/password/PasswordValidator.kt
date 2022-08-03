package com.kata.password

class PasswordValidator {

    fun validate(input: String): Boolean {
        return hasMinimumLength(input) && hasAnUpperCase(input) && hasALowerCase(input) && hasANumber(input)
                && hasAnUnderscore(input)
    }

    private fun hasMinimumLength(input: String) = input.length >= MINIMUM_LENGTH

    private fun hasALowerCase(input: String) = input.toList().any { it.isLowerCase() }

    private fun hasAnUpperCase(input: String) = input.toList().any { it.isUpperCase() }

    private fun hasANumber(input: String) = input.toList().any { it.isDigit() }

    private fun hasAnUnderscore(input: String) = input.toList().any { it == '_' }

    companion object {
        private const val MINIMUM_LENGTH = 8
    }

}
