package com.kkaansrky.valorantapp.data.repository.buddy

import com.kkaansrky.valorantapp.data.model.buddies.BuddiesResponse
import com.kkaansrky.valorantapp.data.model.buddies.BuddyResponse
import com.kkaansrky.valorantapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface BuddyRepository {
    suspend fun getBuddies(language: String): Flow<Resource<BuddiesResponse>>
    suspend fun getBuddyById(buddyUuid: String, language: String): Flow<Resource<BuddyResponse>>
}