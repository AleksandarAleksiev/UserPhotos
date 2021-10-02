package com.aaleksiev.userphotos.photos.list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.aaleksiev.core.extensions.inflate
import com.aaleksiev.userphotos.R
import com.aaleksiev.userphotos.photos.models.UserPhoto

class UserPhotosAdapter : ListAdapter<UserPhoto, UserPhotoViewHolder>(UserPhotosDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPhotoViewHolder =
        UserPhotoViewHolder(parent.inflate(R.layout.layout_photo, false))

    override fun onBindViewHolder(holder: UserPhotoViewHolder, position: Int) {
        holder.onBind(getItem(position), position)
    }
}