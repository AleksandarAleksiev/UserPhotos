package com.aaleksiev.photosapi.di

import android.content.Context
import com.aaleksiev.core.di.ApiEndpoint
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import photosapi.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(
        @ApiEndpoint apiEndpoint: String,
        @ApplicationContext context: Context
    ): Retrofit = OkHttpClient.Builder()
        .addInterceptor(providesLoggingInterceptor())
        .cache(providesCache(context))
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build().run {
            Retrofit.Builder()
                .baseUrl(apiEndpoint)
                .client(this)
                .addConverterFactory(MoshiConverterFactory.create(providesMoshi()))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }

    private fun providesCache(context: Context): Cache {
        val cacheFile = File(context.cacheDir, "httpCache")
        return Cache(cacheFile, MAX_CACHE_SIZE)
    }

    private fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    companion object {
        const val MAX_CACHE_SIZE = 10 * 1024 * 1024L // 10MB
        fun providesMoshi(): Moshi = Moshi.Builder()
            .build()
    }
}