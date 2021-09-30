package com.aaleksiev.userphotos.creditreport

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.aaleksiev.core.models.updateUI
import com.aaleksiev.core.viewbinding.viewBinding
import com.aaleksiev.userphotos.R
import com.aaleksiev.userphotos.creditreport.models.UserCreditReport
import com.aaleksiev.userphotos.creditreport.viewmodel.CreditReportViewModel
import com.aaleksiev.userphotos.databinding.FragmentCreditReportBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreditReportFragment : Fragment(R.layout.fragment_credit_report) {

    private val viewModel: CreditReportViewModel by viewModels()

    private val binding by viewBinding(FragmentCreditReportBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            uiState.updateUI(
                onLoading = ::onLoading,
                onSuccess = ::onSuccess,
                onError = { onError() }
            )
        }
    }

    private fun onLoading(isLoading: Boolean) {
        binding.selectedView.isVisible = !isLoading
        binding.doughnutLayout.setIndeterminate(isLoading)
    }

    private fun onSuccess(userCreditReport: UserCreditReport) = with(binding) {
        selectedView.displayChild(report.root.id)
        doughnutLayout.setPercent(userCreditReport.percentOfTotal())
        report.totalCreditScore.text =
            getString(R.string.your_credit_score_out_of, userCreditReport.maxCreditScore)
        report.creditScore.text = userCreditReport.creditScore.toString()
    }

    private fun onError() = with(binding) {
        selectedView.displayChild(error.root.id)
        doughnutLayout.setPercent(0)
    }
}