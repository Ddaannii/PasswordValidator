package com.kata.password.rules

import com.kata.password.pass.Requirements

class FourthRule : Rule(arguments) {

    companion object Factory : RuleFactory() {
        private const val MINIMUM_LENGTH = 8

        private val arguments = Requirements.Builder()
            .setMinimumLimit(MINIMUM_LENGTH)
            .addCapitalLetterRequirement()
            .addNumberRequirement()
            .addUnderScoreRequirement()
            .build()

        override fun buildRule(): Rule = BasicRule()
    }
}
