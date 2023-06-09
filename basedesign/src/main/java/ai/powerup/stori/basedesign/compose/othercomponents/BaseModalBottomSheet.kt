package ai.powerup.stori.basedesign.compose.othercomponents

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BaseModalBottomSheet(
    modifier: Modifier = Modifier,
    sheetBackgroundColor: Color = Color.White,
    scrimColor: Color = Color.Black.copy(alpha = 0.6f),
    sheetShape: Shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
    sheetContent: @Composable() (ColumnScope.() -> Unit),
    screenContent: @Composable () -> Unit = {},
    sheetState: ModalBottomSheetState,
    coroutineScope: CoroutineScope
) {
    BackHandler(sheetState.isVisible) { coroutineScope.launch { sheetState.hide() } }

    var isSheetOpened by rememberSaveable {
        mutableStateOf(sheetState.currentValue == ModalBottomSheetValue.Hidden)
    }

    LaunchedEffect(sheetState.currentValue) {
        when (sheetState.currentValue) {
            ModalBottomSheetValue.Hidden -> {
                when {
                    isSheetOpened -> {}
                    else -> {
                        isSheetOpened = true
                        sheetState.show()
                    }
                }
            }
            else -> {}
        }
    }

    ModalBottomSheetLayout(
        sheetBackgroundColor = sheetBackgroundColor,
        modifier = modifier,
        scrimColor = scrimColor,
        sheetShape = sheetShape,
        sheetState = sheetState,
        sheetContent = sheetContent,
        content = screenContent
    )
}

