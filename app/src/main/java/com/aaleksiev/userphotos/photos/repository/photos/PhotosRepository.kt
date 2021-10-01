package com.aaleksiev.userphotos.photos.repository.photos

import com.aaleksiev.photosapi.photos.PhotosApi
import com.aaleksiev.core.coroutines.SchedulerProvider
import com.aaleksiev.photosapi.albums.AlbumsApi
import com.aaleksiev.photosapi.users.UsersApi
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhotosRepository @Inject constructor(
    private val photosApi: PhotosApi
) {
    fun getPhotos() = photosApi.getPhotos()
}