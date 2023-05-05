package ai.powerup.stori.basedesign.compose.basecomponents.field

import ai.powerup.stori.basedesign.compose.theme.GeneralAlertsTextDanger
import ai.powerup.stori.basedesign.compose.theme.GeneralGray400
import ai.powerup.stori.basedesign.compose.theme.GeneralGray600
import ai.powerup.stori.basedesign.compose.theme.Shapes
import ai.powerup.stori.basedesign.compose.theme.SuperApp900Primary
import ai.powerup.stori.basedesign.compose.theme.Typography
import ai.powerup.stori.basedesign.compose.theme.body4
import ai.powerup.stori.basedesign.R
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
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
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun BaseTextField(
    hint: String,
    elevatedHint: String,
    helperText: String? = null,
    errorText: String? = null,
    @DrawableRes fieldIcon: Int? = null,
    @DrawableRes helperIcon: Int? = null,
    focusColor: Color = SuperApp900Primary,
    enableError: Boolean = false,
    enabledField: Boolean = true
) {

    var textState by rememberSaveable { mutableStateOf("") }

    var borderColor by remember { mutableStateOf(GeneralGray400) }

    var isFieldFocus by remember { mutableStateOf(false) }

    var isError by remember { mutableStateOf(enableError) }

    Column {
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
                        GeneralAlertsTextDanger
                    } else if (focusState.isFocused)
                        focusColor
                    else
                        GeneralGray400
                },
            value = textState,
            onValueChange = { newText ->
                textState = newText
                isError = false
                borderColor = focusColor
            },
            textStyle = Typography.body4(),
            cursorBrush = SolidColor(borderColor),
            enabled = enabledField,
            decorationBox = { innerTextField ->

                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    val (content, icon) = createRefs()

                    Column(
                        Modifier.fillMaxHeight().constrainAs(
                            ref = content,
                            constrainBlock = {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                        ).then(
                            if (fieldIcon != null) {
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

                    fieldIcon?.let {
                        Icon(
                            modifier = Modifier.fillMaxHeight().constrainAs(
                                ref = icon,
                                constrainBlock = {
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                    end.linkTo(parent.end)
                                }
                            ).wrapContentWidth(),
                            painter = painterResource(id = it),
                            contentDescription = null,
                            tint = borderColor
                        )
                    }
                }

                AnimatedVisibility(
                    visible = textState.isEmpty() && isFieldFocus.not()
                ) {
                    Text(
                        modifier = Modifier.wrapContentHeight(),
                        text = hint,
                        style = Typography.body4(),
                        color = if (isError) GeneralAlertsTextDanger else GeneralGray400,
                        textAlign = TextAlign.Start
                    )
                }
            }
        )
        
        AnimatedVisibility(visible = helperText != null && isError.not()) {
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
                        tint = if (enabledField) GeneralGray600 else GeneralGray400
                    )
                }

                Text(
                    text = helperText!!,
                    style = Typography.overline,
                    color = if (enabledField) GeneralGray600 else GeneralGray400
                )
            }
        }

        AnimatedVisibility(visible = errorText != null && isError) {
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
                    tint = GeneralAlertsTextDanger
                )

                Text(
                    text = errorText!!,
                    style = Typography.overline,
                    color = GeneralAlertsTextDanger
                )
            }
        }
    }
}