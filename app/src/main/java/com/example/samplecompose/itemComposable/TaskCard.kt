package com.example.samplecompose.itemComposable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import androidx.core.graphics.toColorInt


data class TaskListDataModel(
    val job_id: String,
    val bgcolor: String,
    val assign_job: String,
    val jobgroup: String,
    val assign_date: String,
    val assign_name: String
)


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskCardPreview() {
    val navController = rememberNavController()
    val dummyTasks = ArrayList<TaskListDataModel>()


    for (i in 0..10) {
        dummyTasks.add(
            TaskListDataModel(
                job_id = "4058",
                bgcolor = "#fdf9d2",
                assign_job = "Debtors-creditors-balance-confirmation-Completion-date-572025",
                jobgroup = "",
                assign_date = "30-06-2025",
                assign_name = ""
            )
        )
    }


    LazyColumn {
        items(dummyTasks) { task ->
            TaskCard(
                bgColor = task.bgcolor,
                title = task.assign_job,
                assignDate = task.assign_date,
                employeeNames = task.assign_name,
                onViewClick = {

                },
                onUpdateClick = {

                }
            )
        }
    }

}


@Composable
fun TaskCard(
    bgColor: String,
    title: String,
    assignDate: String,
    employeeNames: String,
    onViewClick: () -> Unit,
    onUpdateClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(bgColor.toColorInt())) // Light Yellow
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Assign Date : $assignDate",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = employeeNames,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Button(
                    onClick = onViewClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081)),
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(text = "View")
                }
                Button(
                    onClick = onUpdateClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4081))
                ) {
                    Text(text = "Update")
                }
            }
        }
    }
}
