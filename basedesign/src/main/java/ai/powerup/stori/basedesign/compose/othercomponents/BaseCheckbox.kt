package ai.powerup.stori.basedesign.compose.othercomponents

import ai.powerup.stori.basedesign.compose.theme.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
fun BaseCheckbox(
    checkedColor: Color = stori_700primary,
    uncheckedColor: Color = general_gray_900_black,
    checkmarkColor: Color = white,
    disabledColor: Color = stori_100.copy(alpha = 0.9f),
    enabled: Boolean = true
){
    var checkedState by remember { mutableStateOf(true) }

    Checkbox(
        colors = CheckboxDefaults.colors(
            checkedColor = checkedColor,
            uncheckedColor = uncheckedColor,
            checkmarkColor = checkmarkColor,
            disabledColor = disabledColor
        ),
        enabled = enabled,
        checked = checkedState,
        onCheckedChange = { checkedState = it }
    )
}