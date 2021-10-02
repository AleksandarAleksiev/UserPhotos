package com.aaleksiev.userphotos.photos

import com.aaleksiev.userphotos.Fake.PHOTO_TITLE
import com.aaleksiev.userphotos.Fake.dummyError
import com.aaleksiev.userphotos.Fake.userPhotos
import com.aaleksiev.userphotos.HiltTestBase
import com.aaleksiev.userphotos.photos.usecase.PhotosUseCase
import dagger.hilt.android.testing.HiltAndroidTest
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.BDDMockito.given
import javax.inject.Inject

@HiltAndroidTest
class PhotosFragmentTest : HiltTestBase() {

    @Inject
    lateinit var photosUseCase: PhotosUseCase

    @Test
    fun willDisplayUserCreditReport() {
        given(photosUseCase.getUserPhotos()).willReturn(Single.just(userPhotos))

        userPhotos {
            photoWithTitleIsDisplayed(PHOTO_TITLE)
        }
    }

    @Test
    fun willDisplayError() {
        given(photosUseCase.getUserPhotos()).willReturn(Single.error(dummyError))

        userPhotos {
            errorIsDisplayed()
        }
    }
}