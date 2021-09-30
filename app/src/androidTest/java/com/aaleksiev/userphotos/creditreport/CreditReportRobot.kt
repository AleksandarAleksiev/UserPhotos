package com.aaleksiev.userphotos.creditreport

import com.aaleksiev.userphotos.R
import com.aaleksiev.userphotos.robot.BaseRobot

class CreditReportRobot : BaseRobot() {
    fun withTitle(title: String) = matchText(R.id.title, title)

    fun withCreditScore(score: Int) = matchText(R.id.credit_score, score.toString())

    fun withDescription(description: String) = matchText(R.id.total_credit_score, description)

    fun errorIsDisplayed() {
        issDisplayed(R.id.error_title)
        issDisplayed(R.id.error_message)
    }
}

fun creditReport(block: CreditReportRobot.() -> Unit) = CreditReportRobot().apply(block)