package com.aaleksiev.core.di

import com.aaleksiev.core.coroutines.SchedulerProvider
import com.aaleksiev.core.coroutines.SchedulerProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class CoroutinesDispatcherModule {
    @Binds
    internal abstract fun bindCoroutinesDispatcher(coroutineDispatcher: SchedulerProviderImpl): SchedulerProvider
}