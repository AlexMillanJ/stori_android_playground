package ai.powerup.stori.module_test_ui.home.presentation.ui

import ai.powerup.stori.basedesign.compose.basecomponents.SetSystemBarsColor
import ai.powerup.stori.basedesign.compose.storicomponents.StoriPrimaryButton
import ai.powerup.stori.basedesign.compose.theme.White
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onSectionSelected: () -> Unit
) {
    SetSystemBarsColor(
        statusBarColor = White,
        isSystemDarkIcons = true
    )

    Scaffold(
        modifier = Modifier.navigationBarsPadding()
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(White)
        ) {
            StoriPrimaryButton(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .height(45.dp)
                    .padding(horizontal = 16.dp),
                text = "Prueba de boton"
            ) {}
        }
    }
}