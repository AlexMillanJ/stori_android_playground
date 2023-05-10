package ai.powerup.stori.storiandroidplayground.navigation

import ai.powerup.stori.module_test_ui.home.presentation.ui.HomeScreen
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.appGraph(
    navController: NavController
) {
    val appNavigator = AppNavigator(navController)

    composable(route = Screen.Home.route) {
        HomeScreen()
    }
}
