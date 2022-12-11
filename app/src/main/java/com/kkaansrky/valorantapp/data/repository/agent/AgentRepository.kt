package com.kkaansrky.valorantapp.data.repository.agent

import com.kkaansrky.valorantapp.data.model.agent.AgentResponse
import com.kkaansrky.valorantapp.data.model.agent.AgentsResponse
import com.kkaansrky.valorantapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface AgentRepository {
    suspend fun getAgents(language: String, isPlayableCharacter: Boolean): Flow<Resource<AgentsResponse>>
    suspend fun getAgentByUID(agentUID: String, language: String): Flow<Resource<AgentResponse>>
}