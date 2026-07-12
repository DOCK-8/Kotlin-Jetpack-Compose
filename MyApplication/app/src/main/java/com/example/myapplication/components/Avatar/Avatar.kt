package com.example.myapplication.components.Avatar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

import androidx.compose.foundation.Image
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.shape.CircleShape

import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset

import androidx.compose.material3.Button
import androidx.compose.material3.Icon

import com.example.myapplication.R
import com.example.myapplication.components.ButtonCustom.ButtonCustom
import com.example.myapplication.components.ButtonCustom.ButtonCustomType.EditProfile

@Composable
fun Avatar(){
    Box(
        modifier = Modifier.size(220.dp),
    ){
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
                .border(
                    width = 5.dp,
                    color = colorResource(R.color.avatarBorderLight),
                    shape = CircleShape
                )
                .dropShadow(
                shape = CircleShape,
                shadow = Shadow(
                    radius = 24.dp,
                    spread = 10.dp,
                    color = colorResource(R.color.avatarShadowLight),
                    offset = DpOffset(0.dp, 6.dp)
                    )
                )
                .clip(CircleShape)
        )
        ButtonCustom(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            name = "",
            type = EditProfile
        ){}
    }
}