package com.aaleksiev.userphotos

import com.aaleksiev.userphotos.photos.usecase.PhotosUseCase
import com.aaleksiev.userphotos.photos.usecase.di.UseCaseModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import org.mockito.Mockito.mock
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [UseCaseModule::class]
)
class TestUseCaseModule {

    @Provides
    @Singleton
    fun providePhotosUseCase(): PhotosUseCase {
        return mock(PhotosUseCase::class.java)
    }
}