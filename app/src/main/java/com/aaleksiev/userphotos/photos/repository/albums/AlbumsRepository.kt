package com.aaleksiev.userphotos.photos.repository.albums

import com.aaleksiev.photosapi.albums.AlbumsApi
import javax.inject.Inject

class AlbumsRepository @Inject constructor(
    private val albumsApi: AlbumsApi
) {
    fun getAlbums() = albumsApi.getAlbums()
}