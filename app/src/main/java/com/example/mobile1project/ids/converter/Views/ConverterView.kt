
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.R
import com.example.mobile1project.ids.converter.ViewModels.ConverterViewModel

@Composable
fun ConverterView(viewModel: ConverterViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Convertidor de °C - °F", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = viewModel.celsius.value,
            onValueChange = { viewModel.celsius.value = it },
            label = { Text("Temperatura (°C)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            isError = viewModel.celsiusError.value != null,
            supportingText = { viewModel.celsiusError.value?.let { Text(it, color = MaterialTheme.colorScheme.error) } }
        )


        Button(
            onClick = { viewModel.calculateConverter() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Convertir °C - °F")
        }


        viewModel.result.value?.let { result ->
            Text("°F: ${"%.2f".format(result.conversion)}")


        }


        Image(
            painter = painterResource(id = R.drawable.termometro),
            contentDescription = stringResource(R.string.login_image_desc),
            modifier = Modifier
                .size(150.dp)

        )


    }
}