package ai.powerup.stori.basedesign.compose.basecomponents.button

import ai.powerup.stori.basedesign.compose.theme.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = Typography.button,
    contentColor: Color = stori_700primary,
    disableContentColor: Color = general_gray_400,
    border: BorderStroke = BorderStroke(1.dp, stori_700primary),
    disableBorder: BorderStroke = BorderStroke(1.dp, general_gray_400),
    enabled: Boolean = true,
    enableIcon: Boolean = false,
    elevation: ButtonElevation? = null,
    shape: Shape = Shapes.medium,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit
){
    val borderStroke = if (enabled) border else disableBorder
    OutlinedButton(
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = white.copy(alpha = 0.0F),
            contentColor = contentColor,
            disabledContentColor = disableContentColor
        ),
        border = borderStroke,
        enabled = enabled,
        elevation = elevation,
        shape = shape,
        contentPadding = contentPadding,
        onClick = onClick
    ) {
        ButtonContent(
            text = text,
            contentColor = contentColor,
            enableIcon = enableIcon
        )
    }
}