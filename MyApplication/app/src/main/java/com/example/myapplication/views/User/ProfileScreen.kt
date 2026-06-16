package com.example.myapplication.views.User

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.ViewModel.User.ProfileViewModel

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, navController: NavController? = null) {
    val viewModel: ProfileViewModel = viewModel()
    viewModel.getUserData("Usuario")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F0F))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Perfil",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // User section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .background(Color(0xFF1A1A1A)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "👤",
                    fontSize = 40.sp
                )
            }

            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = viewModel.getUserName(),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = viewModel.getUserEmail(),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFFB0B0B0)
                )
            }
        }

        Divider(
            modifier = Modifier.padding(vertical = 16.dp),
            color = Color(0xFF2D2D2D)
        )

        // Account section
        Text(
            text = "Cuenta",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ProfileRow("Suscripción", "Premium")
        ProfileRow("Estado", "Activo")
        ProfileRow("Miembro desde", "2024")

        Spacer(modifier = Modifier.height(32.dp))

        Divider(
            modifier = Modifier.padding(vertical = 16.dp),
            color = Color(0xFF2D2D2D)
        )

        // Settings section
        Text(
            text = "Configuración",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ToggleRow("Notificaciones", true)
        ToggleRow("Recomendaciones", true)
        ToggleRow("Recordar sesión", false)

        Spacer(modifier = Modifier.height(32.dp))

        Divider(
            modifier = Modifier.padding(vertical = 16.dp),
            color = Color(0xFF2D2D2D)
        )

        Text(
            text = "v1.0.0",
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xFF808080),
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
private fun ProfileRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFFB0B0B0)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
    }
}

@Composable
private fun ToggleRow(label: String, enabled: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFFB0B0B0)
        )
        Text(
            text = if (enabled) "On" else "Off",
            style = MaterialTheme.typography.bodySmall,
            color = if (enabled) Color(0xFFFF6B35) else Color(0xFF808080)
        )
    }
}