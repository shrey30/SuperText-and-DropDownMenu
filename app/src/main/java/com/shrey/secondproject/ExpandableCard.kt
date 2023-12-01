package com.shrey.secondproject

import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.ContentAlpha

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(){
    var expandedstate by remember {
        mutableStateOf(false)
    }
    var expState by remember {
        mutableStateOf(false)
    }
    Column {
        Surface(modifier = Modifier
            .weight(2f),
            color = Color(0xFFf4acb7)//color of upper surface
        ) {
            Row(modifier = Modifier
                .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Card(modifier = Modifier
                    .width(300.dp)
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = LinearOutSlowInEasing
                        )
                    )
                    .border(
                        BorderStroke(3.dp, color = Color(0xFF000000)),
                        RoundedCornerShape(20.dp)
                    ),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {expandedstate = !expandedstate},
                ) {
                    Column() {
                        Row (modifier = Modifier
                            .padding(12.dp), verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(text = "Superscript",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .weight(6f)
                                    .alpha(1f)//Opacity of Text
                                , maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            IconButton(
                                modifier = Modifier // Apply modifier to IconButton
                                    .alpha(1f)
                                    .weight(1f)
                                    .rotate(if (expandedstate) 180f else 0f),
                                onClick = { expandedstate = !expandedstate },//rotation of the arrow
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Drop down arrow",
                                )
                            }

                        }
                        if (expandedstate == true) {

                                Text(
                                    text = buildAnnotatedString { withStyle(SpanStyle(fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold))
                                    {
                                        append("Hello")
                                    }
                                    withStyle(
                                        SpanStyle(fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        baselineShift = BaselineShift(0.5f)
                                        )){
                                        append("Everyone")
                                    }
                                    },
                                    modifier = Modifier.padding(10.dp))

                        }
                    }
                }
            }
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp), color = Color(0xFF000000)
        )
        Surface(modifier = Modifier
            .weight(2f),
            color = Color(0xFFfec89a)
        ) {
            Row(modifier = Modifier
                .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Card(modifier = Modifier
                    .width(300.dp)
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = LinearOutSlowInEasing
                        )
                    )
                    .border(
                        BorderStroke(3.dp, color = Color(0xFF000000)),
                        RoundedCornerShape(20.dp)
                    ),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {expState = !expState},
                ) {
                    Column() {
                        Row (modifier = Modifier
                            .padding(12.dp), verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(text = "Subscript",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .weight(6f)
                                    .alpha(1f)//Opacity of Text
                                , maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            IconButton(
                                modifier = Modifier // Apply modifier to IconButton
                                    .alpha(1f)
                                    .weight(1f)
                                    .rotate(if (expState) 180f else 0f),
                                onClick = { expState = !expState },//openeing and closing of DropDownMenu
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Drop down arrow",
                                )
                            }

                        }
                        if (expState == true) {

                            Text(
                                text = buildAnnotatedString { withStyle(SpanStyle(fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold))
                                {
                                    append("Hello")
                                }
                                    withStyle(
                                        SpanStyle(fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            baselineShift = BaselineShift(-0.5f)
                                        )){
                                        append("Everyone")
                                    }
                                },
                                modifier = Modifier.padding(10.dp))

                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ExpandadbleCardPreview(){
    ExpandableCard()
}