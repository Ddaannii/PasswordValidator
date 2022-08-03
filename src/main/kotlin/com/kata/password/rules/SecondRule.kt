package com.kata.password.rules

import com.kata.password.pass.Requirements

class SecondRule : Rule(arguments) {

    companion object Factory : RuleFactory() {
        private const val MINIMUM_LENGTH = 6

        private val arguments = Requirements.Builder()
            .setMinimumLimit(MINIMUM_LENGTH)
            .addCapitalLetterRequirement()
            .addLowerScoreLetterRequirement()
            .addNumberRequirement()
            .build()

        override fun buildRule(): Rule = BasicRule()
    }
}
