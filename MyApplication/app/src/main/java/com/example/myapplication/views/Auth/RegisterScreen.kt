package com.example.myapplication.views.Auth

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
// Components
import com.example.myapplication.components.SingleButton
// End
// VM
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ViewModel.Auth.RegisterViewModel
// End
// DB
import com.example.myapplication.models.DB
// End

@Composable
fun RegisterScreen(){
    val viewModel : RegisterViewModel = viewModel()
    LazyColumn{
        item{
            TextField(
                state = rememberTextFieldState(initialText = "Hello"),
                label = {Text("Nombre de Usurio")}
            )
        }
        item{
            TextField(
                state = rememberTextFieldState(initialText = "Hello"),
                label = {Text("Password")}
            ) 
        }
        item{
            SingleButton(text = "Registrar"){
                viewModel.onRegisterUser()
            }
        }
        items(DB.listUsuarios){i ->
            Text("${i.name} - ${i.email} - ${i.password}")
        }
    }
}