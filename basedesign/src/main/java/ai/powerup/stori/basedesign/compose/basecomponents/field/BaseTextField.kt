package ai.powerup.stori.basedesign.compose.basecomponents.field

import ai.powerup.stori.basedesign.compose.theme.Black
import ai.powerup.stori.basedesign.compose.theme.Typography
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BaseTextField() {
    var textState by remember { mutableStateOf("") }

    BasicTextField(
        modifier = Modifier
            .wrapContentSize()
            .border(width = 1.5.dp, color = Black, RoundedCornerShape(8.dp)),
        value = textState,
        textStyle = Typography.h4,
        onValueChange = {
            textState = it
        },
        maxLines = 1,
        decorationBox = { innerTextField ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Text(text = "Hi enter your text")
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                ) {
                    Icon(
                        Icons.Rounded.Person,
                        contentDescription = "",
                        Modifier
                            .padding(8.dp)
                            .size(30.dp)

                    )
                    //this must be called once and in any part of this lambda we want to put it
                    innerTextField()

                    Icon(
                        Icons.Rounded.Check,
                        contentDescription = "",
                        Modifier
                            .padding(8.dp)
                            .size(30.dp)
                    )

                }
            }

        }
    )
}