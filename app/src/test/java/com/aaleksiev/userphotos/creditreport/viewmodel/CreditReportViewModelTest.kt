package com.aaleksiev.userphotos.creditreport.viewmodel

import androidx.lifecycle.Observer
import com.aaleksiev.core.models.UIState
import com.aaleksiev.userphotos.Dummy.expectedUserCreditReport
import com.aaleksiev.userphotos.TestBase
import com.aaleksiev.userphotos.creditreport.models.UserCreditReport
import com.aaleksiev.userphotos.creditreport.usecase.CreditReportUseCase
import com.aaleksiev.userphotos.runTest
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.inOrder

class CreditReportViewModelTest : TestBase() {

    @Mock
    private lateinit var creditReportUseCase: CreditReportUseCase

    @Mock
    private lateinit var uiStateObservable: Observer<UIState<UserCreditReport>>

    private lateinit var underTest: CreditReportViewModel

    override fun setUp() {
        super.setUp()
        underTest = CreditReportViewModel(
            creditReportUseCase = creditReportUseCase,
            coroutinesDispatcherProvider = schedulerProvider
        )
    }

    @Test
    fun `given user report is loaded then will display it`() = runTest {
        given(creditReportUseCase.getUserCreditReport()).willReturn(expectedUserCreditReport)

        underTest.uiState.observeForever(uiStateObservable)

        with(inOrder(creditReportUseCase, uiStateObservable)) {
            verify(uiStateObservable).onChanged(UIState.Loading(isLoading = true))
            verify(creditReportUseCase).getUserCreditReport()
            verify(uiStateObservable).onChanged(UIState.Loading(isLoading = false))
            verify(uiStateObservable).onChanged(UIState.Success(data = expectedUserCreditReport))
        }
    }

    @Test
    fun `given error when loading user report then will display error UI`() = runTest {
        given(creditReportUseCase.getUserCreditReport()).willThrow(IllegalArgumentException("Error loading credit report"))

        underTest.uiState.observeForever(uiStateObservable)

        with(inOrder(creditReportUseCase, uiStateObservable)) {
            verify(uiStateObservable).onChanged(UIState.Loading(isLoading = true))
            verify(creditReportUseCase).getUserCreditReport()
            verify(uiStateObservable).onChanged(UIState.Loading(isLoading = false))
            verify(uiStateObservable).onChanged(UIState.Error(errorMessage = "Error loading credit report"))
        }
    }
}