package com.aaleksiev.photosapi.di

import com.aaleksiev.photosapi.albums.AlbumsApi
import com.aaleksiev.photosapi.photos.PhotosApi
import com.aaleksiev.photosapi.users.UsersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class RestApiModule {
    @Provides
    fun providesPhotosApi(retrofit: Retrofit): PhotosApi =
        retrofit.create(PhotosApi::class.java)

    @Provides
    fun providesUsersApi(retrofit: Retrofit): UsersApi =
        retrofit.create(UsersApi::class.java)

    @Provides
    fun providesAlbumsApi(retrofit: Retrofit): AlbumsApi =
        retrofit.create(AlbumsApi::class.java)
}