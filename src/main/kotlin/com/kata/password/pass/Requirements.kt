package com.kata.password.pass

import com.kata.password.model.Length

class Requirements private constructor(val arguments: List<Pass>) {

    data class Builder(private var arguments: MutableSet<Pass> = mutableSetOf()) {

        fun setMinimumLimit(limit: Int) = apply { arguments.add(PassArgument.LengthArgument(Length(limit))) }

        fun addCapitalLetterRequirement() = apply { arguments.add(PassArgument.CapitalLetterArgument) }

        fun addLowerScoreLetterRequirement() = apply { arguments.add(PassArgument.LowerCaseLetterArgument) }

        fun addNumberRequirement() = apply { arguments.add(PassArgument.NumberArgument) }
        
        fun addUnderScoreRequirement() = apply { arguments.add(PassArgument.UnderScore) }

        fun build() = Requirements(this.arguments.toList())
    }
}