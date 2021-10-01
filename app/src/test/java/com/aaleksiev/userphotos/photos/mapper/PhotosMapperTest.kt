package com.aaleksiev.userphotos.photos.mapper

import com.aaleksiev.userphotos.Dummy.ALBUM_NAME
import com.aaleksiev.userphotos.Dummy.PHOTO_THUMBNAIL
import com.aaleksiev.userphotos.Dummy.PHOTO_TITLE
import com.aaleksiev.userphotos.Dummy.USER_NAME
import com.aaleksiev.userphotos.Dummy.albumResponse
import com.aaleksiev.userphotos.Dummy.photoResponse
import com.aaleksiev.userphotos.Dummy.userResponse
import com.aaleksiev.userphotos.photos.models.UserPhoto
import org.junit.Assert.assertEquals
import org.junit.Test

class PhotosMapperTest {
    private val underTest = PhotosMapper()

    @Test
    fun `given albums, users, photos then will map user photos UI model`() {
        val albums = listOf(albumResponse)
        val users = listOf(userResponse)
        val photos = listOf(photoResponse, photoResponse.copy(id = 2, title = "Some Title"))

        val actual = underTest.map(albums = albums, users = users, photos = photos)

        val expected = listOf(
            UserPhoto(
                title = PHOTO_TITLE,
                albumName = ALBUM_NAME,
                userName = USER_NAME,
                thumbnailUrl = PHOTO_THUMBNAIL
            )
        )

        assertEquals(expected, actual)
    }
}