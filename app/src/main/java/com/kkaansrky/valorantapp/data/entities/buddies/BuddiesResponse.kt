package com.kkaansrky.valorantapp.data.entities.buddies

data class BuddiesResponse(
    val `data`: List<Buddy>,
    val status: Int
)

data class BuddyResponse(
    val `data`: Buddy,
    val status: Int
)

data class Buddy(
    val assetPath: String,
    val displayIcon: String,
    val displayName: String,
    val isHiddenIfNotOwned: Boolean,
    val levels: List<Level>,
    val themeUuid: String,
    val uuid: String
)


data class Level(
    val assetPath: String,
    val charmLevel: Int,
    val displayIcon: String,
    val displayName: String,
    val uuid: String
)