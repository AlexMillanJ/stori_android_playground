package ai.powerup.stori.basedesign.compose.siahorroscomponents.button

import ai.powerup.stori.basedesign.compose.basecomponents.button.ButtonText
import ai.powerup.stori.basedesign.compose.theme.siahorros_secondary_smoke
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TurboTextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    ButtonText(
        modifier = modifier.height(32.dp),
        text = text,
        contentColor = siahorros_secondary_smoke,
        enabled = enabled,
        enableIcon = enableIcon,
        onClick = onClick
    )
}