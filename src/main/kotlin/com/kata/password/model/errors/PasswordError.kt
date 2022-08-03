package com.kata.password.model.errors

import com.kata.password.pass.PassArgument
import com.kata.password.pass.PassArgument.*

sealed class PasswordError {
    object MinimumLimitNotReached : PasswordError()
    object MissingCapitalLetter : PasswordError()
    object MissingLowerCaseLetter : PasswordError()
    object MissingNumber : PasswordError()
    object MissingUnderScore : PasswordError()

    companion object {
        fun parsePass(pass: PassArgument): PasswordError {
            return when (pass) {
                CapitalLetterArgument -> MissingCapitalLetter
                is LengthArgument -> MinimumLimitNotReached
                LowerCaseLetterArgument -> MissingLowerCaseLetter
                NumberArgument -> MissingNumber
                UnderScore -> MissingUnderScore
            }
        }
    }
}