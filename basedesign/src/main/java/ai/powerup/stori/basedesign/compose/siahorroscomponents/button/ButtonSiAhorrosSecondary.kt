package ai.powerup.stori.basedesign.compose.siahorroscomponents.button

import ai.powerup.stori.basedesign.compose.basecomponents.button.SecondaryButton
import ai.powerup.stori.basedesign.compose.theme.siahorros_secondary_smoke
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TurboSecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    SecondaryButton(
        modifier = modifier.width(42.dp),
        text = text,
        contentColor = siahorros_secondary_smoke,
        border = BorderStroke(1.dp, siahorros_secondary_smoke),
        enabled = enabled,
        enableIcon = enableIcon,
        onClick = onClick
    )
}