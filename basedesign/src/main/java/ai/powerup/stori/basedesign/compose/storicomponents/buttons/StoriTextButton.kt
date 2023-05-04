package ai.powerup.stori.basedesign.compose.storicomponents

import ai.powerup.stori.basedesign.compose.basecomponents.ButtonText
import ai.powerup.stori.basedesign.compose.theme.Stori700Primary
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StoriTextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    ButtonText(
        modifier = modifier.height(32.dp),
        text = text,
        contentColor = Stori700Primary,
        enabled = enabled,
        enableIcon = enableIcon,
        onClick = onClick
    )
}