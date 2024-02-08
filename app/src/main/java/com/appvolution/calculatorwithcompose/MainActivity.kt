package com.appvolution.calculatorwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.appvolution.calculatorwithcompose.ui.theme.CalculatorWithComposeTheme
import com.appvolution.calculatorwithcompose.ui.theme.MediumGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorWithComposeTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                Calculator(
                    state = state,
                    buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MediumGray)
                        .padding(15.dp),
                    viewModel,
                    viewModel::onAction
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HelloContentPreview() {
    CalculatorWithComposeTheme {
    }
}