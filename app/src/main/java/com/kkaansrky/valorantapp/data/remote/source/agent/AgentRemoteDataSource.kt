package com.kkaansrky.valorantapp.data.remote.source.agent

import com.kkaansrky.valorantapp.data.model.agent.AgentResponse
import com.kkaansrky.valorantapp.data.model.agent.AgentsResponse
import com.kkaansrky.valorantapp.util.Resource

interface AgentRemoteDataSource {
    suspend fun getAgents(language: String, isPlayableCharacter: Boolean): Resource<AgentsResponse>
    suspend fun getAgentByUID(agentUID: String, language: String): Resource<AgentResponse>
}