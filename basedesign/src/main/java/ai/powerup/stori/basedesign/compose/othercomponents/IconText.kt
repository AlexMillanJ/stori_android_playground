package ai.powerup.stori.basedesign.compose.othercomponents

import ai.powerup.stori.basedesign.compose.theme.general_gray_900_black
import ai.powerup.stori.basedesign.compose.theme.Typography
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun IconText(
    modifier: Modifier = Modifier,
    text: String? = null,
    annotatedText: AnnotatedString? = null,
    textStyle: TextStyle = Typography.subtitle1,
    textColor: Color = general_gray_900_black,
    resource: Int,
    iconTint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    isIcon: Boolean = true
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(9.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isIcon){
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = resource),
                contentDescription = null,
                tint = iconTint
            )
        } else {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = resource),
                contentDescription = null
            )
        }

        text?.let {
            Text(
                text = it,
                color = textColor,
                style = textStyle
            )
        }

        annotatedText?.let {
            Text(
                text = it,
                color = textColor,
                style = textStyle
            )
        }
    }
}