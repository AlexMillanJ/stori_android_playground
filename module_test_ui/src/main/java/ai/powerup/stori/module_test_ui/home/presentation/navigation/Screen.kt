package ai.powerup.stori.module_test_ui.home.presentation.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home_screen")
}