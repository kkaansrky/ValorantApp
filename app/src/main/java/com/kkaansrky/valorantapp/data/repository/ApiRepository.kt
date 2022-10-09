package com.kkaansrky.valorantapp.data.repository

import com.kkaansrky.valorantapp.data.remote.RemoteDataSource
import com.kkaansrky.valorantapp.util.performNetworkOperation
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private var remoteDataSource: RemoteDataSource
) {

    suspend fun getAgents(language: String, isPlayableCharacter: Boolean) =
        performNetworkOperation {
            remoteDataSource.getAgents(language, isPlayableCharacter)
        }

    suspend fun getAgentByUID(agentUID: String, language: String) = performNetworkOperation {
        remoteDataSource.getAgentByUID(agentUID, language)
    }
}