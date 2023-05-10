package ai.powerup.stori.basedesign.extensions.string

import ai.powerup.stori.basedesign.extensions.span.setStyle
import ai.powerup.stori.basedesign.compose.theme.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle

@Composable
fun String.styledText(
    normalSpanStyle: SpanStyle = SpanStyle().setStyle(
        color = general_gray_700, textStyle = Typography.body4()
    ),
    primarySpanStyle: SpanStyle = SpanStyle().setStyle(
        color = stori_700primary, textStyle = Typography.body3()
    ),
    secondarySpanStyle: SpanStyle = SpanStyle().setStyle(
        color = general_gray_700, textStyle = Typography.body3()
    ),
    primaryColorText: List<Int>? = null,
    secondaryColorText: List<Int>? = null
): AnnotatedString {
    val styledString = AnnotatedString.Builder()
    styledString.append(this)

    styledString.addStyle(
        style = normalSpanStyle,
        start = 0,
        end = this.length)

    primaryColorText?.forEach { primaryText ->
        val stringValue = stringResource(id = primaryText)
        if (this.contains(stringValue)) {
            val colorStartIndex = this.indexOf(string = stringValue, ignoreCase = true)
            val colorEndIndex = colorStartIndex + stringValue.length
            styledString.addStyle(
                style = primarySpanStyle,
                start = colorStartIndex,
                end = colorEndIndex)
        }
    }

    secondaryColorText?.forEach { secondaryText ->
        val stringValue = stringResource(id = secondaryText)
        if (this.contains(stringValue)) {
            val boldStartIndex = this.indexOf(string = stringValue, ignoreCase = true)
            val boldEndIndex = boldStartIndex + stringValue.length
            styledString.addStyle(
                style = secondarySpanStyle,
                start = boldStartIndex,
                end = boldEndIndex
            )
        }
    }

    return styledString.toAnnotatedString()
}