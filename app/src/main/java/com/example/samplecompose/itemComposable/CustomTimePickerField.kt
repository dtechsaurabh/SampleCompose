package com.example.samplecompose.itemComposable
import android.app.TimePickerDialog
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import java.util.Calendar


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomTimePickerFieldPreview() {
    CustomTimePickerField("In Time") {

    }
}

@Composable
fun CustomTimePickerField(
    label: String,
    onDateSelected: (String) -> Unit
) {
    var selectedTime by remember { mutableStateOf("") }
    var showModal by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = selectedTime,
        onValueChange = {},
        label = { Text(label) },
        placeholder = { Text("HH:MM AM/PM") },
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                awaitEachGesture {
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if (upEvent != null) {
                        showModal = true
                    }
                }
            }
    )

    if (showModal) {
        TimePickerModal(
            onTimeSelected = {
                selectedTime = it ?: ""
                onDateSelected(selectedTime)
                showModal = false
            },
            onDismiss = { showModal = false }
        )
    }
}

@Composable
fun TimePickerModal(
    onTimeSelected: (String?) -> Unit,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    // Show the TimePickerDialog
    LaunchedEffect(Unit) {
        TimePickerDialog(
            context,
            { _, selectedHour, selectedMinute ->
                val hour12 = if (selectedHour % 12 == 0) 12 else selectedHour % 12
                val amPm = if (selectedHour < 12) "AM" else "PM"
                val formattedTime = String.format("%02d:%02d %s", hour12, selectedMinute, amPm)
                onTimeSelected(formattedTime)
            },
            hour,
            minute,
            false
        ).show()
    }
}
