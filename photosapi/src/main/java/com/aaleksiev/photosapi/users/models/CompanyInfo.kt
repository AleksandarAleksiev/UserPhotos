package com.aaleksiev.photosapi.users.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CompanyInfo(
    @Json(name = "name")
    val name: String,
    @Json(name = "catchPhrase")
    val catchPhrase: String,
    @Json(name = "bs")
    val bs: String
)
