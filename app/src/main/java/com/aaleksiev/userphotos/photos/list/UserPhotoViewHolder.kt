package com.aaleksiev.userphotos.photos.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aaleksiev.userphotos.databinding.LayoutPhotoBinding
import com.aaleksiev.userphotos.photos.models.UserPhoto
import com.squareup.picasso.Picasso

class UserPhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = LayoutPhotoBinding.bind(itemView)
    fun onBind(item: UserPhoto, position: Int) = with(binding) {
        title.text = item.title
        album.text = item.albumName
        user.text = item.userName
        Picasso.get()
            .load(item.thumbnailUrl)
            .into(thumbnail)
    }
}