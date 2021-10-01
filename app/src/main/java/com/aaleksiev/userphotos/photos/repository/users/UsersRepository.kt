package com.aaleksiev.userphotos.photos.repository.users

import com.aaleksiev.photosapi.users.UsersApi
import javax.inject.Inject

class UsersRepository @Inject constructor(private val usersApi: UsersApi) {
    fun getUsers() = usersApi.getUsers()
}