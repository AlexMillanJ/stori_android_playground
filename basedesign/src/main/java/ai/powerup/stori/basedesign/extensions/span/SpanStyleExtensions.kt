package ai.powerup.stori.basedesign.extensions.span

import ai.powerup.stori.basedesign.compose.theme.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

fun SpanStyle.setStyle(
    color: Color,
    textStyle: TextStyle
) = SpanStyle(
    fontFamily = textStyle.fontFamily,
    fontSize = textStyle.fontSize,
    fontWeight = textStyle.fontWeight,
    color = color
)

fun SpanStyle.setBoldStyle(
    color: Color,
    typography: TextStyle = Typography.caption
) = SpanStyle(
    fontFamily = typography.fontFamily,
    fontSize = typography.fontSize,
    fontWeight = FontWeight.Bold,
    color = color
)

fun SpanStyle.setSemiBoldStyle(
    color: Color,
    typography: TextStyle = Typography.caption
) = SpanStyle(
    fontFamily = typography.fontFamily,
    fontSize = typography.fontSize,
    fontWeight = FontWeight.SemiBold,
    color = color
)

fun SpanStyle.setUnderlineStyle(
    color: Color,
    typography: TextStyle = Typography.caption
) = SpanStyle(
    fontFamily = typography.fontFamily,
    fontSize = typography.fontSize,
    fontWeight = typography.fontWeight,
    color = color,
    textDecoration = TextDecoration.Underline
)