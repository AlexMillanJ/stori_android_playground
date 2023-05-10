package ai.powerup.stori.module_test_ui.home.presentation.ui

import ai.powerup.stori.basedesign.compose.utils.SetSystemBarsColor
import ai.powerup.stori.basedesign.compose.theme.white
import ai.powerup.stori.basedesign.R
import ai.powerup.stori.basedesign.compose.basecomponents.button.ButtonText
import ai.powerup.stori.basedesign.compose.siahorroscomponents.field.DropdownSiAhorros
import ai.powerup.stori.basedesign.compose.siahorroscomponents.field.TextFieldSiAhorros
import ai.powerup.stori.basedesign.compose.storicomponents.field.DropdownStori
import ai.powerup.stori.basedesign.compose.storicomponents.field.TextFieldStori
import ai.powerup.stori.basedesign.compose.superappcomponents.field.DropdownSuperApp
import ai.powerup.stori.basedesign.compose.superappcomponents.field.TextFieldSuperApp
import ai.powerup.stori.basedesign.compose.theme.general_gray_900_black
import ai.powerup.stori.basedesign.compose.theme.Typography
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    SetSystemBarsColor(
        statusBarColor = white,
        navigationBarColor = white,
        isSystemDarkIcons = true
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
            .padding(horizontal = 16.dp)
    ) {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(white)
                .verticalScroll(rememberScrollState())
                .imePadding()
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            var superAppTextState by rememberSaveable { mutableStateOf("") }
            var storiTextState by rememberSaveable() { mutableStateOf("") }
            var siAhorrosTextState by rememberSaveable() { mutableStateOf("") }
            var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
            val suggestions = listOf("Item1","Item2","Item3")

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = "Design System Showcase",
                style = Typography.h1,
                color = general_gray_900_black,
                textAlign = TextAlign.Center
            )

            TextFieldSuperApp(
                text = superAppTextState,
                hint = "Ingresa tu correo",
                elevatedHint = "Correo",
                helperText = "Ingresa tu correo personal",
                trailingIcon = R.drawable.ic_close_16px,
                helperIcon = R.drawable.ic_actions_calendar_16px,
                trailingIconAction = { superAppTextState = "" },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                onTextChange = { superAppTextState = it }
            )

            TextFieldStori(
                text = storiTextState,
                hint = "Ingresa tu contraseña",
                elevatedHint = "Cotraseña",
                helperText = "Ingresa tu contraseña personal",
                trailingIcon = R.drawable.ic_basics_view_16px,
                helperIcon = R.drawable.ic_actions_calendar_16px,
                trailingIconAction = { isPasswordVisible = isPasswordVisible.not() },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation =
                if (isPasswordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                onTextChange = {storiTextState = it }
            )

            TextFieldSiAhorros(
                text = siAhorrosTextState,
                hint = "Ingresa tu número télefonico",
                elevatedHint = "Telefono",
                helperText = "Ingresa tu número teléfonico personal",
                trailingIcon = R.drawable.ic_close_16px,
                helperIcon = R.drawable.ic_actions_calendar_16px,
                trailingIconAction = { siAhorrosTextState = "" },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                onTextChange = { siAhorrosTextState = it }
            )

            DropdownSuperApp(
                hint = "Seleccione una opción",
                elevatedHint = "Opción",
                items = suggestions,
                enableError = true,
                errorMessage = "Esto es una prueba de error"
            )

            DropdownStori(
                hint = "Seleccione una opción",
                elevatedHint = "Opción",
                items = suggestions,
                enableError = true,
                errorMessage = "Esto es una prueba de error"
            )

            DropdownSiAhorros(
                hint = "Seleccione una opción",
                elevatedHint = "Opción",
                items = suggestions,
                enableError = true,
                errorMessage = "Esto es una prueba de error"
            )

            ButtonText(text = "Prueba de Textbutton", enabled = true) {}
        }
    }
}