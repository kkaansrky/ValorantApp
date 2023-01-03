package com.kkaansrky.valorantapp.domain.usecase.buddy

import com.kkaansrky.valorantapp.data.model.buddies.BuddiesResponse
import com.kkaansrky.valorantapp.data.repository.buddy.BuddyRepository
import com.kkaansrky.valorantapp.domain.base.BaseUseCase
import com.kkaansrky.valorantapp.domain.base.IParams
import com.kkaansrky.valorantapp.util.Resource
import kotlinx.coroutines.flow.Flow

class GetBuddiesUseCase(
    private val buddyRepository: BuddyRepository
) : BaseUseCase<GetBuddiesUseCase.Params, Resource<BuddiesResponse>> {

    data class Params(
        val language: String
    ) : IParams

    override suspend fun invoke(param: Params): Flow<Resource<BuddiesResponse>> {
        return buddyRepository.getBuddies(param.language)
    }
}