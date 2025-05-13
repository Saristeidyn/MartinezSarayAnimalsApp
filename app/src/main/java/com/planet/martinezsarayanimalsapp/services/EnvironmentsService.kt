package com.planet.martinezsarayanimalsapp.services

import com.planet.martinezsarayanimalsapp.models.EnvironmentsItem
import retrofit2.http.GET
import retrofit2.http.Path

interface EnvironmentsService {
    @GET("environments")
    suspend fun getEnvironments(): List<EnvironmentsItem>

    @GET("environments/{id}")
    suspend fun getEnvironmentsById( @Path("id") _id:String) : EnvironmentsItem
}