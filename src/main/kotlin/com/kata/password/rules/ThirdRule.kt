package com.kata.password.rules

import com.kata.password.pass.PasswordContract

class ThirdRule : Rule(arguments) {

    companion object {
        private const val MINIMUM_LENGTH = 16

        private val arguments = PasswordContract.Builder()
            .setMinimumLimit(MINIMUM_LENGTH)
            .addCapitalLetterRequirement()
            .addLowerScoreLetterRequirement()
            .addUnderScoreRequirement()
            .build()

    }
}
