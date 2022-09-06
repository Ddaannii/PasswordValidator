package com.kata.password.pass

import com.kata.password.model.Password

interface Requirement {
    fun validate(password: Password): Boolean
}