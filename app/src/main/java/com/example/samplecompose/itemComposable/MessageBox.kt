package com.example.samplecompose.itemComposable
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.samplecompose.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MessageBoxPreview() {
    MessageBox("Purpose of Visit & Observation", 300) {
    }
}

@Composable
fun MessageBox(
    messageHeading: String,
    charLimit: Int,
    onValueChange: (String) -> Unit,
) {
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(5.dp))
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = messageHeading,
               fontFamily = FontFamily(Font(R.font.medium)),
                color = Color.Gray,
                fontSize = 14.sp
            )
            Text(
                text = "${message.length} / $charLimit",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = (charLimit / 6).dp)
                .padding(4.dp)
        ){
            BasicTextField(
                value = message,
                onValueChange = {
                    if (it.length <= charLimit) {
                        message = it
                        onValueChange(it)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black
                ),
                decorationBox = { innerTextField ->
                    if (message.isEmpty()) {
                        Text(
                            text = "Enter your message...",
                            color = Color.LightGray,
                            fontSize = 14.sp
                        )
                    }
                    innerTextField()
                }
            )
        }

    }
}
