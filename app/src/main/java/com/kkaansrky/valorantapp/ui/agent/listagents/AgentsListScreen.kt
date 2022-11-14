package com.kkaansrky.valorantapp.ui.agent.listagents

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kkaansrky.valorantapp.data.entities.Agent
import com.kkaansrky.valorantapp.ui.Screen
import com.kkaansrky.valorantapp.ui.agent.items.AgentListItem
import com.kkaansrky.valorantapp.ui.status.ShowError
import com.kkaansrky.valorantapp.ui.status.ShowLoading
import com.kkaansrky.valorantapp.ui.theme.CocoaBean

@Composable
fun AgentsListScreen(
    navController: NavController,
) {
    /*val state = AgentListUiState.Error("dspgdfhpsdh")
    Log.d(TAG, "AgentsListScreen: " + state)
    when (state) {
        is AgentListUiState.Success -> ShowAgentsList(state.agents,navController)
        is AgentListUiState.Error -> {
            ShowError()
            Log.d(TAG, "AgentsListScreen: " + state.exception)
        }
        is AgentListUiState.Loading -> {
            ShowLoading()
        }
    }*/
}

@Composable
fun ShowAgentsList(agents: List<Agent>, navController: NavController) {
    val cellValue = remember { GridLayoutCell(2) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(cellValue.value),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        modifier = Modifier.background(CocoaBean)
    ) {
        items(agents) { agent ->
            AgentListItem(
                agent = agent,
                onItemClick = {
                    navController.navigate(Screen.AgentDetailScreen.route + "/${it.uuid}")
                })
        }
    }
}

class GridLayoutCell(value: Int) {
    var value by mutableStateOf(value)
}