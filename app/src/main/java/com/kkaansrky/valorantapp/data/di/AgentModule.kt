package com.kkaansrky.valorantapp.data.di

import com.kkaansrky.valorantapp.data.remote.api.AgentService
import com.kkaansrky.valorantapp.data.remote.source.agent.AgentRemoteDataSource
import com.kkaansrky.valorantapp.data.remote.source.agent.AgentRemoteDataSourceImpl
import com.kkaansrky.valorantapp.data.repository.agent.AgentRepositoryImpl
import com.kkaansrky.valorantapp.data.repository.agent.AgentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class AgentModule {

    @Provides
    fun provideAgentService(retrofit: Retrofit): AgentService {
        return retrofit.create(AgentService::class.java)
    }

    @Provides
    fun provideAgentRemoteDataSource(
        agentService: AgentService
    ): AgentRemoteDataSource {
        return AgentRemoteDataSourceImpl(agentService)
    }

    @Provides
    fun provideAgentRepository(
        agentRemoteDataSource: AgentRemoteDataSource
    ): AgentRepository {
        return AgentRepositoryImpl(agentRemoteDataSource)
    }
}