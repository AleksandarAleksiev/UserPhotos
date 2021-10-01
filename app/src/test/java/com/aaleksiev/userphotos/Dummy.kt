package com.aaleksiev.userphotos

import com.aaleksiev.photosapi.albums.models.AlbumResponse
import com.aaleksiev.photosapi.photos.models.PhotoResponse
import com.aaleksiev.photosapi.users.models.Address
import com.aaleksiev.photosapi.users.models.CompanyInfo
import com.aaleksiev.photosapi.users.models.GeoLocation
import com.aaleksiev.photosapi.users.models.UserResponse

object Dummy {
    val dummyError = IllegalArgumentException()

    val albumResponse = AlbumResponse(
        id = 1,
        userId = 1,
        title = "Album"
    )

    val photoResponse = PhotoResponse(
        id = 1,
        albumId = 1,
        title = "Photo",
        imageUrl = "image",
        thumbnailUrl = "thumbnail"
    )

    val userResponse = UserResponse(
        id = 1,
        name = "Leanne Graham",
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