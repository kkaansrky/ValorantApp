package com.kkaansrky.valorantapp.ui.listagents

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.kkaansrky.valorantapp.data.entities.AgentResponse
import com.kkaansrky.valorantapp.ui.error.showError
import com.kkaansrky.valorantapp.ui.error.showLoading

@Composable
fun AgentsListScreen(
    navController: NavController,
    agentsListViewModel: AgentsListViewModel = hiltViewModel()
) {
    val state = agentsListViewModel.uiState.collectAsState().value
    Log.d(TAG, "AgentsListScreen: " + state)
    when (state) {
        is AgentsUiState.Success -> showAgentsList(state.agents)
        is AgentsUiState.Error -> {
            showError()
            Log.d(TAG, "AgentsListScreen: " + state.exception)
        }
        is AgentsUiState.Loading -> {
            showLoading()
        }
    }
}

@Composable
fun showAgentsList(agents: List<AgentResponse>) {
    val cellValue = remember { GridLayoutCell(2) }
    Text(text = "agentsList")

    LazyVerticalGrid(
        columns = GridCells.Fixed(cellValue.value),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(agents) { agent ->
                AgentListItem(agent = agent)
            }
        }
    )
}

@Composable
fun AgentListItem(agent: AgentResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.Gray,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 4.dp)
            ) {
                Image(
                    painter = rememberImagePainter(agent.background),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = rememberImagePainter(agent.fullPortrait),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }


            Text(
                text = agent.displayName,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}


class GridLayoutCell(value: Int) {
    var value by mutableStateOf(value)
}