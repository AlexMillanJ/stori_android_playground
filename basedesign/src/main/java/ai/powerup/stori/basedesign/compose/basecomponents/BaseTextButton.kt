package ai.powerup.stori.basedesign.compose.basecomponents

import ai.powerup.stori.basedesign.compose.theme.Gray400
import ai.powerup.stori.basedesign.compose.theme.Shapes
import ai.powerup.stori.basedesign.compose.theme.Stori700Primary
import ai.powerup.stori.basedesign.compose.theme.Typography
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun BaseTextButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = Typography.button,
    contentColor: Color = Stori700Primary,
    disabledContentColor: Color = Gray400,
    elevation: ButtonElevation? = null,
    shape: Shape = Shapes.small,
    contentPadding: PaddingValues = PaddingValues(horizontal = 8.dp, vertical = 3.dp),
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    onClick: () -> Unit
){
    TextButton(
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            contentColor = contentColor,
            disabledContentColor = disabledContentColor
        ),
        enabled = enabled,
        elevation = elevation,
        shape = shape,
        contentPadding = contentPadding,
        onClick = onClick
    ) {
        ButtonContent(
            text = text,
            textStyle = textStyle,
            contentColor = contentColor,
            enableIcon = enableIcon
        )
    }
}