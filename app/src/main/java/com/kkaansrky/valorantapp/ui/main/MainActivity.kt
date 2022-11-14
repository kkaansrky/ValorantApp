package com.kkaansrky.valorantapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deliveryhero.whetstone.activity.ContributesActivityInjector
import com.kkaansrky.valorantapp.ui.Screen
import com.kkaansrky.valorantapp.ui.agent.agentdetail.AgentDetailScreen
import com.kkaansrky.valorantapp.ui.agent.listagents.AgentsListScreen
import com.kkaansrky.valorantapp.ui.theme.ValorantAppTheme

@ContributesActivityInjector
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.AgentsListScreen.route
                ) {
                    composable(
                        route = Screen.AgentsListScreen.route
                    ) {
                        AgentsListScreen(navController)
                    }
                    composable(
                        route = Screen.AgentDetailScreen.route + "/{agentUID}"
                    ) {
                        AgentDetailScreen(navController)
                    }

                }
            }
        }
    }
}
