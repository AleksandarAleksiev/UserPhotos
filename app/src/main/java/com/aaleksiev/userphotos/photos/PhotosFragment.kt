package com.aaleksiev.userphotos.photos

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.aaleksiev.userphotos.R
import com.aaleksiev.userphotos.photos.viewmodel.PhotosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment : Fragment(R.layout.fragment_user_photos) {

    private val viewModel: PhotosViewModel by viewModels()
}