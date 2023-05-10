package ai.powerup.stori.basedesign.compose.basecomponents.button

import ai.powerup.stori.basedesign.compose.theme.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    enableIcon: Boolean = false,
    contentColor: Color = white,
    disableContentColor: Color = general_gray_400,
    backgroundColor: Color = stori_700primary,
    disableBackgroundColor: Color = general_gray_200,
    enabled: Boolean = true,
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
        elevation = null,
        shape = Shapes.button(),
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