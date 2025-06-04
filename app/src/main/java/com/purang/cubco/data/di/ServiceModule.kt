package com.purang.cubco.data.di

import com.purang.cubco.data.services.CurationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideCurationService(retrofit: Retrofit): CurationService =
        retrofit.create(CurationService::class.java)
}
