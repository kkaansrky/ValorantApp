package com.kkaansrky.valorantapp.domain.usecase.map

import com.kkaansrky.valorantapp.data.model.map.MapsResponse
import com.kkaansrky.valorantapp.data.repository.map.MapRepository
import com.kkaansrky.valorantapp.domain.base.BaseUseCase
import com.kkaansrky.valorantapp.domain.base.IParams
import com.kkaansrky.valorantapp.util.Resource
import kotlinx.coroutines.flow.Flow

class GetMapsUseCase(
    private val mapRepository: MapRepository
):BaseUseCase<GetMapsUseCase.Params,Resource<MapsResponse>> {

    data class Params(
        val language: String
    ):IParams

    override suspend fun invoke(param: Params): Flow<Resource<MapsResponse>> {
        return mapRepository.getMaps(param.language)
    }
}