package com.aaleksiev.userphotos.creditreport.repository

import com.aaleksiev.photosapi.photos.PhotosApi
import com.aaleksiev.core.coroutines.SchedulerProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CreditReportRepository @Inject constructor(
    private val creditReportApi: PhotosApi,
    private val dispatcherProvider: SchedulerProvider
) {
    suspend fun getUserCreditReport() = withContext(dispatcherProvider.io()) {
        creditReportApi.getCreditReport()
    }
}