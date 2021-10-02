package com.aaleksiev.userphotos.photos.usecase

import com.aaleksiev.core.scheduler.SchedulerProvider
import com.aaleksiev.userphotos.photos.mapper.PhotosMapper
import com.aaleksiev.userphotos.photos.models.UserPhoto
import com.aaleksiev.userphotos.photos.repository.albums.AlbumsRepository
import com.aaleksiev.userphotos.photos.repository.photos.PhotosRepository
import com.aaleksiev.userphotos.photos.repository.users.UsersRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PhotosUseCaseImpl @Inject constructor(
    private val usersRepository: UsersRepository,
    private val albumsRepository: AlbumsRepository,
    private val photosRepository: PhotosRepository,
    private val photosMapper: PhotosMapper,
    private val schedulerProvider: SchedulerProvider
) : PhotosUseCase {

    /**
     * To execute request in parallel
     * we subscribe each observable on its own scheduler
     */
    override fun getUserPhotos(): Single<List<UserPhoto>> = Single.zip(
        albumsRepository.getAlbums().subscribeOn(schedulerProvider.io()),
        usersRepository.getUsers().subscribeOn(schedulerProvider.io()),
        photosRepository.getPhotos().subscribeOn(schedulerProvider.io()),
        { albums, users, photos -> photosMapper.map(albums, users, photos) }
    )
}