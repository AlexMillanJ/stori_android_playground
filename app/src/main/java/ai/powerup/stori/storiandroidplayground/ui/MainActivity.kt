package ai.powerup.stori.storiandroidplayground.ui

import ai.powerup.stori.basedesign.compose.theme.SuperAppTheme
import ai.powerup.stori.module_test_ui.home.presentation.navigation.homeGraph
import ai.powerup.stori.platformbase.base.BaseComponentActivity
import ai.powerup.stori.storiandroidplayground.navigation.Screen
import ai.powerup.stori.storiandroidplayground.navigation.appGraph
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

class MainActivity: BaseComponentActivity() {

    @Composable
    override fun SetScreenContent(savedInstanceState: Bundle?) {

        setFullScreen()

        val navController = rememberNavController()

        SuperAppTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {
                    appGraph(navController)
                    homeGraph(navController)
                }
            }
        }
    }
}