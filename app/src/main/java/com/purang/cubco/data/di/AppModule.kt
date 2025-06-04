package com.purang.cubco.data.di

import com.purang.cubco.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Named("kakao.native.key")
    fun provideKakaoNativeKey(): String {
        return BuildConfig.KAKAO_NATIVE_KEY
    }
}