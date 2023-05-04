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
    primary = Stori700Primary,
    primaryVariant = Stori600,
    secondary = Stori300Secondary,
    secondaryVariant = Stori100,
    background = BackgroundLight,
    surface = White,
    onPrimary = White,
    onSecondary = Gray900Black,
    onBackground = Gray900Black,
    onSurface = Gray900Black,
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