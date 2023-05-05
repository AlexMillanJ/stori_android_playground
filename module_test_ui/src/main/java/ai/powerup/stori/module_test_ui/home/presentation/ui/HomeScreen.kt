package ai.powerup.stori.module_test_ui.home.presentation.ui

import ai.powerup.stori.basedesign.compose.utils.SetSystemBarsColor
import ai.powerup.stori.basedesign.compose.theme.White
import ai.powerup.stori.basedesign.R
import ai.powerup.stori.basedesign.compose.siahorroscomponents.field.TextFieldSiAhorros
import ai.powerup.stori.basedesign.compose.storicomponents.TextFieldStori
import ai.powerup.stori.basedesign.compose.superappcomponents.field.TextFieldSuperApp
import ai.powerup.stori.basedesign.compose.theme.GeneralGray900Black
import ai.powerup.stori.basedesign.compose.theme.Typography
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onSectionSelected: () -> Unit
) {
    SetSystemBarsColor(
        statusBarColor = White,
        navigationBarColor = White,
        isSystemDarkIcons = true
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                text = "Design System Showcase",
                style = Typography.h1,
                color = GeneralGray900Black,
                textAlign = TextAlign.Center
            )
            TextFieldSuperApp(
                hint = "Ingresa tu correo",
                elevatedHint = "Correo",
                helperText = "Ingresa un correo que tengo un correcto patron",
                fieldIcon = R.drawable.ic_close_16px,
                helperIcon = R.drawable.ic_actions_calendar_16px
            )

            TextFieldStori(
                hint = "Ingresa tu correo",
                elevatedHint = "Correo",
                helperText = "Ingresa un correo que tengo un correcto patron",
                fieldIcon = R.drawable.ic_close_16px,
                helperIcon = R.drawable.ic_actions_calendar_16px
            )

            TextFieldSiAhorros(
                hint = "Ingresa tu correo",
                elevatedHint = "Correo",
                helperText = "Ingresa un correo que tengo un correcto patron",
                fieldIcon = R.drawable.ic_close_16px,
                helperIcon = R.drawable.ic_actions_calendar_16px
            )

            TextFieldSuperApp(
                hint = "Ingresa tu correo",
                elevatedHint = "Correo",
                helperText = "Ingresa un correo que tengo un correcto patron"
            )

            TextFieldStori(
                hint = "Ingresa tu correo",
                elevatedHint = "Correo",
                helperText = "Ingresa un correo que tengo un correcto patron"
            )

            TextFieldSiAhorros(
                hint = "Ingresa tu correo",
                elevatedHint = "Correo",
                helperText = "Ingresa un correo que tengo un correcto patron"
            )

            TextFieldSuperApp(
                hint = "Ingresa tu correo",
                elevatedHint = "Correo",
                helperText = "Ingresa un correo que tengo un correcto patron"
            )

            TextFieldStori(
                hint = "Ingresa tu correo",
                elevatedHint = "Correo"
            )

            TextFieldSiAhorros(
                hint = "Ingresa tu correo",
                elevatedHint = "Correo"
            )

            TextFieldSuperApp(
                hint = "Ingresa tu correo",
                elevatedHint = "Correo",
                helperText = "Ingresa un correo que tengo un correcto patron",
                fieldIcon = R.drawable.ic_close_16px,
                helperIcon = R.drawable.ic_actions_calendar_16px,
                enableError = true
            )

            TextFieldStori(
                hint = "Ingresa tu correo",
                elevatedHint = "Correo",
                helperText = "Ingresa un correo que tengo un correcto patron",
                fieldIcon = R.drawable.ic_close_16px,
                helperIcon = R.drawable.ic_actions_calendar_16px,
                enabledField = false
            )
        }
    }
}