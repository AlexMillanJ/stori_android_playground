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
    background = GeneralBackgroundLight,
    surface = White,
    onPrimary = White,
    onSecondary = GeneralGray900Black,
    onBackground = GeneralGray900Black,
    onSurface = GeneralGray900Black,
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