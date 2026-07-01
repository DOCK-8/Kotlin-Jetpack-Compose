package com.example.myapplication.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.myapplication.R
import com.example.myapplication.components.AppText.appText
import com.example.myapplication.components.AppIcon.appIcon
import com.example.myapplication.components.AppText.AppTextSize.Medium
import com.example.myapplication.components.AppText.AppTextType.SplashAppName
import com.example.myapplication.components.AppText.AppTextSize.Small
import com.example.myapplication.components.AppText.AppTextType.SplashPhrase
import com.example.myapplication.components.AppIcon.AppIconType.SplashApp

@Composable
fun SplashScreen (){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.splash_1),
            contentDescription = "Splash Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize() 
                .blur(
                    radiusX = 10.dp,
                    radiusY = 10.dp,
                    edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
                )
        )
        Box(modifier = Modifier.fillMaxSize().background(colorResource( id = R.color.blackTransparent )))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxHeight(0.4f)
        ){
            appIcon(
                modifier = Modifier,
                type = SplashApp,
                iconDescription = "Splash Icon"
            )
            appText(
                textName = "WATCHMAN",
                modifier = Modifier,
                size = Medium,
                type = SplashAppName
            )
            appText(
                textName = "Why we don't watch this ?",
                modifier = Modifier,
                size = Small,
                type = SplashPhrase
            )
        }
    }
}