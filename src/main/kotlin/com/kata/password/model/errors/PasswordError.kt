package com.kata.password.model.errors

import com.kata.password.pass.PasswordRequirement
import com.kata.password.pass.PasswordRequirement.*

sealed class PasswordError {
    object MinimumLimitNotReached : PasswordError()
    object MissingCapitalLetter : PasswordError()
    object MissingLowerCaseLetter : PasswordError()
    object MissingNumber : PasswordError()
    object MissingUnderScore : PasswordError()

    companion object {
        fun parsePass(pass: PasswordRequirement): PasswordError {
            return when (pass) {
                CapitalLetterRequirement -> MissingCapitalLetter
                is LengthRequirement -> MinimumLimitNotReached
                LowerCaseLetterRequirement -> MissingLowerCaseLetter
                NumberRequirement -> MissingNumber
                UnderScore -> MissingUnderScore
            }
        }
    }
}