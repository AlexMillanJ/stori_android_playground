package ai.powerup.stori.basedesign.compose.storicomponents.buttons

import ai.powerup.stori.basedesign.compose.basecomponents.button.ButtonPrimary
import ai.powerup.stori.basedesign.compose.theme.stori_700primary
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StoriPrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
) {
    ButtonPrimary(
        modifier = modifier.width(42.dp),
        text = text,
        enabled = enabled,
        enableIcon = enableIcon,
        backgroundColor = stori_700primary,
        onClick = onClick
    )
}