package ai.powerup.stori.basedesign.compose.turbocomponents

import ai.powerup.stori.basedesign.compose.basecomponents.BaseTextButton
import ai.powerup.stori.basedesign.compose.theme.Turbo400Primary
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
    BaseTextButton(
        modifier = modifier.height(32.dp),
        text = text,
        contentColor = Turbo400Primary,
        enabled = enabled,
        enableIcon = enableIcon,
        onClick = onClick
    )
}