package com.planet.martinezsarayanimalsapp.models

import com.google.gson.annotations.SerializedName

data class EnvironmentsItem(
    @SerializedName("_id") val _id: String,
    val description: String,
    val image: String,
    val name: String
)