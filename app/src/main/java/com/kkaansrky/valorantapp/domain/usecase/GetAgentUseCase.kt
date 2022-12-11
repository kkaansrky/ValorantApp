package com.kkaansrky.valorantapp.domain.usecase

import com.kkaansrky.valorantapp.data.entities.agent.AgentResponse
import com.kkaansrky.valorantapp.domain.base.BaseUseCase
import com.kkaansrky.valorantapp.domain.base.IParams
import com.kkaansrky.valorantapp.domain.repository.AgentRepository
import com.kkaansrky.valorantapp.util.Resource
import kotlinx.coroutines.flow.Flow

class GetAgentUseCase(
    private val agentRepository: AgentRepository
) : BaseUseCase<GetAgentUseCase.Params, Resource<AgentResponse>> {

    data class Params(
        val agentUID: String,
        val language: String
    ) : IParams

    override suspend fun invoke(param: Params): Flow<Resource<AgentResponse>> {
        return agentRepository.getAgentByUID(param.agentUID, param.language)
    }
}