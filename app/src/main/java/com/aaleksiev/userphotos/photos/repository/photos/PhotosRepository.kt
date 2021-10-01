package com.aaleksiev.userphotos.photos.repository.photos

import com.aaleksiev.photosapi.photos.PhotosApi
import javax.inject.Inject

class PhotosRepository @Inject constructor(
    private val photosApi: PhotosApi
) {
    fun getPhotos() = photosApi.getPhotos()
}