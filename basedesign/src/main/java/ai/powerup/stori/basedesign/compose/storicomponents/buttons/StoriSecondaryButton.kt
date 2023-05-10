package ai.powerup.stori.basedesign.compose.storicomponents

import ai.powerup.stori.basedesign.compose.basecomponents.button.SecondaryButton
import ai.powerup.stori.basedesign.compose.theme.stori_700primary
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StoriSecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    SecondaryButton(
        modifier = modifier.width(42.dp),
        text = text,
        contentColor = stori_700primary,
        border = BorderStroke(1.dp, stori_700primary),
        enabled = enabled,
        enableIcon = enableIcon,
        onClick = onClick
    )
}