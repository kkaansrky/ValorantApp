package com.kkaansrky.valorantapp.data.model.map

data class MapsResponse(
    val `data`: List<MapDto>,
    val status: Int
)