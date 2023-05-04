package ai.powerup.stori.basedesign.compose.othercomponents

import ai.powerup.stori.basedesign.compose.basecomponents.button.ButtonText
import ai.powerup.stori.basedesign.compose.basecomponents.button.PrimaryButton
import ai.powerup.stori.basedesign.compose.utils.SetSystemBarsColor
import ai.powerup.stori.basedesign.compose.theme.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun BaseBottomSheetContent(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    textIcon: Int? = null,
    headIcon: Int? = null,
    mainBtnText: String = "",
    mainBtnAction: (() -> Unit)? = null,
    mainBtnColor: Color = Stori700Primary,
    secondaryBtnText: String = "",
    secondaryBtnAction: (() -> Unit)? = null,
    secondaryBtnColor: Color = Stori700Primary
) {
    SetSystemBarsColor(
        statusBarColor = Color.Transparent,
        isSystemDarkIcons = true
    )
    Column(
        modifier = modifier.padding(
            start = 15.dp,
            end =  15.dp,
            top = 15.dp
        )
    ) {
        Spacer(modifier = Modifier.height(9.dp))

        Box(
            modifier = Modifier
                .height(6.dp)
                .width(48.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .clip(CircleShape)
                .background(GeneralGray200)
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (headIcon != null){
            Image(
                modifier = Modifier
                    .height(28.dp)
                    .width(28.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                painter = painterResource(id = headIcon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(10.dp))
        }

        BottomSheetHeader(title = title, icon = textIcon)

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = message,
            color = GeneralGray900Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = Typography.body4()
        )

        Spacer(modifier = Modifier.height(20.dp))

        BottomSheetButtons(
            mainBtnText = mainBtnText,
            mainBtnAction = mainBtnAction,
            mainBtnColor = mainBtnColor,
            secondaryBtnText = secondaryBtnText,
            secondaryBtnAction = secondaryBtnAction,
            secondaryBtnColor = secondaryBtnColor
        )
    }
}

@Composable
private fun BottomSheetHeader(
    title: String,
    icon: Int?
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.height(32.dp),
            text = title,
            color = GeneralGray900Black,
            textAlign = TextAlign.Center,
            style = Typography.h3
        )

        Spacer(modifier = Modifier.width(8.dp))

        if (icon != null) {
            Image(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp),
                painter = painterResource(id = icon),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun BottomSheetButtons(
    mainBtnText: String = "",
    mainBtnAction: (() -> Unit)?,
    mainBtnColor: Color,
    secondaryBtnText: String = "",
    secondaryBtnAction: (() -> Unit)?,
    secondaryBtnColor: Color
){
    if (mainBtnAction != null){
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            text = mainBtnText,
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp
            ),
            onClick = mainBtnAction,
            backgroundColor = mainBtnColor
        )
        Spacer(modifier = Modifier.height(18.dp))
    }

    if (secondaryBtnAction != null){
        Spacer(modifier = Modifier.height(8.dp))

        ButtonText(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            text = secondaryBtnText,
            onClick = secondaryBtnAction,
            contentColor = secondaryBtnColor
        )
    }
}