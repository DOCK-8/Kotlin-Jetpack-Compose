package com.example.myapplication.components.ButtonCustom


import androidx.compose.runtime.Composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource

import com.example.myapplication.components.AppIcon.appIcon
import com.example.myapplication.R

@Composable
fun ButtonCustom(
    modifier : Modifier,
    name : String = "",
    type : ButtonCustomType,
    clickFun : () -> Unit
){

    val style = getButtonStyle(type)
    val dimention = getButtonDimention(type)
    Button(
        modifier = modifier
        .size(width = dimention.width, height =dimention.height)
        .border(
            width = dimention.borderSize,
            color = colorResource(style.borderColor)
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(style.backgroundColor)
        ),
        contentPadding = PaddingValues(dimention.paddingSize),
        onClick = clickFun
    ){
        appIcon(
            modifier = Modifier
            .fillMaxSize(),
            type = getIconType(type),
            iconDescription = "Icon $name"
        )
        Text(
            text = name
        )
    }
}