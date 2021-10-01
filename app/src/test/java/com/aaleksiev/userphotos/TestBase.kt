package com.aaleksiev.userphotos

import androidx.annotation.CallSuper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aaleksiev.core.scheduler.SchedulerProvider
import io.reactivex.rxjava3.schedulers.Schedulers
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

    @Before
    @CallSuper
    open fun setUp() {
        MockitoAnnotations.openMocks(this)
        given(schedulerProvider.io()).willReturn(Schedulers.trampoline())
        given(schedulerProvider.computation()).willReturn(Schedulers.trampoline())
        given(schedulerProvider.main()).willReturn(Schedulers.trampoline())
    }
}