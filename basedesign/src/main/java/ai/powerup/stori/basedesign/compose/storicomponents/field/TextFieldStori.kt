package ai.powerup.stori.basedesign.compose.storicomponents.field

import ai.powerup.stori.basedesign.compose.basecomponents.field.BaseTextField
import ai.powerup.stori.basedesign.compose.theme.stori_800
import androidx.annotation.DrawableRes
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TextFieldStori(
    text: String,
    hint: String,
    elevatedHint: String,
    helperText: String? = null,
    errorText: String? = null,
    @DrawableRes trailingIcon: Int? = null,
    @DrawableRes helperIcon: Int? = null,
    trailingIconAction: () -> Unit = {},
    enableError: Boolean = false,
    enabledField: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextChange: (newText: String) -> Unit
) {
    BaseTextField(
        text = text,
        hint = hint,
        elevatedHint = elevatedHint,
        helperText = helperText,
        errorText = errorText,
        trailingIcon = trailingIcon,
        helperIcon = helperIcon,
        trailingIconAction = trailingIconAction,
        focusColor = stori_800,
        enableError = enableError,
        enabledField = enabledField,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        onTextChange = onTextChange
    )
}