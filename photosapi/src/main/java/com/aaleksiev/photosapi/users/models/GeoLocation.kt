package com.aaleksiev.photosapi.users.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GeoLocation(
    @Json(name = "lat")
    val latitude: Double,
    @Json(name = "lng")
    val longitude: Double
)
