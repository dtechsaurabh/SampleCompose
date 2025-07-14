package com.example.samplecompose.itemComposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecompose.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomDropdownSpinnerPreview() {
    val items = listOf("Option 1", "Option 2", "Option 3")
    var selected by remember { mutableIntStateOf(0) }
    CustomDropdownSpinner(
        label = "User Type",
        selectedItemIndex = selected,
        onItemSelected = { selected = it },
        itemsList = items,
        colorRes = R.color.editFieldColor,
        enabled = true,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDropdownSpinner(
    label: String,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit,
    itemsList: List<String>,
    colorRes: Int,
    enabled: Boolean = true
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = itemsList[selectedItemIndex],
            onValueChange = {},
            readOnly = true,
            label = { Text(label, color = colorResource(id = colorRes)) },
            trailingIcon = {
                val icon = if (expanded)
                    painterResource(id = R.drawable.drop_down_in_icon)
                else
                    painterResource(id = R.drawable.drop_down_up_icon)

                Icon(
                    painter = icon,
                    contentDescription = "Dropdown Icon",
                    modifier = Modifier.size(14.dp)
                )
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            enabled = enabled,
            singleLine = true,
            shape = RoundedCornerShape(5.dp),
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = colorRes),
                unfocusedBorderColor = colorResource(id = colorRes),
                focusedLeadingIconColor = colorResource(id = colorRes),
                unfocusedLeadingIconColor = colorResource(id = colorRes),
                cursorColor = colorResource(id = colorRes),
                focusedLabelColor = colorResource(id = colorRes),
                unfocusedLabelColor = colorResource(id = colorRes),
                disabledTextColor = Color.Gray,
                disabledBorderColor = colorResource(id = colorRes),
                disabledLeadingIconColor = colorResource(id = colorRes),
                disabledLabelColor = colorResource(id = colorRes),
                disabledPlaceholderColor = colorResource(id = colorRes)
            )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .exposedDropdownSize()
                .background(Color.White)
        ) {
            itemsList.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = { Text(item, color = Color.Black) },
                    onClick = {
                        onItemSelected(index)
                        expanded = false
                    }
                )
            }
        }
    }
}

