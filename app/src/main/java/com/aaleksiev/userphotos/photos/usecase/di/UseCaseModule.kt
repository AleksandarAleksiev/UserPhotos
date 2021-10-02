package com.aaleksiev.userphotos.photos.usecase.di

import com.aaleksiev.userphotos.photos.usecase.PhotosUseCase
import com.aaleksiev.userphotos.photos.usecase.PhotosUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun providesPhotosUseCase(photosUseCaseImpl: PhotosUseCaseImpl): PhotosUseCase = photosUseCaseImpl
}