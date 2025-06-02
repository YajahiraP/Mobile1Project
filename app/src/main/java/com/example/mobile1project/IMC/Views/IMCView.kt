import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun IMCScreen(viewModel: IMCViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Calculadora de IMC", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = viewModel.weight.value,
            onValueChange = { viewModel.weight.value = it },
            label = { Text("Peso (kg)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            isError = viewModel.weightError.value != null,
            supportingText = { viewModel.weightError.value?.let { Text(it, color = MaterialTheme.colorScheme.error) } }
        )

        OutlinedTextField(
            value = viewModel.height.value,
            onValueChange = { viewModel.height.value = it },
            label = { Text("Altura (cm)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            isError = viewModel.heightError.value != null,
            supportingText = { viewModel.heightError.value?.let { Text(it, color = MaterialTheme.colorScheme.error) } }
        )

        Button(
            onClick = { viewModel.calculateIMC() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular IMC")
        }

        viewModel.result.value?.let { result ->
            Text("IMC: ${"%.2f".format(result.imc)}")
            Text("Clasificación: ${result.classification}")
        }
    }
}
