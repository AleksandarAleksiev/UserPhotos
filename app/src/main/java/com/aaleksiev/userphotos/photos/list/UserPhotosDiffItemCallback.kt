package com.aaleksiev.userphotos.photos.list

import androidx.recyclerview.widget.DiffUtil
import com.aaleksiev.userphotos.photos.models.UserPhoto

class UserPhotosDiffItemCallback : DiffUtil.ItemCallback<UserPhoto>() {
    override fun areItemsTheSame(oldItem: UserPhoto, newItem: UserPhoto): Boolean =
        oldItem.albumId == newItem.albumId

    override fun areContentsTheSame(oldItem: UserPhoto, newItem: UserPhoto): Boolean =
        oldItem == newItem
}