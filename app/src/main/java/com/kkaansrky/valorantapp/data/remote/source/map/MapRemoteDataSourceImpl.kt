package com.kkaansrky.valorantapp.data.remote.source.map

import com.kkaansrky.valorantapp.data.remote.api.MapService
import com.kkaansrky.valorantapp.data.remote.source.BaseRemoteDataSource
import javax.inject.Inject

class MapRemoteDataSourceImpl @Inject constructor(
    private val mapService: MapService
) : BaseRemoteDataSource(), MapRemoteDataSource {

    override suspend fun getMaps(language: String) = getResult {
        mapService.getMaps(language)
    }
}