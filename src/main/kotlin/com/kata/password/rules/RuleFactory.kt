package com.kata.password.rules

abstract class RuleFactory {
    abstract fun buildRule(): Rule
}