package com.kkaansrky.valorantapp.data.remote.api

import com.kkaansrky.valorantapp.data.model.map.MapsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MapService {

    @GET("maps")
    suspend fun getMaps(
        @Query("language") language: String
    ): Response<MapsResponse>
}