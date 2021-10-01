package com.aaleksiev.userphotos.photos.repository.albums

import com.aaleksiev.photosapi.albums.AlbumsApi
import com.aaleksiev.userphotos.Dummy.albumResponse
import com.aaleksiev.userphotos.Dummy.dummyError
import com.aaleksiev.userphotos.TestBase
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock

class AlbumsRepositoryTest : TestBase() {
    @Mock
    private lateinit var albumsApi: AlbumsApi

    private lateinit var underTest: AlbumsRepository

    override fun setUp() {
        super.setUp()
        underTest = AlbumsRepository(albumsApi = albumsApi)
    }

    @Test
    fun `given successful call to albums api then will propagate albums response downstream`() {
        given(albumsApi.getAlbums()).willReturn(Single.just(listOf(albumResponse)))

        underTest.getAlbums()
            .test()
            .assertValue(listOf(albumResponse))
    }

    @Test
    fun `given error returned while loading albums then will propagate the error downstream`() {
        given(albumsApi.getAlbums()).willReturn(Single.error(dummyError))

        underTest.getAlbums()
            .test()
            .assertError(dummyError)
    }
}