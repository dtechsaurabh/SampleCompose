package com.example.samplecompose.itemComposable
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecompose.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomMultiSelectSpinnerPreview() {
    val items = listOf("Option 1", "Option 2", "Option 3")
    var selected by remember { mutableStateOf(listOf(items.first())) }
    CustomMultiSelectSpinner(
        label = "User Type",
        selectedItems = selected,
        onItemsSelected = { selected = it },
        items = items,
        colorRes = R.color.editFieldColor,
        enabled = true,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomMultiSelectSpinner(
    label: String,
    selectedItems: List<String>,
    onItemsSelected: (List<String>) -> Unit,
    items: List<String>,
    colorRes: Int,
    enabled: Boolean = true
) {
    var showDialog by remember { mutableStateOf(false) }
    val selectedText = if (selectedItems.isEmpty()) "Select..." else selectedItems.joinToString()

    Column {
        // Label
        Text(
            text = label,
            color = colorResource(id = colorRes),
            modifier = Modifier.padding(bottom = 4.dp)
        )

        // Custom Box styled like an OutlinedTextField
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(
                    width = 1.dp,
                    color = colorResource(id = colorRes),
                    shape = RoundedCornerShape(5.dp)
                )
                .clip(RoundedCornerShape(5.dp))
                .clickable(enabled = enabled) { showDialog = true }
                .padding(horizontal = 12.dp, vertical = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = selectedText,
                    color = if (selectedItems.isEmpty()) Color.Gray else Color.Black,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.drop_down_up_icon),
                    contentDescription = "Dropdown Icon",
                    tint = Color.Black,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }

    if (showDialog) {
        MultiSelectDialog(
            items = items,
            preselected = selectedItems,
            onDismiss = { showDialog = false },
            onSubmit = {
                onItemsSelected(it)
                showDialog = false
            }
        )
    }
}

