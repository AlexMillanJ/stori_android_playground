package ai.powerup.stori.basedesign.compose.siahorroscomponents.field

import ai.powerup.stori.basedesign.compose.basecomponents.field.BaseDropdownField
import ai.powerup.stori.basedesign.compose.theme.siahorros_primary_sea
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DropdownSiAhorros(
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
        borderColor = siahorros_primary_sea,
        enableError = enableError,
        errorMessage = errorMessage,
        items = items,
        onItemSelected = onItemSelected
    )
}