package com.aaleksiev.userphotos.photos.repository.photos

import com.aaleksiev.photosapi.photos.PhotosApi
import com.aaleksiev.userphotos.Dummy.dummyError
import com.aaleksiev.userphotos.Dummy.photoResponse
import com.aaleksiev.userphotos.TestBase
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock

class PhotosRepositoryTest : TestBase() {
    @Mock
    private lateinit var photosApi: PhotosApi

    private lateinit var underTest: PhotosRepository

    override fun setUp() {
        super.setUp()
        underTest = PhotosRepository(photosApi = photosApi)
    }

    @Test
    fun `given successful call to photos api then will propagate photos response downstream`() {
        given(photosApi.getPhotos()).willReturn(Single.just(listOf(photoResponse)))

        underTest.getPhotos()
            .test()
            .assertValue(listOf(photoResponse))
    }

    @Test
    fun `given error returned while loading photos then will propagate the error downstream`() {
        given(photosApi.getPhotos()).willReturn(Single.error(dummyError))

        underTest.getPhotos()
            .test()
            .assertError(dummyError)
    }
}