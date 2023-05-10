package ai.powerup.stori.basedesign.compose.storicomponents

import ai.powerup.stori.basedesign.compose.basecomponents.button.ButtonText
import ai.powerup.stori.basedesign.compose.theme.stori_700primary
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
        contentColor = stori_700primary,
        enabled = enabled,
        enableIcon = enableIcon,
        onClick = onClick
    )
}