package com.example.samplecompose.itemComposable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MultiSelectDialog(
    items: List<String>,
    preselected: List<String>,
    onDismiss: () -> Unit,
    onSubmit: (List<String>) -> Unit
) {
    val selectedItems = remember { mutableStateListOf<String>().apply { addAll(preselected) } }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Select Items") },
        text = {
            LazyColumn {
                items(items) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                if (selectedItems.contains(item)) {
                                    selectedItems.remove(item)
                                } else {
                                    selectedItems.add(item)
                                }
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = selectedItems.contains(item),
                            onCheckedChange = {
                                if (it) selectedItems.add(item)
                                else selectedItems.remove(item)
                            }
                        )
                        Text(text = item)
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { onSubmit(selectedItems.toList()) }) {
                Text("Submit")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
