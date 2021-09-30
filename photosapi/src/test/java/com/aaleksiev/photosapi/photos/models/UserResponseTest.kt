package com.aaleksiev.photosapi.photos.models

import com.aaleksiev.photosapi.di.NetworkModule
import com.aaleksiev.photosapi.photos.models.Dummy.expectedUsersResponse
import com.aaleksiev.photosapi.photos.models.Dummy.usersReportJson
import com.aaleksiev.photosapi.users.models.UserResponse
import com.squareup.moshi.Types
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.lang.reflect.Type

class UserResponseTest {

    private val moshi by lazy {
        NetworkModule.providesMoshi()
    }

    @Test
    fun `given credit report JSON then will deserialize it in credit report object`() {
        val actual =
            moshi.adapter<List<UserResponse>>(Types.newParameterizedType(MutableList::class.java, UserResponse::class.java)).fromJson(usersReportJson)

        assertEquals(expectedUsersResponse, actual)
    }

    @Test
    fun `given credit report response object then will serialize it as JSON string`() {
        val actual = moshi.adapter<List<UserResponse>>(Types.newParameterizedType(MutableList::class.java, UserResponse::class.java))
            .toJson(expectedUsersResponse)

        assertEquals(usersReportJson, actual)
    }
}