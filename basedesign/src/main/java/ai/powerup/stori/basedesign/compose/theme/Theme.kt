package ai.powerup.stori.basedesign.compose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

/**
 * Base Theme
 *
 * Here will be all the theming related to the app, this is still work in progress.
 */

private val LightColorPalette = lightColors(
    primary = stori_700primary,
    primaryVariant = stori_600,
    secondary = stori_300secondary,
    secondaryVariant = stori_100,
    background = general_background_light,
    surface = white,
    onPrimary = white,
    onSecondary = general_gray_900_black,
    onBackground = general_gray_900_black,
    onSurface = general_gray_900_black,
)

@Composable
fun SuperAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors =  LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}