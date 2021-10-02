package com.aaleksiev.userphotos.photos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aaleksiev.core.models.UIState
import com.aaleksiev.core.scheduler.SchedulerProvider
import com.aaleksiev.userphotos.photos.models.UserPhoto
import com.aaleksiev.userphotos.photos.usecase.PhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val photosUseCase: PhotosUseCase,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    private val uiStateLiveData = MutableLiveData<UIState<List<UserPhoto>>>()
    val uiState: LiveData<UIState<List<UserPhoto>>> by lazy {
        loadUserPhotos()
        uiStateLiveData
    }

    private fun loadUserPhotos() = photosUseCase.getUserPhotos()
        .subscribeOn(schedulerProvider.computation())
        .observeOn(schedulerProvider.main())
        .doOnSubscribe { updateUIState(UIState.Loading(true)) }
        .doOnEvent { _, _ -> updateUIState(UIState.Loading(false)) }
        .subscribe(
            { updateUIState(UIState.Success(it)) },
            { updateUIState(UIState.Error(it.localizedMessage.orEmpty())) }
        )

    private fun updateUIState(uiState: UIState<List<UserPhoto>>) {
        uiStateLiveData.value = uiState
    }
}