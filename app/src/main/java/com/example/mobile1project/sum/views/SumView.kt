package com.example.mobile1project.sum.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobile1project.sum.ViewModels.SumViewModel

@Composable
fun SumView(viewModel: SumViewModel) {
    val num1 by viewModel.num1.collectAsState()
    val num2 by viewModel.num2.collectAsState()
    val result by viewModel.result.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = num1,
            onValueChange = { viewModel.setNum1(it) },
            label = { Text("Número 1") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = num2,
            onValueChange = { viewModel.setNum2(it) },
            label = { Text("Número 2") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.calculateSum() }) {
            Text("Sumar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Resultado: $result", style = MaterialTheme.typography.bodyLarge)
    }
}
