package com.kata.password.rules

import com.kata.password.pass.Requirements

class ThirdRule : Rule(arguments) {

    companion object Factory : RuleFactory() {
        private const val MINIMUM_LENGTH = 16

        private val arguments = Requirements.Builder()
            .setMinimumLimit(MINIMUM_LENGTH)
            .addCapitalLetterRequirement()
            .addLowerScoreLetterRequirement()
            .addUnderScoreRequirement()
            .build()

        override fun buildRule(): Rule = BasicRule()
    }
}
