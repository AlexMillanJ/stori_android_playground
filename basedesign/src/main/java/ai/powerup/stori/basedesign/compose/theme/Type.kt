package ai.powerup.stori.basedesign.compose.theme

import ai.powerup.stori.basedesign.R
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Typography
 *
 * A set of Font Family values created for the design system, you must implement the values
 * contained inside this file when creating a component where text style is needed, these typography
 * was created base on the design system and are implemented along the app to keep it uniform and
 * concise.
 *
 * If a typography that you need is not here, please reach out to your UX designer to ask for
 * typography that is included in this file, other wise we will be breaking the agreed rules for the
 * design system.
 */

val PublicSans = FontFamily(
    Font(R.font.public_sans_regular, FontWeight.Normal),
    Font(R.font.public_sans_semi_bold, FontWeight.SemiBold),
    Font(R.font.public_sans_bold, FontWeight.Bold)
)

val Roboto = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.SemiBold),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = PublicSans,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    h2 = TextStyle(
        fontFamily = PublicSans,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    h3 = TextStyle(
        fontFamily = PublicSans,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = PublicSans,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 26.sp,
        letterSpacing = (0.3).sp
    ),
    subtitle2 = TextStyle(
        fontFamily = PublicSans,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp,
        letterSpacing = (0.3).sp
    ),
    body1 = TextStyle(
        fontFamily = Roboto,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 26.sp,
        letterSpacing = 0.sp
    ),
    body2 = TextStyle(
        fontFamily = Roboto,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp,
        letterSpacing = 0.sp
    ),
    caption = TextStyle(
        fontFamily = Roboto,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        letterSpacing = (0.3).sp
    ),
    overline = TextStyle(
        fontFamily = Roboto,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    button = TextStyle(
        fontFamily = Roboto,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp,
        letterSpacing = 0.sp
    )
)

fun Typography.subtitle3() = TextStyle(
    fontFamily = PublicSans,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 23.sp,
    letterSpacing = 0.sp
)

fun Typography.body3() = TextStyle(
    fontFamily = Roboto,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 23.sp,
    letterSpacing = 0.sp
)

fun Typography.body4() = TextStyle(
    fontFamily = Roboto,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 23.sp,
    letterSpacing = 0.sp
)

fun Typography.tabs() = TextStyle(
    fontFamily = Roboto,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 23.sp,
    letterSpacing = (0.5).sp
)