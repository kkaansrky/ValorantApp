package com.kkaansrky.valorantapp.data.remote.source.buddy

import com.kkaansrky.valorantapp.data.model.buddies.BuddiesResponse
import com.kkaansrky.valorantapp.data.model.buddies.BuddyResponse
import com.kkaansrky.valorantapp.util.Resource

interface BuddyRemoteDataSource {
    suspend fun getBuddies(language: String): Resource<BuddiesResponse>
    suspend fun getBuddyById(buddyUuid: String, language: String): Resource<BuddyResponse>
}