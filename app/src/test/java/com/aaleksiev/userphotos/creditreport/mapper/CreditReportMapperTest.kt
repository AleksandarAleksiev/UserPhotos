package com.aaleksiev.userphotos.creditreport.mapper

import com.aaleksiev.userphotos.Dummy.creditReportResponse
import com.aaleksiev.userphotos.Dummy.expectedUserCreditReport
import org.junit.Assert.assertEquals
import org.junit.Test

class CreditReportMapperTest {
    private val underTest = CreditReportMapper()

    @Test
    fun `will map user credit report data from credit report response`() {
        val actual = underTest.map(creditReportResponse)

        assertEquals(expectedUserCreditReport, actual)
    }
}