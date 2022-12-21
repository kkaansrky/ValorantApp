package com.kkaansrky.valorantapp.ui.maps

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kkaansrky.valorantapp.data.model.map.MapDto
import com.kkaansrky.valorantapp.ui.main.Screen
import com.kkaansrky.valorantapp.ui.status.ShowError
import com.kkaansrky.valorantapp.ui.status.ShowLoading

@Composable
fun MapsScreen(
    mapsViewModel: MapsViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = mapsViewModel.uiState.collectAsState().value
    when (state) {
        is MapsUiState.Success -> ShowMapsList(state.maps, navController)
        is MapsUiState.Error -> {
            ShowError()
        }
        is MapsUiState.Loading -> {
            ShowLoading()
        }
    }
}

@Composable
fun ShowMapsList(maps: List<MapDto>, navController: NavController) {

    LazyColumn(content = {
        items(maps) { map ->
            MapsListItem(
                map = map,
                onItemClick = { map ->
                    navController.navigate(Screen.AgentDetailScreen.route + "/${map.uuid}")
                }
            )
        }
    })
}
