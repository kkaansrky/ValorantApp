package com.kkaansrky.valorantapp.data.remote

import com.kkaansrky.valorantapp.data.entities.AgentResponse
import com.kkaansrky.valorantapp.data.entities.AgentsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("agents")
    suspend fun getAgents(
        @Query("language") language: String,
        @Query("isPlayableCharacter") isPlayableCharacter: Boolean
    ): Response<AgentsResponse>

    @GET("agents")
    suspend fun getAgentByUID(
        @Query("language") language: String,
        @Query("agentUuid}") agentUID: String
    ): Response<AgentResponse>
}