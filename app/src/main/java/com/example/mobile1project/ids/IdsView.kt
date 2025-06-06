package com.example.mobile1project.ids

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IdsView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { navController.navigate("ConverterRoute") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a Converter")
        }

        Button(
            onClick = { navController.navigate("IMCRoute") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a IMC")
        }
        Button(
            onClick = { navController.navigate("LoginRoute") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a Login")
        }
        Button(
            onClick = { navController.navigate("SumRoute") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a Sum")
        }
        Button(
            onClick = { navController.navigate("ListRoute") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a List")
        }
        Button(
            onClick = { navController.navigate("LocationRoute") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a Location")
        }
        Button(
            onClick = { navController.navigate("ExamenRoute") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Mostrar Estudiantes")
        }

    }
}
