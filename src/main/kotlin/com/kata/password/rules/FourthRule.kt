package com.kata.password.rules

import com.kata.password.pass.PasswordContract

class FourthRule : Rule(arguments) {

    companion object {
        private const val MINIMUM_LENGTH = 8

        private val arguments = PasswordContract.Builder()
            .setMinimumLimit(MINIMUM_LENGTH)
            .addCapitalLetterRequirement()
            .addNumberRequirement()
            .addUnderScoreRequirement()
            .build()
    }
}
