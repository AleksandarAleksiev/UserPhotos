package com.aaleksiev.userphotos

import com.aaleksiev.photosapi.photos.PhotosApi
import com.aaleksiev.photosapi.di.ClearScoreApiModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import org.mockito.Mockito.mock
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ClearScoreApiModule::class]
)
class TestApiModule {

    @Singleton
    @Provides
    fun provideCreditReportApi(): PhotosApi {
        return mock(PhotosApi::class.java)
    }
}