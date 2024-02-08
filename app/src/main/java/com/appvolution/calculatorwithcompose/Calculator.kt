package com.appvolution.calculatorwithcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appvolution.calculatorwithcompose.ui.theme.LightGray
import com.appvolution.calculatorwithcompose.ui.theme.MediumGray
import com.appvolution.calculatorwithcompose.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel,
    onAction: (CalculatorEvents) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(color = MediumGray),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Text(
                text = state.number1 +  (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                maxLines = 2
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    "AC",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorEvents.Clear)
                    })

                CalculatorButton(
                    "Del",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Delete)
                    })

                CalculatorButton(
                    "/",
                    modifier = Modifier
                        .background(if (viewModel.lastPressedOperation == CalculatorOperations.Divide) Color.DarkGray else Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Operation(CalculatorOperations.Divide))
                    })

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    "7",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Number(7))
                    })

                CalculatorButton(
                    "8",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Number(8))
                    })

                CalculatorButton(
                    "9",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Number(9))
                    })

                CalculatorButton(
                    "*",
                    modifier = Modifier
                        .background(if (viewModel.lastPressedOperation == CalculatorOperations.Multiply) Color.DarkGray else Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Operation(CalculatorOperations.Multiply))
                    })

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    "4",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Number(4))
                    })

                CalculatorButton(
                    "5",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Number(5))
                    })

                CalculatorButton(
                    "6",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Number(6))
                    })

                CalculatorButton(
                    "-",
                    modifier = Modifier
                        .background(if (viewModel.lastPressedOperation == CalculatorOperations.Subtract) Color.DarkGray else Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Operation(CalculatorOperations.Subtract))
                    })

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    "1",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Number(1))
                    })

                CalculatorButton(
                    "2",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Number(2))
                    })

                CalculatorButton(
                    "3",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Number(3))
                    })

                CalculatorButton(
                    "+",
                    modifier = Modifier
                        .background(if (viewModel.lastPressedOperation == CalculatorOperations.Add)Color.DarkGray else Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Operation(CalculatorOperations.Add))
                    })

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    "0",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorEvents.Number(0))
                    })

                CalculatorButton(
                    ".",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Decimal)
                    })

                CalculatorButton(
                    "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorEvents.Calculate)
                    })

            }
        }
    }
}