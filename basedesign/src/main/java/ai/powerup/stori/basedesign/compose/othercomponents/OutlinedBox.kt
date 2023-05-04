package ai.powerup.stori.basedesign.compose.othercomponents

import ai.powerup.stori.basedesign.compose.theme.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedBox(
    modifier: Modifier = Modifier,
    shape: Shape = Shapes.medium,
    elevation: Dp = 1.dp,
    contentColor: Color = Black,
    backgroundColor: Color = Stori50,
    borderColor: Color = Stori700Primary,
    borderWidth: Dp = 1.dp,
    onClick: (() -> Unit)? = null,
    content: @Composable ()-> Unit
){
    Card(
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        border = BorderStroke(borderWidth, borderColor),
    ) {
        val internalModifier =
            if (onClick != null)
                Modifier.fillMaxWidth()
                    .clip(shape)
                    .clickable(onClick = onClick)
            else Modifier.fillMaxWidth().clip(shape)

        Box(
            modifier = internalModifier,
            content = { content.invoke() }
        )
    }
}