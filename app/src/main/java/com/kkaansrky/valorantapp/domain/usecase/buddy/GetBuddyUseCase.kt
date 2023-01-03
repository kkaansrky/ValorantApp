package com.kkaansrky.valorantapp.domain.usecase.buddy

import com.kkaansrky.valorantapp.data.model.buddies.BuddyResponse
import com.kkaansrky.valorantapp.data.repository.buddy.BuddyRepository
import com.kkaansrky.valorantapp.domain.base.BaseUseCase
import com.kkaansrky.valorantapp.domain.base.IParams
import com.kkaansrky.valorantapp.util.Resource
import kotlinx.coroutines.flow.Flow

class GetBuddyUseCase(
    private val buddyRepository: BuddyRepository
) : BaseUseCase<GetBuddyUseCase.Params, Resource<BuddyResponse>> {

    data class Params(
        val buddyUuid: String,
        val language: String
    ) : IParams

    override suspend fun invoke(param: Params): Flow<Resource<BuddyResponse>> {
        return buddyRepository.getBuddyById(param.buddyUuid, param.language)
    }
}