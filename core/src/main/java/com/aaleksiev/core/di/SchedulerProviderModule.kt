package com.aaleksiev.core.di

import com.aaleksiev.core.scheduler.SchedulerProvider
import com.aaleksiev.core.scheduler.SchedulerProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class SchedulerProviderModule {
    @Binds
    internal abstract fun bindsSchedulerProvider(schedulerProvider: SchedulerProviderImpl): SchedulerProvider
}