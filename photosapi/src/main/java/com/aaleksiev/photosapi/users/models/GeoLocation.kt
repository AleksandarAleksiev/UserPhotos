package com.aaleksiev.photosapi.users.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GeoLocation(
    @Json(name = "lat")
    val latitude: String,
    @Json(name = "lng")
    val longitude: String
)
