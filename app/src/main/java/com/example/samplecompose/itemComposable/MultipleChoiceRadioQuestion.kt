package com.example.samplecompose.itemComposable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.samplecompose.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MultipleChoiceRadioQuestionPreview() {
    var selectedOption by remember { mutableStateOf<String?>(null) }

    MultipleChoiceRadioQuestion(
        question = "What is the capital of France?",
        options = listOf("Paris", "Berlin", "Madrid"),
        selectedOption = selectedOption,
        onOptionSelected = { selectedOption = it }
    )
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MultipleChoiceRadioQuestion(
    question: String,
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = question,
            color = colorResource(R.color.editFieldColor)
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable { onOptionSelected(option) }
                ) {
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { onOptionSelected(option) },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Blue
                        )
                    )
                    Text(text = option)
                }
            }
        }
    }
}
