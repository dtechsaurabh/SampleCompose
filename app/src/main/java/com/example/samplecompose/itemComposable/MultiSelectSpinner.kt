//package com.example.samplecompose.item
//import android.widget.Toast
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.heightIn
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.material3.Checkbox
//import androidx.compose.material3.DropdownMenu
//import androidx.compose.material3.DropdownMenuItem
//import androidx.compose.material3.Icon
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.OutlinedTextFieldDefaults
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.samplecompose.R
//import com.urwayittech.colt.service.ui.mic.EmployeeList
//
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun MultiSelectSpinnerPreview() {
//    var selectedEmployees by remember { mutableStateOf(listOf<Pair<String, String>>()) }
//
//}
//
//@Composable
//fun MultiSelectSpinner(
//    employeeList: List<EmployeeList>,
//    selectedEmployees: List<EmployeeList>,
//    onSelectionChange: (List<EmployeeList>) -> Unit
//) {
//    var expanded by remember { mutableStateOf(false) }
//
//    val selectedText = if (selectedEmployees.isEmpty()) {
//        "Select Employee*"
//    } else {
//        selectedEmployees.joinToString { it.first + " " +it.last}
//    }
//
//    Box(modifier = Modifier.fillMaxWidth()) {
//        // Wrap in a clickable Box
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable { expanded = !expanded }
//        ) {
//            OutlinedTextField(
//                value = selectedText,
//                onValueChange = {},
//                label = { Text("Select Employee*") },
//                readOnly = true,
//                enabled = false, // This makes it uneditable and fully click-transparent
//                modifier = Modifier.fillMaxWidth(),
//                trailingIcon = {
//                    val icon = if (expanded)
//                        painterResource(id = R.drawable.drop_down_in_icon)
//                    else
//                        painterResource(id = R.drawable.drop_down_up_icon)
//
//                    Icon(
//                        painter = icon,
//                        contentDescription = "Dropdown Icon",
//                        modifier = Modifier.size(14.dp)
//                    )
//                },
//                colors = OutlinedTextFieldDefaults.colors(
//                    disabledTextColor = Color.Black,
//                    disabledBorderColor = Color.Black,
//                    disabledLabelColor = Color.Black,
//                    disabledTrailingIconColor = Color.Black
//                )
//            )
//        }
//
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false },
//            modifier = Modifier
//                .fillMaxWidth()
//                .heightIn(max = 300.dp)
//        ) {
//            employeeList.forEach { employee ->
//                val isSelected = selectedEmployees.contains(employee)
//
//                DropdownMenuItem(
//                    text = {
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Checkbox(
//                                checked = isSelected,
//                                onCheckedChange = null
//                            )
//                            Spacer(modifier = Modifier.width(8.dp))
//                            Text("${employee.mobile} - ${employee.first} ${employee.last}")
//                        }
//                    },
//                    onClick = {
//                        val newSelection = selectedEmployees.toMutableList().apply {
//                            if (isSelected) remove(employee) else add(employee)
//                        }
//                        onSelectionChange(newSelection)
//                    }
//                )
//            }
//        }
//    }
//}
