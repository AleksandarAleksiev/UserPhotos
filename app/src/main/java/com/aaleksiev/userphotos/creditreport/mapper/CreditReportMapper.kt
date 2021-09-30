package com.aaleksiev.userphotos.creditreport.mapper

import com.aaleksiev.photosapi.photos.models.CreditReportResponse
import com.aaleksiev.userphotos.creditreport.models.UserCreditReport
import javax.inject.Inject

class CreditReportMapper @Inject constructor() {
    fun map(creditReportResponse: CreditReportResponse) = UserCreditReport(
        creditScore = creditReportResponse.creditReportInfo.score,
        maxCreditScore = creditReportResponse.creditReportInfo.maxScoreValue
    )
}