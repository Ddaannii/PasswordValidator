package com.kata.password.pass

import com.kata.password.model.Password

interface Pass {
    fun check(password: Password): Boolean
}