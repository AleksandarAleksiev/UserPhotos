package com.aaleksiev.userphotos.photos.usecase.di

import com.aaleksiev.userphotos.photos.usecase.PhotosUseCase
import com.aaleksiev.userphotos.photos.usecase.PhotosUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun providesPhotosUseCase(photosUseCaseImpl: PhotosUseCaseImpl): PhotosUseCase = photosUseCaseImpl
}