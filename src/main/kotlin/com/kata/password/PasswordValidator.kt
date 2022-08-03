package com.kata.password

import com.kata.password.model.Password
import com.kata.password.model.Result
import com.kata.password.model.Tolerance
import com.kata.password.model.errors.PasswordError
import com.kata.password.pass.PassArgument
import com.kata.password.rules.BasicRule
import com.kata.password.rules.Rule

class PasswordValidator(
    private val rule: Rule = BasicRule.buildRule(),
    private val tolerance: Tolerance = Tolerance(DEFAULT_TOLERANCE)
) {

    fun validate(input: String): Result {
        val validation = rule.validate(Password(input))
        val isValid = validation.values.count { !it } <= tolerance.value
        val errors = validation.filter { !it.value }.keys.map { PasswordError.parsePass(it as PassArgument) }
        return Result(isValid, errors)
    }

    companion object {
        private const val DEFAULT_TOLERANCE = 0
    }
}
