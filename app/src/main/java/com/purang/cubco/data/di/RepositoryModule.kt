package com.purang.cubco.data.di

import com.purang.cubco.data.repository.CurationRepository
import com.purang.cubco.data.repositoryimpl.CurationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    /*@Binds
    fun bindDummyRepository(dummyRepositoryImpl: DummyRepositoryImpl): DummyRepository

    *//*@Binds
    fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository*//*

    @Binds
    fun bindClubRepository(clubRepositoryImpl: ClubRepositoryImpl): ClubRepository*/

    @Binds
    fun bindCurationRepository(curationRepositoryImpl: CurationRepositoryImpl): CurationRepository
}
