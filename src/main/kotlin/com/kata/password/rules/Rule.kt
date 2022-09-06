package com.kata.password.rules

import com.kata.password.model.Password
import com.kata.password.model.Result
import com.kata.password.model.Tolerance
import com.kata.password.model.Validation
import com.kata.password.model.errors.PasswordError
import com.kata.password.pass.PasswordContract
import com.kata.password.pass.PasswordRequirement

sealed class Rule(private val contract: PasswordContract) {

    sealed class Type {
        object Basic : Type()
        object Second : Type()
        object Third : Type()
        object Fourth : Type()
    }

    fun validate(input: Password, tolerance: Tolerance): Result {
        val validation = Validation(contract.requirements.associateWith { it.validate(input) })
        val isValid = isValid(validation, tolerance)
        val errors = parseErrors(validation)
        return Result(isValid, errors)
    }

    private fun isValid(validation: Validation, tolerance: Tolerance): Boolean {
        return validation.data.values.count { !it } <= tolerance.value
    }

    private fun parseErrors(validation: Validation): List<PasswordError> {
        return validation.data
            .filter { !it.value }
            .keys
            .map { PasswordError.parsePass(it as PasswordRequirement) }
    }

    companion object {
        fun fromType(type: Type): Rule {
            return when (type) {
                Type.Basic -> BasicRule()
                Type.Fourth -> FourthRule()
                Type.Second -> SecondRule()
                Type.Third -> ThirdRule()
            }
        }
    }
}