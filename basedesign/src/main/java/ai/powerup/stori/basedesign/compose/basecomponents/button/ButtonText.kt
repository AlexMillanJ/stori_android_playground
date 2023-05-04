package ai.powerup.stori.basedesign.compose.basecomponents.button

import ai.powerup.stori.basedesign.compose.theme.GeneralGray500
import ai.powerup.stori.basedesign.compose.theme.SuperApp800
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonText(
    modifier: Modifier = Modifier,
    text: String,
    contentColor: Color = SuperApp800,
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    TextButton(
        modifier = modifier.height(44.dp),
        colors = ButtonDefaults.textButtonColors(
            contentColor = contentColor,
            disabledContentColor = GeneralGray500
        ),
        enabled = enabled,
        elevation = null,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        onClick = onClick
    ) {
        ButtonContent(
            text = text,
            contentColor = contentColor,
            enableIcon = enableIcon
        )
    }
}