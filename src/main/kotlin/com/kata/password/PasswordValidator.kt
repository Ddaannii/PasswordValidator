package com.kata.password

import com.kata.password.model.Password
import com.kata.password.rules.BasicRule
import com.kata.password.rules.Rule

class PasswordValidator(private val rule: Rule = BasicRule.buildRule()) {

    fun validate(input: String): Boolean {
        return rule.validate(Password(input))
    }

}
