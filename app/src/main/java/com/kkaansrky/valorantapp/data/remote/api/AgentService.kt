package com.kkaansrky.valorantapp.data.remote.api

import com.kkaansrky.valorantapp.data.entities.agent.AgentResponse
import com.kkaansrky.valorantapp.data.entities.agent.AgentsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AgentService {

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
}