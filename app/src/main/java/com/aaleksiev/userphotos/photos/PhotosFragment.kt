package com.aaleksiev.userphotos.photos

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.aaleksiev.core.extensions.displayChild
import com.aaleksiev.core.models.updateUI
import com.aaleksiev.core.ui.MarginItemDecorator
import com.aaleksiev.core.viewbinding.viewBinding
import com.aaleksiev.userphotos.R
import com.aaleksiev.userphotos.databinding.FragmentUserPhotosBinding
import com.aaleksiev.userphotos.photos.list.UserPhotosAdapter
import com.aaleksiev.userphotos.photos.models.UserPhoto
import com.aaleksiev.userphotos.photos.toolbar.ScrollingFancyIndicatorContainerTabs
import com.aaleksiev.userphotos.photos.viewmodel.PhotosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment : Fragment(R.layout.fragment_user_photos) {

    private val viewModel: PhotosViewModel by viewModels()

    private val binding by viewBinding(
        viewBindingFactory = { FragmentUserPhotosBinding.bind(it) },
        onDestroyBindingCallback = { it.photosList.adapter = null }
    )

    private val photosAdapter = UserPhotosAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            uiState.updateUI(
                onLoading = { onLoading() },
                onSuccess = ::onSuccess,
                onError = { onError() }
            )
        }
        binding.composeView.setContent {
            ScrollingFancyIndicatorContainerTabs()
        }
    }

    private fun onLoading() = with(binding) {
        selectedView.displayChild(loadingProgress.id)
    }

    private fun onSuccess(photos: List<UserPhoto>) = with(binding) {
        selectedView.displayChild(photosList.id)
        photosAdapter.submitList(photos)
    }

    private fun onError() = with(binding) {
        selectedView.displayChild(error.root.id)
    }

    private fun initRecyclerView() = with(binding.photosList) {
        adapter = photosAdapter
        layoutManager = LinearLayoutManager(requireContext())
        addItemDecoration(MarginItemDecorator(
            firstItemMarginTop = R.dimen.dimen_24,
            firstItemMarginStart = R.dimen.dimen_16,
            lastItemMarginBottom = R.dimen.dimen_24,
            lastItemMarginEnd = R.dimen.dimen_16,
            itemMarginStart = R.dimen.dimen_16,
            itemMarginEnd = R.dimen.dimen_16,
            itemMarginTop = R.dimen.dimen_8,
            itemMarginBottom = R.dimen.dimen_8
        ))
    }
}