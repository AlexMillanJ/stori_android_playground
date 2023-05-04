package ai.powerup.stori.basedesign.compose.othercomponents

import ai.powerup.stori.basedesign.compose.theme.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
fun BaseCheckbox(
    checkedColor: Color = Stori700Primary,
    uncheckedColor: Color = Gray900Black,
    checkmarkColor: Color = White,
    disabledColor: Color = Stori100.copy(alpha = 0.9f),
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