package com.kkaansrky.valorantapp.data.repository.map

import com.kkaansrky.valorantapp.data.model.map.MapsResponse
import com.kkaansrky.valorantapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface MapRepository {
    suspend fun getMaps(language: String): Flow<Resource<MapsResponse>>
}