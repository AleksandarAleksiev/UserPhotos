package com.aaleksiev.userphotos.photos.mapper

import com.aaleksiev.photosapi.albums.models.AlbumResponse
import com.aaleksiev.photosapi.photos.models.PhotoResponse
import com.aaleksiev.photosapi.users.models.UserResponse
import com.aaleksiev.userphotos.photos.models.UserPhoto
import javax.inject.Inject

class PhotosMapper @Inject constructor() {
    fun map(albums: List<AlbumResponse>, users: List<UserResponse>, photos: List<PhotoResponse>) =
        albums.asSequence()
            .associateWith { album -> users.firstOrNull { user -> user.id == album.userId } }
            .mapValues { (album, user) -> user to photos.firstOrNull { photo -> photo.albumId == album.id } }
            .mapNotNull { (album, pair) ->
                val (albumUser, albumPhoto) = pair
                if (albumPhoto != null && albumUser != null) {
                    UserPhoto(
                        albumId = album.id,
                        title = albumPhoto.title,
                        albumName = album.title,
                        userName = albumUser.name,
                        thumbnailUrl = albumPhoto.thumbnailUrl
                    )
                } else {
                    null
                }
            }
}