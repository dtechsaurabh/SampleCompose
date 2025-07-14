//package com.example.samplecompose.item
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.IntrinsicSize
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.text.font.Font
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.samplecompose.R
//import com.urwayittech.colt.service.ui.ReportHistoryData
//import com.urwayittech.colt.service.ui.service.ServiceClient
//
//
//@Composable
//fun ReportHistorySearchResultItem(client: ReportHistoryData, onclick: () -> Unit) {
//    val mediumFont = FontFamily(Font(R.font.medium))
//    val regularFont = FontFamily(Font(R.font.regular))
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 20.dp, vertical = 5.dp)
//            .clickable(
//                indication = null, // disables ripple animation
//                interactionSource = remember { MutableInteractionSource() },
//                onClick = { onclick() }
//            ),
//        elevation = CardDefaults.cardElevation(3.dp),
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        shape = RoundedCornerShape(8.dp),
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(IntrinsicSize.Min),
//            verticalAlignment = Alignment.CenterVertically,
//        ) {
//
//            Box(
//                modifier = Modifier
//                    .width(80.dp)
//                    .fillMaxHeight()
//                    .background(colorResource(R.color.mainColor)),
//                contentAlignment = Alignment.Center
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    Text(
//                        text = "Client Id",
//                        color = colorResource(R.color.white),
//                        fontSize = 14.sp,
//                        fontFamily = mediumFont,
//                        textAlign = TextAlign.Center
//                    )
//                    Text(
//                        text = client.expid.toString(),
//                        color = colorResource(R.color.white),
//                        fontSize = 14.sp,
//                        fontFamily = mediumFont,
//                        textAlign = TextAlign.Center
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.width(10.dp))
//
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(
//                    text = client.txt_genuie_parts,
//                    fontFamily = mediumFont,
//                    fontSize = 16.sp,
//                    maxLines = 2,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier
//                        .padding(bottom = 4.dp)
//                        .fillMaxWidth()
//                )
//
//                Text(
//                    text = client.txt_remarks_if_any,
//                    fontFamily = regularFont,
//                    fontSize = 16.sp,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier
//                        .padding(bottom = 4.dp)
//                        .fillMaxWidth()
//                )
//            }
//        }
//
//    }
//
//}
