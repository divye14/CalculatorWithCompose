package com.appvolution.calculatorwithcompose

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    var operatorPressed: Boolean = false,
    val operation: CalculatorOperations? = null
)


