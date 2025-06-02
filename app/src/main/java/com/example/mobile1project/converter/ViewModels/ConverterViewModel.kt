package com.example.mobile1project.converter.ViewModels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.mobile1project.converter.Models.ConverterResult
import kotlinx.coroutines.launch

class ConverterViewModel : ViewModel() {
    var celsius = mutableStateOf("")
    var celsiusError = mutableStateOf<String?>(null)
    var result = mutableStateOf<ConverterResult?>(null)


    fun calculateConverter() {
        val celsiusValue = celsius.value.toDoubleOrNull()

        celsiusError.value = if (celsiusValue == null) "Ingrese un valor válido" else null

        if (celsiusValue != null ) {
            val conversion = (celsiusValue * (9 / 5)) + 32
            val classification = classifyConverter(conversion)

            viewModelScope.launch {
                result.value = ConverterResult(conversion, classification)
            }
        } else {
            result.value = null
        }
    }

    private fun classifyConverter(conversion: Double): String {
        return when {
            conversion < 10 -> ""
            conversion  in 18.0..23.0 -> ""
            else -> ""
        }
    }
}