package com.aaleksiev.photosapi.photos

import com.aaleksiev.photosapi.photos.models.PhotoResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PhotosApi {
    @GET("/photos")
    fun getPhotos(): Single<List<PhotoResponse>>
}