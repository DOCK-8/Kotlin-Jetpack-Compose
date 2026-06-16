package com.example.myapplication.views.Auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.ViewModel.Auth.LoginViewModel
import com.example.myapplication.session.SessionManager
import com.example.myapplication.navigate.Route

@Composable
fun LoginScreen(navController: NavController){
    val viewModel: LoginViewModel = viewModel()
    val _name by viewModel.name.collectAsState()
    val _password by viewModel.password.collectAsState()
    val _message by viewModel.message.collectAsState()
    var isLoading by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F0F))
            .verticalScroll(rememberScrollState())
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            // Header
            Text(
                text = "Cinemax",
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 40.sp,
                color = Color(0xFFFF6B35),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Acceso a miles de películas",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFB0B0B0),
                modifier = Modifier.padding(bottom = 48.dp)
            )

            // Login Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ){
                    // Email field
                    OutlinedTextField(
                        value = _name,
                        onValueChange = { viewModel.onValueName(it) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        label = { Text("Email o Usuario") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Email,
                                contentDescription = null,
                                tint = Color(0xFFFF6B35)
                            )
                        },
                        enabled = !isLoading,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFFF6B35),
                            unfocusedBorderColor = Color(0xFF2D2D2D),
                            focusedLabelColor = Color(0xFFFF6B35),
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color(0xFFB0B0B0)
                        ),
                        singleLine = true
                    )

                    // Password field
                    OutlinedTextField(
                        value = _password,
                        onValueChange = { viewModel.onValuePassword(it) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        label = { Text("Contraseña") },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Lock,
                                contentDescription = null,
                                tint = Color(0xFFFF6B35)
                            )
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        enabled = !isLoading,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFFF6B35),
                            unfocusedBorderColor = Color(0xFF2D2D2D),
                            focusedLabelColor = Color(0xFFFF6B35),
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color(0xFFB0B0B0)
                        ),
                        singleLine = true
                    )

                    // Message
                    if(_message.isNotEmpty()){
                        Text(
                            text = _message,
                            style = MaterialTheme.typography.bodySmall,
                            color = if(_message.contains("Error", ignoreCase = true))
                                Color(0xFFFF4444) else Color(0xFF4CAF50),
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }

                    // Login Button
                    Button(
                        onClick = {
                            if(_name.isNotEmpty() && _password.isNotEmpty()) {
                                isLoading = true
                                try {
                                    val loginSuccess = viewModel.loginUser()
                                    if(loginSuccess) {
                                        SessionManager.login()
                                        // El RootNavigation se actualizará automáticamente
                                    }
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                } finally {
                                    isLoading = false
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(top = 8.dp),
                        enabled = !isLoading && _name.isNotEmpty() && _password.isNotEmpty(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF6B35),
                            disabledContainerColor = Color(0xFFB0B0B0)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ){
                        if(isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(24.dp),
                                color = Color.White,
                                strokeWidth = 2.dp
                            )
                        } else {
                            Text(
                                text = "Acceder",
                                style = MaterialTheme.typography.labelLarge,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            // Divider
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Divider(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp),
                    color = Color(0xFF2D2D2D)
                )
                Text(
                    text = "O",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFFB0B0B0),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
                Divider(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp),
                    color = Color(0xFF2D2D2D)
                )
            }

            // Register Button
            Button(
                onClick = {
                    navController.navigate(Route.Register.nameRoute)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                enabled = !isLoading,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2D2D2D),
                    disabledContainerColor = Color(0xFF1A1A1A)
                ),
                shape = RoundedCornerShape(8.dp)
            ){
                Text(
                    text = "Crear Cuenta",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color(0xFFFF6B35)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Continuar como invitado",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFFB0B0B0),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}