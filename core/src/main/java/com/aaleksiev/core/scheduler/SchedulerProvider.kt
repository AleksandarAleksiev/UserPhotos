package com.aaleksiev.core.scheduler

import io.reactivex.rxjava3.core.Scheduler

interface SchedulerProvider {
    fun main(): Scheduler
    fun io(): Scheduler
    fun computation(): Scheduler
}