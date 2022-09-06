package com.kata.password.model

import com.kata.password.pass.Requirement

data class Validation(val data: Map<Requirement, Boolean>)
