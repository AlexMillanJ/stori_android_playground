package ai.powerup.stori.basedesign.compose.basecomponents.field

import ai.powerup.stori.basedesign.compose.theme.general_alerts_text_danger
import ai.powerup.stori.basedesign.compose.theme.general_gray_400
import ai.powerup.stori.basedesign.compose.theme.general_gray_600
import ai.powerup.stori.basedesign.compose.theme.Shapes
import ai.powerup.stori.basedesign.compose.theme.superapp_900primary
import ai.powerup.stori.basedesign.compose.theme.Typography
import ai.powerup.stori.basedesign.compose.theme.body4
import ai.powerup.stori.basedesign.R
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun BaseTextField(
    text: String,
    hint: String,
    elevatedHint: String,
    helperText: String? = null,
    errorText: String? = null,
    @DrawableRes trailingIcon: Int? = null,
    @DrawableRes helperIcon: Int? = null,
    trailingIconAction: () -> Unit = {},
    focusColor: Color = superapp_900primary,
    enableError: Boolean = false,
    enabledField: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextChange: (newText: String) -> Unit,
) {
    var textState = text
    var borderColor by remember { mutableStateOf(general_gray_400) }
    var isFieldFocus by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(enableError) }

    val customTextSelectionColors = TextSelectionColors(
        handleColor = borderColor,
        backgroundColor = borderColor
    )

    Column {
        CompositionLocalProvider(
            LocalTextSelectionColors provides customTextSelectionColors
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(
                        width = 1.dp,
                        color = borderColor,
                        shape = Shapes.medium
                    )
                    .padding(horizontal = 12.dp, vertical = 5.dp)
                    .onFocusChanged { focusState ->
                        isFieldFocus = focusState.isFocused
                        borderColor = if (isError) {
                            general_alerts_text_danger
                        } else if (focusState.isFocused) {
                            focusColor
                        } else {
                            general_gray_400
                        }
                    },
                value = textState,
                onValueChange = { newText ->
                    onTextChange(newText)
                    textState = newText
                    isError = false
                    borderColor = focusColor
                },
                textStyle = Typography.body4(),
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                visualTransformation = visualTransformation,
                cursorBrush = SolidColor(borderColor),
                enabled = enabledField,
                decorationBox = { innerTextField ->
                    ConstraintLayout(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        val (content, icon) = createRefs()

                        Column(
                            Modifier
                                .fillMaxHeight()
                                .constrainAs(
                                    ref = content,
                                    constrainBlock = {
                                        start.linkTo(parent.start)
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                    }
                                )
                                .then(
                                    if (trailingIcon != null) {
                                        Modifier.padding(end = 19.dp)
                                    } else Modifier
                                ),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            AnimatedVisibility(
                                visible = textState.isEmpty().not() || isFieldFocus
                            ) {
                                Text(
                                    text = elevatedHint,
                                    style = Typography.overline,
                                    color = borderColor
                                )
                            }
                            innerTextField()
                        }

                        trailingIcon?.let {
                            Icon(
                                modifier = Modifier
                                    .constrainAs(
                                        ref = icon,
                                        constrainBlock = {
                                            top.linkTo(parent.top)
                                            bottom.linkTo(parent.bottom)
                                            end.linkTo(parent.end)
                                        }
                                    )
                                    .clickable { trailingIconAction() }
                                    .wrapContentWidth(),
                                painter = painterResource(id = it),
                                contentDescription = null,
                                tint = borderColor
                            )
                        }
                    }

                    AnimatedVisibility(visible = textState.isEmpty() && isFieldFocus.not()) {
                        HintText(hint = hint, isError = isError)
                    }
                }
            )
        }
        
        AnimatedVisibility(visible = helperText != null && isError.not()) {
            HelperText(
                helperText = helperText!!,
                helperIcon = helperIcon,
                enabledField = enabledField
            )
        }

        AnimatedVisibility(visible = errorText != null && isError) {
            ErrorHelperText(errorText = errorText!!)
        }
    }
}

@Composable
private fun HintText(
    hint: String,
    isError: Boolean
) {
    Text(
        modifier = Modifier.wrapContentHeight(),
        text = hint,
        style = Typography.body4(),
        color = if (isError) general_alerts_text_danger else general_gray_400,
        textAlign = TextAlign.Start
    )
}

@Composable
private fun HelperText(
    helperText: String,
    @DrawableRes helperIcon: Int?,
    enabledField: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        helperIcon?.let {
            Icon(
                painter = painterResource(id = it),
                contentDescription = null,
                tint = if (enabledField) general_gray_600 else general_gray_400
            )
        }

        Text(
            text = helperText,
            style = Typography.overline,
            color = if (enabledField) general_gray_600 else general_gray_400
        )
    }
}

@Composable
private fun ErrorHelperText(
    errorText: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_basics_close_16px),
            contentDescription = null,
            tint = general_alerts_text_danger
        )

        Text(
            text = errorText,
            style = Typography.overline,
            color = general_alerts_text_danger
        )
    }
}