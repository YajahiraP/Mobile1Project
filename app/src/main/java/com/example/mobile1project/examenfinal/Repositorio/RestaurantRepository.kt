package com.example.mobile1project.examenfinal.Repositorio

import com.example.mobile1project.examenfinal.Model.Restaurant
import com.example.mobile1project.examenfinal.Model.RetrofitClient

class RestaurantRepository {
    private val service = RetrofitClient.service

    suspend fun fetchRestaurants(): List<Restaurant> {
        return service.getRestaurants()
    }
}