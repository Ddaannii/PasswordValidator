package com.kata.password

import com.kata.password.model.Password
import com.kata.password.model.Result
import com.kata.password.model.errors.PasswordError
import com.kata.password.pass.PassArgument
import com.kata.password.rules.BasicRule
import com.kata.password.rules.Rule

class PasswordValidator(private val rule: Rule = BasicRule.buildRule()) {

    fun validate(input: String): Result {
        val validation = rule.validate(Password(input))
        val isValid = validation.values.all { it }
        val errors = validation.filter { !it.value }.keys.map { PasswordError.parsePass(it as PassArgument) }
        return Result(isValid, errors)
    }

}
