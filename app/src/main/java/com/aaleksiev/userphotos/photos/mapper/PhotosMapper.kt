package com.aaleksiev.userphotos.photos.mapper

import com.aaleksiev.photosapi.albums.models.AlbumResponse
import com.aaleksiev.photosapi.photos.models.PhotoResponse
import com.aaleksiev.photosapi.users.models.UserResponse
import com.aaleksiev.userphotos.photos.models.UserPhoto
import javax.inject.Inject

class PhotosMapper @Inject constructor() {
    fun map(albums: List<AlbumResponse>, users: List<UserResponse>, photos: List<PhotoResponse>) = listOf<UserPhoto>()
}