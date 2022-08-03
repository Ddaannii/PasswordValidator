package com.kata.password.rules

import com.kata.password.model.Password
import com.kata.password.pass.Requirements

open class Rule(private val requirements: Requirements) {

    fun validate(input: Password): Boolean = requirements.arguments.all { it.check(input) }

}