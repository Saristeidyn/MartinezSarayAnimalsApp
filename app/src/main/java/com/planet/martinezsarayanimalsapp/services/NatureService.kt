package com.planet.martinezsarayanimalsapp.services

import com.planet.martinezsarayanimalsapp.models.EnvironmentsItem
import com.planet.martinezsarayanimalsapp.models.NatureItem
import retrofit2.http.GET
import retrofit2.http.Path

interface NatureService {
    @GET("animals")
    suspend fun getNature(): List<NatureItem>

    @GET("animals/{id}")
    suspend fun getAnimalById( @Path("id") id:String) : NatureItem
}

