package com.aaleksiev.userphotos.photos.usecase

import com.aaleksiev.userphotos.photos.models.UserPhoto
import io.reactivex.rxjava3.core.Single

interface PhotosUseCase {
    fun getUserPhotos(): Single<List<UserPhoto>>
}