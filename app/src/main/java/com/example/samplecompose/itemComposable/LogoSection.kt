package com.example.samplecompose.itemComposable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecompose.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LogoSection() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()

    ) {
        Image(
            painter = painterResource(id = R.drawable.drop_down_in_icon),
            contentDescription = "App Logo",
            modifier = Modifier.size(150.dp)
        )
    }

}