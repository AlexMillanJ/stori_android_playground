package ai.powerup.stori.basedesign.compose.basecomponents.field

import ai.powerup.stori.basedesign.R
import ai.powerup.stori.basedesign.compose.theme.Shapes
import ai.powerup.stori.basedesign.compose.theme.Typography
import ai.powerup.stori.basedesign.compose.theme.body4
import ai.powerup.stori.basedesign.compose.theme.general_alerts_text_danger
import ai.powerup.stori.basedesign.compose.theme.general_gray_400
import ai.powerup.stori.basedesign.compose.theme.general_gray_900_black
import ai.powerup.stori.basedesign.compose.theme.siahorros_secondary_smoke
import ai.powerup.stori.basedesign.compose.theme.superapp_900primary
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@Composable
fun BaseDropdownField(
    modifier: Modifier = Modifier,
    hint: String = "",
    elevatedHint: String = "",
    borderColor: Color = superapp_900primary,
    enableError: Boolean = false,
    errorMessage: String = "",
    items: List<String>,
    onItemSelected: (item: String) -> Unit = {}
) {

    var isExpanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }
    var innerHint by remember { mutableStateOf(hint) }
    var fieldSize by remember { mutableStateOf(Size.Zero)}
    var isError by remember { mutableStateOf(enableError) }

    val rotation: Float by animateFloatAsState(if (isExpanded) 180f else 0f)

    Column(
        modifier = modifier.fillMaxWidth().wrapContentHeight()
    ) {
        Box(
            modifier = Modifier.height(60.dp)
        ) {
            OutlinedTextField(
                value = selectedItem,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        fieldSize = coordinates.size.toSize()
                    },
                label = {
                    Text(
                        text = innerHint,
                        style = Typography.body4()
                    )
                },
                textStyle = Typography.body4(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = general_gray_900_black,
                    disabledTextColor = general_gray_400,
                    focusedBorderColor = borderColor,
                    unfocusedBorderColor = siahorros_secondary_smoke,
                    disabledBorderColor = general_gray_400,
                    errorBorderColor = general_alerts_text_danger,
                    disabledTrailingIconColor = general_gray_400,
                    focusedLabelColor = borderColor,
                    unfocusedLabelColor = siahorros_secondary_smoke,
                    disabledLabelColor = general_gray_400,
                    errorLabelColor = general_alerts_text_danger
                ),
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .rotate(rotation)
                            .clickable {
                                isExpanded = isExpanded.not()
                                innerHint = if (isExpanded) {
                                    elevatedHint
                                } else {
                                    hint
                                }
                            }
                        ,
                        painter = painterResource(id = R.drawable.ic_basics_chevron_down_24px),
                        contentDescription = null
                    )
                },
                shape = Shapes.medium,
                interactionSource = remember { MutableInteractionSource() }
                    .also { interactionSource ->
                        LaunchedEffect(interactionSource) {
                            interactionSource.interactions.collect {
                                if (it is PressInteraction.Release) {
                                    isExpanded = isExpanded.not()
                                    innerHint = if (isExpanded) {
                                        elevatedHint
                                    } else {
                                        hint
                                    }
                                }
                            }
                        }
                    },
                isError = isError,
                readOnly = true
            )
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = Modifier
                    .width(
                        with(LocalDensity.current) { fieldSize.width.toDp() }
                    )
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        onClick = {
                            selectedItem = item
                            isExpanded = false
                            isError = false
                            onItemSelected.invoke(item)
                        }
                    ) {
                        Text(
                            text = item,
                            style = Typography.body4(),
                            color = general_gray_900_black
                        )
                    }
                }
            }
        }

        AnimatedVisibility(visible = isError) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(start = 15.dp, top = 3.dp),
                text = errorMessage,
                style = Typography.caption,
                color = general_alerts_text_danger
            )
        }
    }
}