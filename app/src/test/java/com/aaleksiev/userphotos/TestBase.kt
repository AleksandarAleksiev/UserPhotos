package com.aaleksiev.userphotos

import androidx.annotation.CallSuper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aaleksiev.core.scheduler.SchedulerProvider
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Before
import org.junit.Rule
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations

abstract class TestBase {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    protected lateinit var schedulerProvider: SchedulerProvider

    protected val testScheduler = TestScheduler()

    @Before
    @CallSuper
    open fun setUp() {
        MockitoAnnotations.openMocks(this)
        given(schedulerProvider.io()).willReturn(testScheduler)
        given(schedulerProvider.computation()).willReturn(testScheduler)
        given(schedulerProvider.main()).willReturn(testScheduler)
    }
}