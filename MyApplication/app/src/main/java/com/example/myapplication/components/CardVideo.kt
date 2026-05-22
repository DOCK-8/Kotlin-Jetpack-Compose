package com.example.myapplication.components

import androidx.compose.runtime.Composable
//falta terminar
import com.example.myapplication.builders.getCardVideoColors
import com.example.myapplication.builders.getCardVideoDimensions
import com.example.myapplication.builders.CardVideoColor
import com.example.myapplication.builders.CardVideoDimension
import com.example.myapplication.builders.CardVideoForm
import com.example.myapplication.builders.CardVideoSize
import com.example.myapplication.builders.CardVideoType
import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import com.example.myapplication.R

@Composable
fun CardVideo(
    modifier : Modifier = Modifier,
    type : CardVideoType = CardVideoType.Anime,
    form : CardVideoForm = CardVideoForm.Square,
    size : CardVideoSize = CardVideoSize.Medium,
    img : Int? = null,
    title : String? = null,
    description : String? = null,
    ranking : Double? = null,
    duration : Double? = null
){
    val padding = 8.dp
    val cardVideoColor : CardVideoColor = getCardVideoColors(type)
    val cardVideoDimensions : CardVideoDimension = getCardVideoDimensions(form, size)
    val actualModifier : Modifier = modifier.
        padding(padding).
        border(3.dp, cardVideoColor.borderColor, cardVideoDimensions.shape).
        background(cardVideoColor.backgroundColor).
        fillMaxWidth(cardVideoDimensions.width).
        aspectRatio(cardVideoDimensions.aspectRatio).
        clip(cardVideoDimensions.shape)
    Box(
        modifier = actualModifier){
        Image(
            painter = painterResource(id = R.drawable.test),
            contentDescription = "Card Video Image",
            modifier = modifier.fillMaxWidth()
        )
        Column(
            modifier = modifier.
                align(Alignment.BottomEnd).
                fillMaxWidth()
        ){
            title?.let {
                Text(text = title)
            }
            Spacer(modifier = modifier.size(2.dp))
            description?.let {
                Text(text = description)
            }
            Row{
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Ranking",
                )
                ranking?.let {
                    Text(text = ranking.toString())
                }
                Spacer(modifier = modifier.size(2.dp))
                duration?.let {
                    Text(text = duration.toString())
                }
            }
        }
    }
}