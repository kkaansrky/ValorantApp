package com.kkaansrky.valorantapp.domain.repository

import com.kkaansrky.valorantapp.data.entities.agent.AgentResponse
import com.kkaansrky.valorantapp.data.entities.agent.AgentsResponse
import com.kkaansrky.valorantapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface AgentRepository {
    suspend fun getAgents(language: String, isPlayableCharacter: Boolean): Flow<Resource<AgentsResponse>>
    suspend fun getAgentByUID(agentUID: String, language: String): Flow<Resource<AgentResponse>>
}