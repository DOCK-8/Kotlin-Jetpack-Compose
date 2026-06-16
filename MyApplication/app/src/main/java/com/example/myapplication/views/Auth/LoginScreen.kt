package com.example.myapplication.views.Auth

import androidx.compose.runtime.Composable
// Components
import com.example.myapplication.components.SingleButton
// End
// Route
import com.example.myapplication.navigate.Route
// End
// ViewModel
import com.example.myapplication.ViewModel.Auth.LoginViewModel
import com.example.myapplication.session.SessionManager
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
// End
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.navigation.NavController



@Composable
fun LoginScreen(navController : NavController){
    val viewModel : LoginViewModel = viewModel()
    val _name by viewModel.name.collectAsState()
    val _password by viewModel.password.collectAsState()
    val _message by viewModel.message.collectAsState()
    Column{
        Text(_message)
        TextField(
            value = _name,
            onValueChange = { it -> viewModel.onValueName(it) },
            label = { Text("Label") }
        )
        TextField(
            value = _password,
            onValueChange = { it -> viewModel.onValuePassword(it) },
            label = { Text("Label") }
        )
        SingleButton(
            //modifier = Modifier,
            text = "Login",
        ){
            if(viewModel.loginUser())
                SessionManager.login()
        }
        SingleButton(
            //modifier = Modifier,
            text = "Registrarse",
        ){
            navController.navigate(Route.Register.nameRoute)
        }
    }    
}