package ai.powerup.stori.basedesign.compose.siahorroscomponents.field

import ai.powerup.stori.basedesign.compose.basecomponents.field.BaseTextField
import ai.powerup.stori.basedesign.compose.theme.SiAhorrosPrimary600
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable

@Composable
fun TextFieldSiAhorros(
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
        focusColor = SiAhorrosPrimary600,
        enableError = enableError,
        enabledField = enabledField
    )
}