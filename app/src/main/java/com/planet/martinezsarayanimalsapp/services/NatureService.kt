package com.planet.martinezsarayanimalsapp.services

import com.planet.martinezsarayanimalsapp.models.NatureItem
import retrofit2.http.GET

interface NatureService {
    @GET("animals")
    suspend fun getNature(): List<NatureItem>
}

