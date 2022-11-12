package com.kkaansrky.valorantapp.data.repository

import com.kkaansrky.valorantapp.data.remote.source.agent.AgentRemoteDataSource
import com.kkaansrky.valorantapp.domain.repository.AgentRepository
import com.kkaansrky.valorantapp.util.performNetworkOperation
import javax.inject.Inject

class AgentRepositoryImpl @Inject constructor(
    private var agentRemoteDataSource: AgentRemoteDataSource
) : AgentRepository {

    override suspend fun getAgents(language: String, isPlayableCharacter: Boolean) =
        performNetworkOperation {
            agentRemoteDataSource.getAgents(language, isPlayableCharacter)
        }

    override suspend fun getAgentByUID(agentUID: String, language: String) =
        performNetworkOperation {
            agentRemoteDataSource.getAgentByUID(agentUID, language)
        }
}