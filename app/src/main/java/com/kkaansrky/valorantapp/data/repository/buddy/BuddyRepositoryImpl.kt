package com.kkaansrky.valorantapp.data.repository.buddy

import com.kkaansrky.valorantapp.data.remote.source.buddy.BuddyRemoteDataSource
import com.kkaansrky.valorantapp.util.performNetworkOperation
import javax.inject.Inject

class BuddyRepositoryImpl @Inject constructor(
    private val buddyRemoteDataSource: BuddyRemoteDataSource
) : BuddyRepository {
    override suspend fun getBuddies(language: String) =
        performNetworkOperation {
            buddyRemoteDataSource.getBuddies(language)
        }

    override suspend fun getBuddyById(buddyUuid: String, language: String) =
        performNetworkOperation {
            buddyRemoteDataSource.getBuddyById(buddyUuid, language)
        }
}