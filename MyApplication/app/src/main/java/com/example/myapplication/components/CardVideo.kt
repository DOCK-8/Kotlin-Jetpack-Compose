package com.example.myapplication.components

import androidx.compose.runtime.Composable
import com.example.myapplication.components.SingleButton
import com.example.myapplication.builders.SingleButtonType
import com.example.myapplication.builders.SingleButtonForm
import com.example.myapplication.builders.SingleButtonSize
import com.example.myapplication.builders.getCardVideoColors
import com.example.myapplication.builders.getCardVideoDimensions
import com.example.myapplication.builders.CardVideoColor
import com.example.myapplication.builders.CardVideoDimension
import com.example.myapplication.builders.CardVideoForm
import com.example.myapplication.builders.CardVideoSize
import com.example.myapplication.builders.CardVideoType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
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
import androidx.compose.foundation.clickable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
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
    duration : Double? = null,
    onClick : () -> Unit
){
    val padding = 8.dp
    val cardVideoColor : CardVideoColor = getCardVideoColors(type)
    val cardVideoDimensions : CardVideoDimension = getCardVideoDimensions(form, size)
    val actualModifier : Modifier = modifier
        .padding(padding)
        .fillMaxWidth(cardVideoDimensions.width)
        .aspectRatio(cardVideoDimensions.aspectRatio)
        .clip(cardVideoDimensions.shape)
    // Select drawable based on form (fallbacks)
    val idI : Int = when(form){
        CardVideoForm.Square -> R.drawable.test
        CardVideoForm.Rectangle -> R.drawable.testh
    }

    Card(
        modifier = actualModifier.clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = cardVideoDimensions.shape,
        colors = CardDefaults.cardColors(containerColor = cardVideoColor.backgroundColor),
        border = BorderStroke(1.dp, cardVideoColor.borderColor)
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = idI),
                contentDescription = "Card Video Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Bottom overlay for text
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth(),
                color = Color.Black.copy(alpha = 0.45f)
            ){
                Column(modifier = Modifier.padding(8.dp)){
                    title?.let {
                        Text(text = title, style = MaterialTheme.typography.titleMedium, color = Color.White)
                    }
                    description?.let {
                        Text(text = description, style = MaterialTheme.typography.bodySmall, color = Color.White)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Ranking",
                        )
                        ranking?.let {
                            Text(text = String.format("%.1f", it), color = Color.White)
                        }
                        Spacer(modifier = Modifier.size(8.dp))
                        duration?.let {
                            Text(text = "${it.toInt()} min", color = Color.White)
                        }
                    }
                }
            }

            if (form == CardVideoForm.Rectangle) {
                SingleButton(
                    text = "Play",
                    type = SingleButtonType.Watch,
                    form = SingleButtonForm.Rectangle,
                    size = SingleButtonSize.Small,
                    modifier = Modifier.align(Alignment.BottomEnd).padding(8.dp)
                ){}
            }
        }
    }
}