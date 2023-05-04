package ai.powerup.stori.basedesign.compose.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

/**
 * Shapes
 *
 * The Shapes used when creating components that need rounded corners, these shapes has been created
 * according to the design system, please follow the guidelines and use this shapes when creating
 * a component that needs rounded corners.
 *
 */

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp)
)