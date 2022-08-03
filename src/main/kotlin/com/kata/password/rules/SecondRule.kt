package com.kata.password.rules

import com.kata.password.model.Length
import com.kata.password.pass.PassArgument

class SecondRule : Rule(arguments) {

    companion object Factory : RuleFactory() {
        private const val MINIMUM_LENGTH = 6

        val arguments = listOf(
            PassArgument.LengthArgument(Length(MINIMUM_LENGTH)),
            PassArgument.CapitalLetterArgument,
            PassArgument.LowerCaseLetterArgument,
            PassArgument.NumberArgument,
        )

        override fun buildRule(): Rule = BasicRule()
    }
}
