package com.purang.cubco.data.services

import com.purang.cubco.data.dto.response.curation.CurationDetailResponseDto
import com.purang.cubco.data.dto.response.curation.CurationListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CurationService {
    @GET("curations")
    suspend fun getCurations(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): CurationListDto

    @GET("curations/{curationId}")
    suspend fun getCurationDetail(
        @Path("curationId") curationId: Long
    ): CurationDetailResponseDto
}