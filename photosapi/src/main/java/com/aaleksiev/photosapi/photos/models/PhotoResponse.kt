package com.aaleksiev.photosapi.photos.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "albumId")
    val albumId: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "url")
    val imageUrl: String,
    @Json(name = "thumbnailUrl")
    val thumbnailUrl: String
)