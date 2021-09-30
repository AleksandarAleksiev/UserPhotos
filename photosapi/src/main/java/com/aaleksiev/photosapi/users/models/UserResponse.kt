package com.aaleksiev.photosapi.users.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "username")
    val userName: String,
    @Json(name = "address")
    val address: Address,
    @Json(name = "phone")
    val phoneNumber: String,
    @Json(name = "website")
    val website: String,
    @Json(name = "company")
    val companyInfo: CompanyInfo,
)