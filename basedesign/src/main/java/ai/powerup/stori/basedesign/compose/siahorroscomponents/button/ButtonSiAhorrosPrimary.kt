package ai.powerup.stori.basedesign.compose.siahorroscomponents.button

import ai.powerup.stori.basedesign.compose.basecomponents.button.ButtonPrimary
import ai.powerup.stori.basedesign.compose.theme.siahorros_secondary_smoke
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TurboPrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    ButtonPrimary(
        modifier = modifier.width(42.dp),
        text = text,
        enabled = enabled,
        enableIcon = enableIcon,
        backgroundColor = siahorros_secondary_smoke,
        onClick = onClick
    )
}