package ai.powerup.stori.basedesign.compose.basecomponents

import ai.powerup.stori.basedesign.compose.theme.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enableIcon: Boolean = false,
    contentColor: Color = White,
    disableContentColor: Color = GeneralGray400,
    backgroundColor: Color = Stori700Primary,
    disableBackgroundColor: Color = GeneralGray200,
    enabled: Boolean = true,
    elevation: ButtonElevation? = null,
    shape: Shape = Shapes.medium,
    borderStroke: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit
){
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            disabledBackgroundColor = disableBackgroundColor,
            disabledContentColor = disableContentColor
        ),
        enabled = enabled,
        elevation = elevation,
        shape = shape,
        border = borderStroke,
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