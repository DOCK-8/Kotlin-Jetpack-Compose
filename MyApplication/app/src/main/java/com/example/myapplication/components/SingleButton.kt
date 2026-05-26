package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.shadow
import com.example.myapplication.builders.SingleButtonColor
import com.example.myapplication.builders.SingleButtonDimension
import com.example.myapplication.builders.SingleButtonForm
import com.example.myapplication.builders.SingleButtonSize
import com.example.myapplication.builders.SingleButtonType
import com.example.myapplication.builders.getSingleButtonColors
import com.example.myapplication.builders.getSingleButtonFontSize
import com.example.myapplication.builders.getSingleButtonDimension
import com.example.myapplication.R

@Composable
fun SingleButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    type: SingleButtonType = SingleButtonType.Play,
    form: SingleButtonForm = SingleButtonForm.Rectangle,
    size: SingleButtonSize = SingleButtonSize.Medium,
    icon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val buttonColors : SingleButtonColor = getSingleButtonColors(type)
    val buttonDimension : SingleButtonDimension = getSingleButtonDimension(form ,size)
    val shape = buttonDimension.shape
    val buttonFontSize : TextUnit = getSingleButtonFontSize(size)

    val actualModifier = modifier
        /*
        * Borde : I don't like how it looks
        .border(
            border = BorderStroke(1.dp, if (enabled) Color.DarkGray else Color.LightGray),
            shape = shape 
        )
        */
        .padding(3.dp)
        .fillMaxWidth(buttonDimension.width)
        .aspectRatio(buttonDimension.width / buttonDimension.height)
        .shadow( 
            elevation = 20.dp,
            shape = CircleShape,
            ambientColor = Color.White.copy(alpha = 0.3f),
            spotColor = Color.White.copy(alpha = 0.3f)) 
            
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) buttonColors.backgroundColor else Color.Gray,
        ),
        modifier = actualModifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.play),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        text?.let{
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = it,
                color = if (enabled) buttonColors.contentColor else buttonColors.contentColor.copy(alpha = 0.5f),
                fontSize = buttonFontSize
            )
        }
    }
}