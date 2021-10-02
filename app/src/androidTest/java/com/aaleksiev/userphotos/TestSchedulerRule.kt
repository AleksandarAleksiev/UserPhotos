package com.aaleksiev.userphotos

import android.os.AsyncTask
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.rules.ExternalResource

class TestSchedulerRule : ExternalResource() {

    private val asyncTaskScheduler = Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR)

    override fun before() {
        RxJavaPlugins.setIoSchedulerHandler { asyncTaskScheduler }
        RxJavaPlugins.setComputationSchedulerHandler { asyncTaskScheduler }
    }

    override fun after() {
        RxJavaPlugins.reset()
    }
}