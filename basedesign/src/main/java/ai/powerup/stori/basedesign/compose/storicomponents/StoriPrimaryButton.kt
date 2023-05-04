package ai.powerup.stori.basedesign.compose.storicomponents

import ai.powerup.stori.basedesign.compose.basecomponents.PrimaryButton
import ai.powerup.stori.basedesign.compose.theme.Stori700Primary
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StoriPrimaryButton(
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
        backgroundColor = Stori700Primary,
        onClick = onClick
    )
}

@Preview
@Composable
private fun PreviewStoriPrimaryButton() {
    StoriPrimaryButton(text = "Prueba") {}
}