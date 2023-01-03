package com.kkaansrky.valorantapp.data.remote.source.agent

import com.kkaansrky.valorantapp.data.remote.api.AgentService
import com.kkaansrky.valorantapp.data.remote.source.BaseRemoteDataSource
import javax.inject.Inject

class AgentRemoteDataSourceImpl @Inject constructor(
    private val agentService: AgentService
) : BaseRemoteDataSource(), AgentRemoteDataSource {

    override suspend fun getAgents(language: String, isPlayableCharacter: Boolean) = getResult {
        agentService.getAgents(language, isPlayableCharacter)
    }

    override suspend fun getAgentByUID(agentUID: String, language: String) = getResult {
        agentService.getAgentByUID(agentUID, language)
    }
}