package com.example.myapplication.builders

sealed  class TextFieldType {
    object Text : TextFieldType()
    object Password : TextFieldType()
}
sealed class TextFieldSize {
    object Small : TextFieldSize()
    object Medium : TextFieldSize()
    object Large : TextFieldSize()
}
sealed cl