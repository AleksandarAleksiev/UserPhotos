package com.aaleksiev.userphotos

import com.aaleksiev.photosapi.albums.models.AlbumResponse
import com.aaleksiev.photosapi.photos.models.PhotoResponse
import com.aaleksiev.photosapi.users.models.Address
import com.aaleksiev.photosapi.users.models.CompanyInfo
import com.aaleksiev.photosapi.users.models.GeoLocation
import com.aaleksiev.photosapi.users.models.UserResponse

object Dummy {
    const val ALBUM_ID = 1
    const val ALBUM_NAME = "Album"
    const val USER_ID = 1
    const val USER_NAME = "Leanne Graham"
    const val PHOTO_ID = 1
    const val PHOTO_TITLE = "Photo"
    const val PHOTO_THUMBNAIL = "thumbnail"

    val dummyError = IllegalArgumentException()

    val albumResponse = AlbumResponse(
        id = ALBUM_ID,
        userId = USER_ID,
        title = ALBUM_NAME
    )

    val photoResponse = PhotoResponse(
        id = PHOTO_ID,
        albumId = ALBUM_ID,
        title = PHOTO_TITLE,
        imageUrl = "image",
        thumbnailUrl = PHOTO_THUMBNAIL
    )

    val userResponse = UserResponse(
        id = 1,
        name = USER_NAME,
        userName = "Bret",
        email = "Sincere@april.biz",
        address = Address(
            street = "Kulas Light",
            suite = "Apt. 556",
            city = "Gwenborough",
            postCode = "92998-3874",
            geoLocation = GeoLocation(
                latitude = "-37.3159",
                longitude = "81.1496"
            )
        ),
        phoneNumber = "1-770-736-8031 x56442",
        website = "hildegard.org",
        companyInfo = CompanyInfo(
            name = "Romaguera-Crona",
            catchPhrase = "Multi-layered client-server neural-net",
            bs = "harness real-time e-markets"
        ),
    )
}