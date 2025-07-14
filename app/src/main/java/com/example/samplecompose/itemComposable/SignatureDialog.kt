package com.example.samplecompose.itemComposable
import android.graphics.Bitmap
import android.graphics.Canvas as AndroidCanvas
import android.graphics.Color as AndroidColor
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignatureDialogPreview() {
    var showDialog by remember { mutableStateOf(true) }

    SignatureDialog(
        showDialog  = showDialog,
        onDismiss = {showDialog = false },
        onSignaturesCaptured = { sig1, sig2 ->
            showDialog = false
        }
    )

}


@Composable
fun SignatureDialog(
    showDialog : Boolean,
    onDismiss: () -> Unit,
    onSignaturesCaptured: (Bitmap, Bitmap) -> Unit
) {
    val context = LocalContext.current

    val path1 = remember { mutableStateOf(Path()) }
    val path2 = remember { mutableStateOf(Path()) }

    val points1 = remember { mutableStateListOf<Offset>() }
    val points2 = remember { mutableStateListOf<Offset>() }

    if (showDialog){
        points1.clear()
        points2.clear()
        Dialog(onDismissRequest = onDismiss) {
            Surface(
                shape = MaterialTheme.shapes.large,
                tonalElevation = 4.dp,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Text("Customer Signature", style = MaterialTheme.typography.titleMedium)
                    SignaturePad(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .border(1.dp, Color.Gray),
                        pathState  = path1,
                        points = points1
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text("Service Engineer Signature", style = MaterialTheme.typography.titleMedium)
                    SignaturePad(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .border(1.dp, Color.Gray),
                        pathState  = path2,
                        points = points2
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(onClick = onDismiss) {
                            Text("Cancel")
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(onClick = {
                            val bitmap1 = drawSignatureToBitmap(points1)
                            val bitmap2 = drawSignatureToBitmap(points2)
                            onSignaturesCaptured(bitmap1, bitmap2)
                        }) {
                            Text("Submit")
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun SignaturePad(
    modifier: Modifier = Modifier,
    pathState: MutableState<Path>,
    points: MutableList<Offset>
) {
    val currentPath = pathState.value

    Canvas(modifier = modifier.clipToBounds()
        .pointerInput(Unit) {
            detectDragGestures(
                onDragStart = { offset ->
                    points.add(offset)
                    val newPath = Path().apply {
                        addPath(currentPath) // retain previous path
                        moveTo(offset.x, offset.y)
                    }
                    pathState.value = newPath
                },
                onDrag = { change, _ ->
                    val newOffset = change.position
                    points.add(newOffset)
                    val newPath = Path().apply {
                        addPath(pathState.value)
                        lineTo(newOffset.x, newOffset.y)
                    }
                    pathState.value = newPath
                }
            )
        }
    ) {
        drawPath(pathState.value, color = Color.Black, style = Stroke(width = 4f))
    }
}


fun drawSignatureToBitmap(points: List<Offset>): Bitmap {
    val width = 800
    val height = 400
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = AndroidCanvas(bitmap)
    val paint = Paint().apply {
        color = AndroidColor.BLACK
        strokeWidth = 5f
        style = Paint.Style.STROKE
    }

    if (points.isNotEmpty()) {
        for (i in 1 until points.size) {
            val start = points[i - 1]
            val end = points[i]
            canvas.drawLine(start.x, start.y, end.x, end.y, paint)
        }
    }

    return bitmap
}
