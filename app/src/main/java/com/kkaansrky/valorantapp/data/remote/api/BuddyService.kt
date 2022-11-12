package com.kkaansrky.valorantapp.data.remote.api

import com.kkaansrky.valorantapp.data.entities.buddies.BuddiesResponse
import com.kkaansrky.valorantapp.data.entities.buddies.BuddyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BuddyService {

    @GET("buddies")
    suspend fun getBuddies(
        @Query("language") language: String
    ): Response<BuddiesResponse>

    @GET("buddies/{buddyUuid}")
    suspend fun getBuddyById(
        @Path("buddyUuid") buddyUuid: String,
        @Query("language") language: String
    ): Response<BuddyResponse>
}