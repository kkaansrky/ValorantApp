package com.kkaansrky.valorantapp.data.remote.source.map

import com.kkaansrky.valorantapp.data.model.map.MapsResponse
import com.kkaansrky.valorantapp.util.Resource

interface MapRemoteDataSource {
    suspend fun getMaps(language: String):Resource<MapsResponse>
}