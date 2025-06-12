package com.purang.cubco.data.services

import com.purang.cubco.data.dto.response.kakao.KakaoAddressResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface KakaoApiService {
    @GET("v2/local/geo/coord2address.json")
    suspend fun getAddressFromCoordinates(
        @Query("x") longitude: Double,
        @Query("y") latitude: Double,
        @Query("input_coord") inputCoord: String = "WGS84"
    ): KakaoAddressResponseDto
}
