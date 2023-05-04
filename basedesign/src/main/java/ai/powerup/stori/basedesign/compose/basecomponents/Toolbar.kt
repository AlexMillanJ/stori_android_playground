package ai.powerup.stori.basedesign.compose.basecomponents

import ai.powerup.stori.basedesign.compose.theme.Gray900Black
import ai.powerup.stori.basedesign.compose.theme.Stori700Primary
import ai.powerup.stori.basedesign.compose.theme.Typography
import ai.powerup.stori.basedesign.compose.theme.White
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    text: String = "",
    textColor: Color = Gray900Black,
    textStyle: TextStyle = Typography.subtitle2,
    leftIconResource: Int? = null,
    rightIconResource: Int? = null,
    iconTint: Color = Stori700Primary,
    elevation: Dp = 2.dp,
    backgroundColor: Color = White,
    onLeftClick: (() -> Unit)? = null,
    onRightIconClick: (() -> Unit)? = null
){
    TopAppBar(
        modifier = modifier.padding(0.dp),
        elevation = elevation,
        backgroundColor = backgroundColor
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            leftIconResource?.let {
                IconButton(
                    modifier = Modifier.align(CenterVertically),
                    onClick = onLeftClick ?: {}
                ) {
                    Icon(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        tint = iconTint
                    )
                }
            }

            Text(
                modifier = Modifier.align(CenterVertically),
                text = text,
                color = textColor,
                textAlign = TextAlign.Center,
                style = textStyle,
            )

            if (rightIconResource != null) {
                IconButton(
                    modifier = Modifier.align(CenterVertically),
                    onClick = onRightIconClick ?: {}
                ) {
                    Icon(
                        painter = painterResource(id = rightIconResource),
                        contentDescription = null,
                        tint = iconTint
                    )
                }
            } else {
                Spacer(modifier = Modifier.width(48.dp))
            }

        }
    }
}