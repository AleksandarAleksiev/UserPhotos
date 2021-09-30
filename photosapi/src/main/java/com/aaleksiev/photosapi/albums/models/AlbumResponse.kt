package com.aaleksiev.photosapi.albums.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "userId")
    val userId: Int,
    @Json(name = "title")
    val title: String,
)
