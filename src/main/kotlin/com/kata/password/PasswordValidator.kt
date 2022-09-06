package com.kata.password

import com.kata.password.model.Password
import com.kata.password.model.Result
import com.kata.password.model.Tolerance
import com.kata.password.rules.BasicRule
import com.kata.password.rules.Rule

class PasswordValidator(
    private val rule: Rule = BasicRule(),
    private val tolerance: Tolerance = Tolerance(DEFAULT_TOLERANCE)
) {

    fun validate(password: Password): Result {
        return rule.validate(password, tolerance)
    }

    companion object {
        private const val DEFAULT_TOLERANCE = 0
    }
}
