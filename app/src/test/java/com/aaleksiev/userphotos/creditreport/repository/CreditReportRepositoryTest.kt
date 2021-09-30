package com.aaleksiev.userphotos.creditreport.repository

import com.aaleksiev.photosapi.photos.PhotosApi
import com.aaleksiev.photosapi.photos.models.CreditReportResponse
import com.aaleksiev.userphotos.TestBase
import com.aaleksiev.userphotos.runTest
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.verify

class CreditReportRepositoryTest : TestBase() {
    @Mock
    private lateinit var creditReportApi: PhotosApi

    @Mock
    private lateinit var creditReportResponse: CreditReportResponse

    private lateinit var underTest: CreditReportRepository

    override fun setUp() {
        super.setUp()
        underTest = CreditReportRepository(
            creditReportApi = creditReportApi,
            dispatcherProvider = schedulerProvider
        )
    }

    @Test
    fun `will load user credit report`() = runTest {
        given(creditReportApi.getCreditReport()).willReturn(creditReportResponse)

        val result = underTest.getUserCreditReport()

        assertEquals(creditReportResponse, result)
        verify(creditReportApi).getCreditReport()
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given error when loading user credit report then will throw error`() = runTest {
        given(creditReportApi.getCreditReport()).willThrow(IllegalArgumentException::class.java)

        underTest.getUserCreditReport()
        verify(creditReportApi).getCreditReport()
    }
}