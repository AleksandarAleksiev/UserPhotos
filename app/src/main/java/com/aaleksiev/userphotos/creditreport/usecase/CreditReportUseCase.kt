package com.aaleksiev.userphotos.creditreport.usecase

import com.aaleksiev.core.coroutines.SchedulerProvider
import com.aaleksiev.userphotos.creditreport.mapper.CreditReportMapper
import com.aaleksiev.userphotos.creditreport.models.UserCreditReport
import com.aaleksiev.userphotos.creditreport.repository.CreditReportRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CreditReportUseCase @Inject constructor(
    private val creditReportRepository: CreditReportRepository,
    private val creditReportMapper: CreditReportMapper,
    private val schedulerProvider: SchedulerProvider
) {
    suspend fun getUserCreditReport(): UserCreditReport =
        withContext(schedulerProvider.io()) {
            creditReportRepository.getUserCreditReport().run {
                creditReportMapper.map(this)
            }
        }
}