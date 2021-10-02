package com.aaleksiev.userphotos

import com.aaleksiev.userphotos.photos.models.UserPhoto

object Fake {
    const val ALBUM_ID = 1
    const val ALBUM_NAME = "Album"
    const val USER_NAME = "Leanne Graham"
    const val PHOTO_TITLE = "Photo"
    const val PHOTO_THUMBNAIL = "thumbnail"
    const val ERROR_MESSAGE = "Error message"

    val dummyError = IllegalArgumentException(ERROR_MESSAGE)

    val userPhotos = listOf(
        UserPhoto(
            albumId = ALBUM_ID,
            title = PHOTO_TITLE,
            albumName = ALBUM_NAME,
            userName = USER_NAME,
            thumbnailUrl = PHOTO_THUMBNAIL
        )
    )
}