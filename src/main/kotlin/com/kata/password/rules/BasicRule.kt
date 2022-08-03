package com.kata.password.rules

import com.kata.password.model.Length
import com.kata.password.pass.PassArgument.*

class BasicRule : Rule(arguments) {

    companion object Factory : RuleFactory() {
        private const val MINIMUM_LENGTH = 8

        val arguments = listOf(
            LengthArgument(Length(MINIMUM_LENGTH)),
            CapitalLetterArgument,
            LowerCaseLetterArgument,
            NumberArgument,
            UnderScore
        )

        override fun buildRule(): Rule = BasicRule()
    }


}