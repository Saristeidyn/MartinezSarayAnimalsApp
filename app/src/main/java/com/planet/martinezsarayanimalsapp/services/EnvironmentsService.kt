package com.planet.martinezsarayanimalsapp.services

import com.planet.martinezsarayanimalsapp.models.EnvironmentsItem
import retrofit2.http.GET

interface EnvironmentsService {
    @GET("environments")
    suspend fun getEnvironments(): List<EnvironmentsItem>
}