package com.aaleksiev.photosapi.photos.models

import com.aaleksiev.photosapi.users.models.Address
import com.aaleksiev.photosapi.users.models.CompanyInfo
import com.aaleksiev.photosapi.users.models.GeoLocation
import com.aaleksiev.photosapi.users.models.UserResponse

object Dummy {
    const val usersReportJson = "[{\"id\":1,\"name\":\"Leanne Graham\",\"username\":\"Bret\",\"email\":\"Sincere@april.biz\",\"address\":{\"street\":\"Kulas Light\",\"suite\":\"Apt. 556\",\"city\":\"Gwenborough\",\"zipcode\":\"92998-3874\",\"geo\":{\"lat\":\"-37.3159\",\"lng\":\"81.1496\"}},\"phone\":\"1-770-736-8031 x56442\",\"website\":\"hildegard.org\",\"company\":{\"name\":\"Romaguera-Crona\",\"catchPhrase\":\"Multi-layered client-server neural-net\",\"bs\":\"harness real-time e-markets\"}}]"

    val expectedUsersResponse = listOf(
        UserResponse(
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
    )
}