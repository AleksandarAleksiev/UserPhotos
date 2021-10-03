package com.aaleksiev.userphotos.photos

import com.aaleksiev.userphotos.photos.usecase.PhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mockito.Mockito.mock
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TestUseCaseModule {

    @Provides
    @Singleton
    fun providePhotosUseCase(): PhotosUseCase {
        return mock(PhotosUseCase::class.java)
    }
}