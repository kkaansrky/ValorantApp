package com.kkaansrky.valorantapp.data.remote

import com.kkaansrky.valorantapp.data.entities.AgentResponse
import com.kkaansrky.valorantapp.data.entities.AgentsResponse
import com.kkaansrky.valorantapp.data.entities.buddies.BuddiesResponse
import com.kkaansrky.valorantapp.data.entities.buddies.BuddyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("agents")
    suspend fun getAgents(
        @Query("language") language: String,
        @Query("isPlayableCharacter") isPlayableCharacter: Boolean
    ): Response<AgentsResponse>

    @GET("agents/{agentUuid}")
    suspend fun getAgentByUID(
        @Path("agentUuid") agentUuid: String,
        @Query("language") language: String
    ): Response<AgentResponse>

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