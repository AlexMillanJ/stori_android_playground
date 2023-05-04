package ai.powerup.stori.basedesign.compose.turbocomponents

import ai.powerup.stori.basedesign.compose.basecomponents.PrimaryButton
import ai.powerup.stori.basedesign.compose.theme.Turbo400Primary
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
    PrimaryButton(
        modifier = modifier.width(42.dp),
        text = text,
        enabled = enabled,
        enableIcon = enableIcon,
        backgroundColor = Turbo400Primary,
        onClick = onClick
    )
}