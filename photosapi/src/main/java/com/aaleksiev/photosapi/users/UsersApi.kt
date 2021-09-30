package com.aaleksiev.photosapi.users

import com.aaleksiev.photosapi.users.models.UserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface UsersApi {
    @GET("/users")
    fun getUsers(): Single<List<UserResponse>>
}