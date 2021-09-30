package com.aaleksiev.photosapi.users.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Address(
    @Json(name = "street")
    val street: String,
    @Json(name = "suite")
    val suite: String,
    @Json(name = "city")
    val city: String,
    @Json(name = "zipcode")
    val postCode: String,
    @Json(name = "geo")
    val geoLocation: GeoLocation,
)