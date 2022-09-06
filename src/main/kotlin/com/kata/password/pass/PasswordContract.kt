package com.kata.password.pass

import com.kata.password.model.Length
import com.kata.password.pass.PasswordRequirement.*

class PasswordContract private constructor(val requirements: List<Requirement>) {

    data class Builder(private var requirements: MutableSet<Requirement> = mutableSetOf()) {

        fun setMinimumLimit(limit: Int) = apply { requirements.add(LengthRequirement(Length(limit))) }

        fun addCapitalLetterRequirement() = apply { requirements.add(CapitalLetterRequirement) }

        fun addLowerScoreLetterRequirement() = apply { requirements.add(LowerCaseLetterRequirement) }

        fun addNumberRequirement() = apply { requirements.add(NumberRequirement) }

        fun addUnderScoreRequirement() = apply { requirements.add(UnderScore) }

        fun build() = PasswordContract(this.requirements.toList())
    }
}