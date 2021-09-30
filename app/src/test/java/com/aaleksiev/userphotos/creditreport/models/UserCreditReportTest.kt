package com.aaleksiev.userphotos.creditreport.models

import junit.framework.TestCase.assertEquals
import org.junit.Test

class UserCreditReportTest {

    @Test
    fun `given credit score will calculate the percent out of max credit score`() {
        val underTest = UserCreditReport(creditScore = 350, maxCreditScore = 700)

        val percent = underTest.percentOfTotal()

        assertEquals(50, percent)
    }
}