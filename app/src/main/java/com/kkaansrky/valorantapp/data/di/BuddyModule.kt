package com.kkaansrky.valorantapp.data.di

import com.kkaansrky.valorantapp.data.remote.api.BuddyService
import com.kkaansrky.valorantapp.data.remote.source.buddy.BuddyRemoteDataSource
import com.kkaansrky.valorantapp.data.remote.source.buddy.BuddyRemoteDataSourceImpl
import com.kkaansrky.valorantapp.data.repository.buddy.BuddyRepository
import com.kkaansrky.valorantapp.data.repository.buddy.BuddyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class BuddyModule {

    @Provides
    fun provideBuddyService(retrofit: Retrofit): BuddyService {
        return retrofit.create(BuddyService::class.java)
    }

    @Provides
    fun provideBuddyRemoteDataSource(
        buddyService: BuddyService
    ): BuddyRemoteDataSource {
        return BuddyRemoteDataSourceImpl(buddyService)
    }

    @Provides
    fun provideBuddyRepository(
        buddyRemoteDataSource: BuddyRemoteDataSource
    ): BuddyRepository {
        return BuddyRepositoryImpl(buddyRemoteDataSource)
    }
}