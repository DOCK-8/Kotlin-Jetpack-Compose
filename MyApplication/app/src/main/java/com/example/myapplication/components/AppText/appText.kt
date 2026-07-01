package com.example.myapplication.components.AppText

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun appText(
    modifier : Modifier,
    type : AppTextType,
    size : AppTextSize,
    textName : String
    ){
        val apptextstyle : AppTextStyle = getAppTextStyle(type)
        val apptextsize : TextUnit = getAppTextSize(size)
        Text(
            text = textName,
            modifier = modifier,
            color = colorResource(id = apptextstyle.color),
            fontSize = apptextsize,
            fontWeight = FontWeight(apptextstyle.bold)
        )
}