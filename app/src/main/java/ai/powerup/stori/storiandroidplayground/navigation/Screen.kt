package ai.powerup.stori.storiandroidplayground.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home_screen")
}