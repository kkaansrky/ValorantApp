package com.kkaansrky.valorantapp.data.repository.map

import com.kkaansrky.valorantapp.data.remote.source.map.MapRemoteDataSource
import com.kkaansrky.valorantapp.util.performNetworkOperation
import javax.inject.Inject

class MapRepositoryImpl @Inject constructor(
    private val mapRemoteDataSource: MapRemoteDataSource
):MapRepository{

    override suspend fun getMaps(language: String) = performNetworkOperation {
        mapRemoteDataSource.getMaps(language)
    }
}