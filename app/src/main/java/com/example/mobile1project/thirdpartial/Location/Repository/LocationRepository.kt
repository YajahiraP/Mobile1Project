package com.example.mobile1project.thirdpartial.Location.Repository


import com.example.mobile1project.thirdpartial.Location.Model.Location
import com.example.mobile1project.thirdpartial.Location.Network.LocationApiService

class LocationRepository(private val apiService: LocationApiService) {
    suspend fun fetchLocations(): List<Location> {
        return apiService.getLocations()
    }
}