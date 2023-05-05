package ai.powerup.stori.basedesign.compose.superappcomponents.field

import ai.powerup.stori.basedesign.compose.basecomponents.field.BaseTextField
import ai.powerup.stori.basedesign.compose.theme.SuperApp900Primary
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable

@Composable
fun TextFieldSuperApp(
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
        focusColor = SuperApp900Primary,
        enableError = enableError,
        enabledField = enabledField
    )
}