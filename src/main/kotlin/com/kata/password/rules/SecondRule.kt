package com.kata.password.rules

import com.kata.password.pass.PasswordContract

class SecondRule : Rule(arguments) {

    companion object {
        private const val MINIMUM_LENGTH = 6

        private val arguments = PasswordContract.Builder()
            .setMinimumLimit(MINIMUM_LENGTH)
            .addCapitalLetterRequirement()
            .addLowerScoreLetterRequirement()
            .addNumberRequirement()
            .build()
    }
}
