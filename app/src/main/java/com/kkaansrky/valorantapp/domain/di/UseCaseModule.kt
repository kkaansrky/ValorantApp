package com.kkaansrky.valorantapp.domain.di

import com.kkaansrky.valorantapp.data.repository.agent.AgentRepository
import com.kkaansrky.valorantapp.data.repository.buddy.BuddyRepository
import com.kkaansrky.valorantapp.data.repository.map.MapRepository
import com.kkaansrky.valorantapp.domain.usecase.agent.GetAgentUseCase
import com.kkaansrky.valorantapp.domain.usecase.agent.GetAgentsUseCase
import com.kkaansrky.valorantapp.domain.usecase.buddy.GetBuddyUseCase
import com.kkaansrky.valorantapp.domain.usecase.map.GetMapsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideGetAgentsUseCase(
        agentRepository: AgentRepository
    ) = GetAgentsUseCase(agentRepository)

    @ViewModelScoped
    @Provides
    fun provideGetAgentUseCase(
        agentRepository: AgentRepository
    ) = GetAgentUseCase(agentRepository)

    @ViewModelScoped
    @Provides
    fun provideGetBuddyUseCase(
        buddyRepository: BuddyRepository
    ) = GetBuddyUseCase(buddyRepository)

    @ViewModelScoped
    @Provides
    fun provideGetMapsUseCase(
        mapRepository: MapRepository
    ) = GetMapsUseCase(mapRepository)
}