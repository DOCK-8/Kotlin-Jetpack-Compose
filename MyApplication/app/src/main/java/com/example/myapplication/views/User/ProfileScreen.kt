package com.example.myapplication.views.User

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
// VM
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ViewModel.User.ProfileViewModel
// End

@Composable
fun ProfileScreen() {
    val viewModel : ProfileViewModel = viewModel()
    viewModel.getUserData("Loki")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {

            Column(
                modifier = Modifier.padding(24.dp)
            ) {

                Text(
                    text = "👤 Mi Perfil",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                ProfileItem(
                    title = "Nombre",
                    value = viewModel.getUserName()
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                ProfileItem(
                    title = "Email",
                    value = viewModel.getUserEmail() 
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                ProfileItem(
                    title = "Estado",
                    value = "Activo"
                )
            }
        }
    }
}

@Composable
private fun ProfileItem(
    title: String,
    value: String
) {

    Column {

        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}