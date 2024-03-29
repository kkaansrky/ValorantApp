package com.kkaansrky.valorantapp.domain.usecase.agent

import com.kkaansrky.valorantapp.data.model.agent.AgentsResponse
import com.kkaansrky.valorantapp.domain.base.BaseUseCase
import com.kkaansrky.valorantapp.domain.base.IParams
import com.kkaansrky.valorantapp.data.repository.agent.AgentRepository
import com.kkaansrky.valorantapp.util.Resource
import kotlinx.coroutines.flow.Flow

class GetAgentsUseCase(
    private val agentRepository: AgentRepository
): BaseUseCase<GetAgentsUseCase.Params, Resource<AgentsResponse>> {

    data class Params(
        val language: String,
        val isPlayableCharacter: Boolean
    ) : IParams

    override suspend fun invoke(param: Params): Flow<Resource<AgentsResponse>> {
        return agentRepository.getAgents(param.language,param.isPlayableCharacter)
    }
}
