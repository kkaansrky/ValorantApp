package com.kkaansrky.valorantapp.data.di

import com.kkaansrky.valorantapp.data.remote.api.MapService
import com.kkaansrky.valorantapp.data.remote.source.map.MapRemoteDataSource
import com.kkaansrky.valorantapp.data.remote.source.map.MapRemoteDataSourceImpl
import com.kkaansrky.valorantapp.data.repository.map.MapRepository
import com.kkaansrky.valorantapp.data.repository.map.MapRepositoryImpl
import dagger.Provides
import retrofit2.Retrofit

class MapModule {

    @Provides
    fun provideMapService(retrofit: Retrofit): MapService {
        return retrofit.create(MapService::class.java)
    }

    @Provides
    fun provideMapRemoteDataSource(
        buddyService: MapService
    ): MapRemoteDataSource {
        return MapRemoteDataSourceImpl(buddyService)
    }

    @Provides
    fun provideMapRepository(
        buddyRemoteDataSource: MapRemoteDataSource
    ): MapRepository {
        return MapRepositoryImpl(buddyRemoteDataSource)
    }
}