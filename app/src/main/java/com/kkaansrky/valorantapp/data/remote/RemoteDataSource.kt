package com.kkaansrky.valorantapp.data.remote

import com.kkaansrky.valorantapp.util.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) : BaseDataSource() {

    suspend fun getAgents(language: String, isPlayableCharacter: Boolean) = getResult {
        apiService.getAgents(language, isPlayableCharacter)
    }


    suspend fun getAgentByUID(agentUID: String, language: String) = getResult {
        apiService.getAgentByUID(agentUID, language)
    }
}