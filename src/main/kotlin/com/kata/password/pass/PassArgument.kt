package com.kata.password.pass

import com.kata.password.model.Length
import com.kata.password.model.Password

sealed class PassArgument : Pass {
    data class LengthArgument(val minimumLength: Length) : PassArgument() {
        override fun check(password: Password): Boolean {
            return password.value.length >= minimumLength.value
        }
    }

    object CapitalLetterArgument : PassArgument() {
        override fun check(password: Password): Boolean {
            return password.value.toList().any { it.isUpperCase() }
        }
    }

    object LowerCaseLetterArgument : PassArgument() {
        override fun check(password: Password): Boolean {
            return password.value.toList().any { it.isLowerCase() }
        }
    }

    object NumberArgument : PassArgument() {
        override fun check(password: Password): Boolean {
            return password.value.toList().any { it.isDigit() }
        }
    }

    object UnderScore : PassArgument() {
        override fun check(password: Password): Boolean {
            return password.value.toList().any { it == '_' }
        }
    }
}