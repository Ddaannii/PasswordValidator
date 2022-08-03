package com.kata.password.model

import com.kata.password.model.errors.PasswordError

data class Result(val isValid: Boolean, val errors: List<PasswordError>)

