package com.appvolution.calculatorwithcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    var operationPerformed = false
    var lastPressedOperation: CalculatorOperations? = null

    fun onAction(action: CalculatorEvents) {
        when (action) {
            is CalculatorEvents.Number -> {
                if (operationPerformed) {
                    operationPerformed = false
                }
                enterNumber(action.number)
            }

            is CalculatorEvents.Decimal -> enterDecimal()
            is CalculatorEvents.Clear -> state = CalculatorState()
            is CalculatorEvents.Operation -> {
                operationPerformed = true
                state.operatorPressed = true
                lastPressedOperation = action.calculatorOperations
                enterOperation(
                    action.calculatorOperations
                )
            }

            is CalculatorEvents.Calculate -> performCalculation()
            is CalculatorEvents.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {
        when {
            state.number1.isNotEmpty() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )

            state.number2.isNotEmpty() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )
        }

    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperations.Divide -> {
                    number1 / number2
                }

                is CalculatorOperations.Multiply -> number1 * number2
                is CalculatorOperations.Subtract -> number1 - number2
                is CalculatorOperations.Add -> number1 + number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(7),
                number2 = "",
                operation = null
            )
        }

    }

    private fun enterOperation(operations: CalculatorOperations) {
        if (state.number1.isNotEmpty()) {
            state = state.copy(operation = operations)
        }

    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".")
            && state.number1.isNotBlank()
        ) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".")
            && state.number2.isNotBlank()
        ) {
            state = state.copy(
                number2 = state.number2 + "."
            )
            return
        }

    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length > MAX_NUMBER_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length > MAX_NUMBER_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
        return
    }

    companion object {
        private const val MAX_NUMBER_LENGTH = 6
    }
}