package com.aaleksiev.userphotos.photos.viewmodel

import androidx.lifecycle.Observer
import com.aaleksiev.core.models.UIState
import com.aaleksiev.userphotos.Dummy.userPhoto
import com.aaleksiev.userphotos.TestBase
import com.aaleksiev.userphotos.photos.models.UserPhoto
import com.aaleksiev.userphotos.photos.usecase.PhotosUseCase
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.inOrder

class PhotosViewModelTest : TestBase() {
    @Mock
    private lateinit var photosUseCase: PhotosUseCase

    @Mock
    private lateinit var uiStateObservable: Observer<UIState<List<UserPhoto>>>

    private lateinit var underTest: PhotosViewModel

    override fun setUp() {
        super.setUp()
        underTest = PhotosViewModel(
            photosUseCase = photosUseCase,
            schedulerProvider = schedulerProvider
        )
    }

    @Test
    fun `given user photos are loaded then will display them`() {
        given(photosUseCase.getUserPhotos()).willReturn(Single.just(listOf(userPhoto)))

        underTest.uiState.observeForever(uiStateObservable)
        testScheduler.triggerActions()

        with(inOrder(photosUseCase, uiStateObservable)) {
            verify(photosUseCase).getUserPhotos()
            verify(uiStateObservable).onChanged(UIState.Loading(isLoading = true))
            verify(uiStateObservable).onChanged(UIState.Loading(isLoading = false))
            verify(uiStateObservable).onChanged(UIState.Success(data = listOf(userPhoto)))
        }
    }

    @Test
    fun `given error when loading user photos then will display error UI`() {
        given(photosUseCase.getUserPhotos()).willReturn(Single.error(IllegalArgumentException("Error loading user photos")))

        underTest.uiState.observeForever(uiStateObservable)
        testScheduler.triggerActions()

        with(inOrder(photosUseCase, uiStateObservable)) {
            verify(photosUseCase).getUserPhotos()
            verify(uiStateObservable).onChanged(UIState.Loading(isLoading = true))
            verify(uiStateObservable).onChanged(UIState.Loading(isLoading = false))
            verify(uiStateObservable).onChanged(UIState.Error(errorMessage = "Error loading user photos"))
        }
    }
}