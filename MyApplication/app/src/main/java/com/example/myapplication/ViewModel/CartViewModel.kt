package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.models.data.MovieDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow<List<MovieDetails>>(emptyList())
    val cartItems: StateFlow<List<MovieDetails>> = _cartItems.asStateFlow()

    fun addToCart(movie: MovieDetails) {
        val currentCart = _cartItems.value.toMutableList()
        if (!currentCart.any { it.id == movie.id }) {
            currentCart.add(movie)
            _cartItems.value = currentCart
        }
    }

    fun removeFromCart(movieId: String) {
        val currentCart = _cartItems.value.toMutableList()
        currentCart.removeAll { it.id == movieId }
        _cartItems.value = currentCart
    }

    fun clearCart() {
        _cartItems.value = emptyList()
    }

    fun getTotalPrice(): Double {
        return _cartItems.value.sumOf { it.budget?.toDouble() ?: 9.99 }
    }

    fun getItemCount(): Int = _cartItems.value.size
}
