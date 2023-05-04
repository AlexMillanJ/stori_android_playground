package ai.powerup.stori.basedesign.compose.turbocomponents

import ai.powerup.stori.basedesign.compose.basecomponents.SecondaryButton
import ai.powerup.stori.basedesign.compose.theme.Turbo400Primary
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
        contentColor = Turbo400Primary,
        border = BorderStroke(1.dp, Turbo400Primary),
        enabled = enabled,
        enableIcon = enableIcon,
        onClick = onClick
    )
}