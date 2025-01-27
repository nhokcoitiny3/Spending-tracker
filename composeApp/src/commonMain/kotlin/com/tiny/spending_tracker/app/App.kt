package com.tiny.spending_tracker.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.tiny.spending_tracker.tracker.presentation.tracker_add.TrackerAddScreenRoot
import com.tiny.spending_tracker.tracker.presentation.tracker_add.TrackerAddViewModel
import com.tiny.spending_tracker.tracker.presentation.tracker_home.TrackerHomeScreenRoot
import com.tiny.spending_tracker.tracker.presentation.tracker_home.TrackerHomeViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController, startDestination = Route.TrackerGraph
        ) {
            navigation<Route.TrackerGraph>(
                startDestination = Route.TrackerHome
            ) {
                composable<Route.TrackerHome> {
                    val viewModel = koinViewModel<TrackerHomeViewModel>()

                    TrackerHomeScreenRoot(viewModel = viewModel, onClickAdd = {
                        navController.navigate(
                            Route.TrackerAdd
                        )
                    })
                }
                composable<Route.TrackerAdd> {
                    val viewModel = koinViewModel<TrackerAddViewModel>()

                    TrackerAddScreenRoot(viewModel = viewModel,
                        onBack = { navController.popBackStack() })
                }
            }
        }

    }
}