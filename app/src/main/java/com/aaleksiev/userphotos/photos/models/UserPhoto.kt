package com.aaleksiev.userphotos.photos.models

data class UserPhoto(
    val albumId: Int,
    val title: String,
    val albumName: String,
    val userName: String,
    val thumbnailUrl: String
)