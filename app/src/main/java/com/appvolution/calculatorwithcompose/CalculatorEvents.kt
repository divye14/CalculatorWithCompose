package com.appvolution.calculatorwithcompose

sealed class CalculatorEvents {
    data class Number(val number: Int) : CalculatorEvents()
    data class Operation(val calculatorOperations: CalculatorOperations) : CalculatorEvents()
    object Clear : CalculatorEvents()
    object Delete : CalculatorEvents()
    object Decimal : CalculatorEvents()
    object Calculate : CalculatorEvents()
}
