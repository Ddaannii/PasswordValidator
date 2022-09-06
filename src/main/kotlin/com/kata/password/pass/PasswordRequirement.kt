package com.kata.password.pass

import com.kata.password.model.Length
import com.kata.password.model.Password

sealed class PasswordRequirement : Requirement {
    data class LengthRequirement(val minimumLength: Length) : PasswordRequirement() {
        override fun validate(password: Password): Boolean {
            return password.value.length >= minimumLength.value
        }
    }

    object CapitalLetterRequirement : PasswordRequirement() {
        override fun validate(password: Password): Boolean {
            return password.value.toList().any { it.isUpperCase() }
        }
    }

    object LowerCaseLetterRequirement : PasswordRequirement() {
        override fun validate(password: Password): Boolean {
            return password.value.toList().any { it.isLowerCase() }
        }
    }

    object NumberRequirement : PasswordRequirement() {
        override fun validate(password: Password): Boolean {
            return password.value.toList().any { it.isDigit() }
        }
    }

    object UnderScore : PasswordRequirement() {
        override fun validate(password: Password): Boolean {
            return password.value.toList().any { it == '_' }
        }
    }
}