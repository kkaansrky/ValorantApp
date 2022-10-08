package com.kkaansrky.valorantapp.ui

sealed class Screen(val route: String) {
    object AgentsListScreen : Screen("agents_list_screen")
    object AgentDetailScreen: Screen("agent_detail_screen")
}