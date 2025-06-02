package com.example.mobile1project.sum.ViewModels


import androidx.lifecycle.ViewModel


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SumViewModel : ViewModel() {
    private val _num1 = MutableStateFlow("")
    val num1 = _num1.asStateFlow()

    private val _num2 = MutableStateFlow("")
    val num2 = _num2.asStateFlow()

    private val _result = MutableStateFlow("")
    val result = _result.asStateFlow()

    fun setNum1(value: String) {
        _num1.value = value
    }

    fun setNum2(value: String) {
        _num2.value = value
    }

    fun calculateSum() {
        val sum = (num1.value.toIntOrNull() ?: 0) + (num2.value.toIntOrNull() ?: 0)
        _result.value = sum.toString()
    }
}


