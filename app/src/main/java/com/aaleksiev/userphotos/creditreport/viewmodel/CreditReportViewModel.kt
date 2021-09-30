package com.aaleksiev.userphotos.creditreport.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aaleksiev.photosapi.extensions.runCatchingWithLoading
import com.aaleksiev.core.coroutines.SchedulerProvider
import com.aaleksiev.core.models.UIState
import com.aaleksiev.userphotos.creditreport.models.UserCreditReport
import com.aaleksiev.userphotos.creditreport.usecase.CreditReportUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreditReportViewModel @Inject constructor(
    private val creditReportUseCase: CreditReportUseCase,
    private val coroutinesDispatcherProvider: SchedulerProvider
) : ViewModel() {

    val uiState = liveData<UIState<UserCreditReport>>(coroutinesDispatcherProvider.main()) {
        runCatchingWithLoading({
            creditReportUseCase.getUserCreditReport()
        }, {
            emit(UIState.Loading(isLoading = it))
        })
            .onSuccess { emit(UIState.Success(it)) }
            .onFailure { emit(UIState.Error(it.localizedMessage.orEmpty())) }
    }
}