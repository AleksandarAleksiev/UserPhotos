package com.aaleksiev.userphotos.photos.repository.users

import com.aaleksiev.photosapi.users.UsersApi
import com.aaleksiev.userphotos.Dummy.dummyError
import com.aaleksiev.userphotos.Dummy.userResponse
import com.aaleksiev.userphotos.TestBase
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock

class UsersRepositoryTest : TestBase() {
    @Mock
    private lateinit var usersApi: UsersApi

    private lateinit var underTest: UsersRepository

    override fun setUp() {
        super.setUp()
        underTest = UsersRepository(usersApi = usersApi)
    }

    @Test
    fun `given successful call to users api then will propagate users response downstream`() {
        given(usersApi.getUsers()).willReturn(Single.just(listOf(userResponse)))

        underTest.getUsers()
            .test()
            .assertValue(listOf(userResponse))
    }

    @Test
    fun `given error returned while loading users then will propagate the error downstream`() {
        given(usersApi.getUsers()).willReturn(Single.error(dummyError))

        underTest.getUsers()
            .test()
            .assertError(dummyError)
    }
}