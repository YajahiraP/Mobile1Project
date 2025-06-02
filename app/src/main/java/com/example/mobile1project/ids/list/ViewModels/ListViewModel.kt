package com.example.mobile1project.ids.list.ViewModels

import androidx.lifecycle.ViewModel
import com.example.mobile1project.ids.list.Models.Student
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListViewModel : ViewModel() {
    private val _students = MutableStateFlow(
        listOf(
            Student("Jorge Parra Hidalgo"),
            Student("Jose Ricardo Holguín Chiquito"),
            Student("Yajahira Payán Palma"),
            Student("Ian Alejandro Corral Marín"),
            Student("Jesús Omar Acuña Martínez"),
            Student("Luis Angel Hernandez"),
            Student("Sara Escamilla"),
            Student("Alejandro Carrasco Maldonado"),
            Student("Miguel Ruiz"),
            Student("Felix Neder"),
            Student("Manuel Saenz")

        )
    )
    val students: StateFlow<List<Student>> = _students
}