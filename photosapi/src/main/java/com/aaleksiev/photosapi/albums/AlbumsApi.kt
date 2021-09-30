package com.aaleksiev.photosapi.albums

import com.aaleksiev.photosapi.albums.models.AlbumResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface AlbumsApi {
    @GET("/albums")
    fun getAlbums(): Single<List<AlbumResponse>>
}