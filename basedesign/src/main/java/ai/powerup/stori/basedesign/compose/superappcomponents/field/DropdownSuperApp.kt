package ai.powerup.stori.basedesign.compose.superappcomponents.field

import ai.powerup.stori.basedesign.compose.basecomponents.field.BaseDropdownField
import ai.powerup.stori.basedesign.compose.theme.superapp_900primary
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DropdownSuperApp(
    modifier: Modifier = Modifier,
    hint: String = "",
    elevatedHint: String = "",
    enableError: Boolean = false,
    errorMessage: String = "",
    items: List<String>,
    onItemSelected: (item: String) -> Unit = {}
) {
    BaseDropdownField(
        modifier = modifier,
        hint = hint,
        elevatedHint = elevatedHint,
        borderColor = superapp_900primary,
        enableError = enableError,
        errorMessage = errorMessage,
        items = items,
        onItemSelected = onItemSelected
    )
}