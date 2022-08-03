package com.kata.password.rules

import com.kata.password.model.Password
import com.kata.password.pass.Pass

open class Rule(private val passes: List<Pass>) {

    fun validate(input: Password): Boolean = passes.all { it.check(input) }

}