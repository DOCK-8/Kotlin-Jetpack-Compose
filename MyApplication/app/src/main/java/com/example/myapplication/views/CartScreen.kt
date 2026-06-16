package com.example.myapplication.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.ViewModel.CartViewModel

@Composable
fun CartScreen(navController: NavController? = null, modifier: Modifier = Modifier){
    val vm: CartViewModel = viewModel()
    val cartItems by vm.cartItems.collectAsState()
    val totalPrice = vm.getTotalPrice()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F0F))
    ){
        // Header
        Text(
            text = "Carrito",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 32.sp,
            modifier = Modifier.padding(16.dp)
        )

        if (cartItems.isEmpty()) {
            // Empty state
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Carrito vacío",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Agrega películas para comenzar",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFFB0B0B0)
                    )
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize()
            ){
                // Cart items list
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(cartItems) { movie ->
                        CartItemCard(
                            title = movie.primaryTitle,
                            year = movie.startYear.toString(),
                            onRemove = {
                                vm.removeFromCart(movie.id)
                            }
                        )
                    }
                }

                Divider(
                    modifier = Modifier
                        .padding(16.dp),
                    color = Color(0xFF2D2D2D)
                )

                // Summary
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
                ){
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text("Total:", style = MaterialTheme.typography.bodyMedium)
                            Text(
                                "$${String.format("%.2f", totalPrice * 1.1)}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xFFFF6B35)
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ){
                            Button(
                                onClick = { vm.clearCart() },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(48.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF2D2D2D)
                                )
                            ){
                                Text("Vaciar")
                            }

                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(48.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFFF6B35)
                                )
                            ){
                                Text("Comprar", color = Color.White)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun CartItemCard(
    title: String,
    year: String,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(0.15f)
                    .background(Color(0xFF2D2D2D)),
                contentAlignment = Alignment.Center
            ){
                Text("🎬", fontSize = 24.sp)
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ){
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2
                )
                Text(
                    text = year,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(0xFFB0B0B0)
                )
            }

            IconButton(
                onClick = onRemove,
                modifier = Modifier
                    .height(40.dp)
            ){
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Eliminar",
                    tint = Color(0xFFFF6B35)
                )
            }
        }
    }
}