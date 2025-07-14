package com.example.samplecompose.itemComposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.compose.rememberNavController
import com.example.samplecompose.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AlertDialogPreview() {
    val navController = rememberNavController()
    AlertDialog(
        description = "Demo Description",
        showDialog = true,
        onDismiss = {

        },
    )
}


@Composable
fun AlertDialog(
    description: String,
    showDialog: Boolean,
    onDismiss: () -> Unit,
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = { /* Do nothing to prevent dismiss on outside touch */ },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Top Center Icon
                    Image(
                        painter = painterResource(id = R.drawable.alert_icon),
                        contentDescription = "Info Icon",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(bottom = 8.dp),
                    )

                    // Heading
                    Text(
                        text = "Alert",
                        fontFamily = FontFamily(Font(R.font.medium)),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Description Text
                    Text(
                        text = description,
                        fontFamily = FontFamily(Font(R.font.regular)),
                        fontSize = 16.sp,
                        modifier = Modifier.padding(vertical = 8.dp),
                        textAlign = TextAlign.Center
                    )

                    // Yes/No Buttons
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = onDismiss,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.mainColor)
                            ),
                            shape = RoundedCornerShape(12.dp),
                        ) {
                            Text("OK")
                        }
                    }
                }
            }
        }
    }
}
