package ai.powerup.stori.basedesign.compose.storicomponents

import ai.powerup.stori.basedesign.compose.basecomponents.field.BaseTextField
import ai.powerup.stori.basedesign.compose.theme.Stori800
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable

@Composable
fun TextFieldStori(
    hint: String,
    elevatedHint: String,
    helperText: String? = null,
    errorText: String? = null,
    @DrawableRes fieldIcon: Int? = null,
    @DrawableRes helperIcon: Int? = null,
    enableError: Boolean = false,
    enabledField: Boolean = true
) {
    BaseTextField(
        hint = hint,
        elevatedHint = elevatedHint,
        helperText = helperText,
        errorText = errorText,
        fieldIcon = fieldIcon,
        helperIcon = helperIcon,
        focusColor = Stori800,
        enableError = enableError,
        enabledField = enabledField
    )
}