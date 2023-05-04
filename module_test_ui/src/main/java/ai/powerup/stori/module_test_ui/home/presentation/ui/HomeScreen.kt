package ai.powerup.stori.module_test_ui.home.presentation.ui

import ai.powerup.stori.basedesign.compose.basecomponents.button.ButtonText
import ai.powerup.stori.basedesign.compose.utils.SetSystemBarsColor
import ai.powerup.stori.basedesign.compose.basecomponents.field.BaseTextField
import ai.powerup.stori.basedesign.compose.theme.White
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
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
        modifier = Modifier.navigationBarsPadding().padding(all = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ButtonText(
                modifier = Modifier.fillMaxWidth().height(44.dp),
                text = "Text button"
            ) {}

            BaseTextField()
        }
    }
}