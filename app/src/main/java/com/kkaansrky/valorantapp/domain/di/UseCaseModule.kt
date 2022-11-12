package com.kkaansrky.valorantapp.domain.di

import com.kkaansrky.valorantapp.domain.repository.AgentRepository
import com.kkaansrky.valorantapp.domain.usecase.GetAgentsUseCase
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
}