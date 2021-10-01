package com.aaleksiev.userphotos.photos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aaleksiev.core.coroutines.SchedulerProvider
import com.aaleksiev.core.models.UIState
import com.aaleksiev.userphotos.photos.models.UserPhoto
import com.aaleksiev.userphotos.photos.usecase.PhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val photosUseCase: PhotosUseCase,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    val uiState: LiveData<UIState<List<UserPhoto>>> = MutableLiveData()
}