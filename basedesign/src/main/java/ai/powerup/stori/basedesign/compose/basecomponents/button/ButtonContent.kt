package ai.powerup.stori.basedesign.compose.basecomponents

import ai.powerup.stori.basedesign.R
import ai.powerup.stori.basedesign.compose.theme.Typography
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun ButtonContent(
    text: String,
    contentColor: Color,
    enableIcon: Boolean
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = contentColor,
            style = Typography.body2,
        )
        if (enableIcon) {
            Icon(
                painter = painterResource(id = R.drawable.ic_chevron_right_24px),
                contentDescription = null,
                modifier = Modifier.padding(start = 8.dp).width(17.dp),
                tint = contentColor
            )
        }
    }
}