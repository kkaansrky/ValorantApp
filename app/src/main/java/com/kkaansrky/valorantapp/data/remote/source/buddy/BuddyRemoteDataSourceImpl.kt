package com.kkaansrky.valorantapp.data.remote.source.buddy

import com.kkaansrky.valorantapp.data.remote.api.BuddyService
import com.kkaansrky.valorantapp.data.remote.source.BaseRemoteDataSource
import javax.inject.Inject

class BuddyRemoteDataSourceImpl @Inject constructor(
    private val buddyService: BuddyService
) : BaseRemoteDataSource(), BuddyRemoteDataSource {

    override suspend fun getBuddies(language: String) = getResult {
        buddyService.getBuddies(language)
    }

    override suspend fun getBuddyById(buddyUuid: String, language: String) = getResult {
        buddyService.getBuddyById(buddyUuid, language)
    }
}