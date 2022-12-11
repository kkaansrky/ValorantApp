package com.kkaansrky.valorantapp.data.model.map

data class MapDto(
    val assetPath: String,
    val callouts: List<Callout>,
    val coordinates: String,
    val displayIcon: String,
    val displayName: String,
    val listViewIcon: String,
    val mapUrl: String,
    val splash: String,
    val uuid: String,
    val xMultiplier: Double,
    val xScalarToAdd: Double,
    val yMultiplier: Double,
    val yScalarToAdd: Double
)

data class Callout(
    val location: Location,
    val regionName: String,
    val superRegionName: String
)

data class Location(
    val x: Double,
    val y: Double
)
