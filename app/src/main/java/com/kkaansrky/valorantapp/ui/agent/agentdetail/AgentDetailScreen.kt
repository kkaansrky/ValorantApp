package com.kkaansrky.valorantapp.ui.agent.agentdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.kkaansrky.valorantapp.data.entities.AgentResponse
import com.kkaansrky.valorantapp.ui.status.ShowError
import com.kkaansrky.valorantapp.ui.status.ShowLoading
import com.kkaansrky.valorantapp.ui.theme.Mojo
import com.kkaansrky.valorantapp.ui.theme.RadicalRed
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun AgentDetailScreen(
    navController: NavController,
    agentDetailViewModel: AgentDetailViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Mojo)
    ) {
        val state = agentDetailViewModel.uiState.collectAsState().value

        when (state) {
            is AgentDetailUiState.Loading -> ShowLoading()
            is AgentDetailUiState.Success -> ShowAgentCollapsing(state.agent)
            is AgentDetailUiState.Error -> ShowError()
        }
    }
}

@Composable
fun ShowAgent(agent: AgentResponse) = with(agent.data) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        ShowAgentImage(background = background, fullPortrait = fullPortrait)
        for (i in 1..100)
            ShowAgentSpecs(displayName = displayName, developerName = developerName)
    }
}

@Composable
fun ShowAgentCollapsing(agent: AgentResponse) = with(agent.data) {

    val state = rememberCollapsingToolbarScaffoldState()

    CollapsingToolbarScaffold(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                orientation = Orientation.Vertical,
                // allow to scroll from within the toolbar
                state = rememberScrollableState { delta ->
                    delta
                }
            ),
        enabled = true,
        state = state,
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            val imageHeight = (500 - (500 - 150) * state.toolbarState.progress).dp
            val scale = state.offsetY.toFloat()

            Box(
                modifier = Modifier
                    .background(RadicalRed)
                    .pin()
                    .fillMaxWidth()
                    .height(150.dp)
                    .parallax(0.5f)
                    .graphicsLayer {
                        alpha = state.toolbarState.progress
                    },
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = rememberImagePainter(background),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                )
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = rememberImagePainter(fullPortrait),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            for (i in 1..100) {
                ShowAgentSpecs(displayName = displayName, developerName = developerName)
            }
        }
    }
}

@Composable
private fun ShowAgentSpecs(displayName: String, developerName: String) {
    Text(
        text = displayName,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )

    Text(
        text = developerName,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun ShowAgentImage(background: String, fullPortrait: String) {
    Box(
        modifier = Modifier
            .background(RadicalRed)
    ) {
        Image(
            painter = rememberImagePainter(background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = rememberImagePainter(fullPortrait),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}
