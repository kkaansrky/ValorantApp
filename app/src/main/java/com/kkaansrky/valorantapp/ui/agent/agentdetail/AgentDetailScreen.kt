package com.kkaansrky.valorantapp.ui.agent.agentdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.deliveryhero.whetstone.compose.injectedViewModel
import com.kkaansrky.valorantapp.data.entities.Agent
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
    viewModel: AgentDetailViewModel = injectedViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Mojo)
    ) {
        val state = viewModel.uiState.collectAsState().value

        when (state) {
            is AgentDetailUiState.Loading -> ShowLoading()
            is AgentDetailUiState.Success -> ShowAgentCollapsing(state.agent)
            is AgentDetailUiState.Error -> ShowError()
        }
    }
}

@Composable
fun ShowAgentCollapsing(agent: AgentResponse) = with(agent.data) {

    val state = rememberCollapsingToolbarScaffoldState()
    val progress = state.toolbarState.progress

    CollapsingToolbarScaffold(
        modifier = Modifier
            .fillMaxSize(),
        state = state,
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            val imageHeight = (200 + (400 - 200) * progress).dp

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(440.dp)
                    .pin()
                    .background(RadicalRed)
            )

            ShowAgentImage(
                background = background,
                fullPortrait = fullPortrait,
                imageHeight = imageHeight
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,

            ) {
            ShowAgentSpecs(agent.data)
        }
    }
}

@Composable
fun ShowAgentSpecs(agent: Agent) {
    ShowAgentHeader(header = agent.displayName)
    ShowAgentText(text = agent.description)
    ShowAgentAbilities(abilities = agent.abilities)
}

