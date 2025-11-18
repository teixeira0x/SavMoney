package com.teixeira0x.savmoney.ui.screen.home.screen.addexpense

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.teixeira0x.savmoney.Strings
import com.teixeira0x.savmoney.data.model.TYPE_FIXED

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseScreen(
    navController: NavController,
) {
    val expenseDate = remember { mutableStateOf("") }
    val expenseType = remember { mutableStateOf(TYPE_FIXED) }

    val expenseDescription = remember { mutableStateOf("") }
    val expenseValue = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(Strings.app_name))
                })
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(10.dp)) {
            TextField(
                value = expenseDate.value,
                onValueChange = { expenseDate.value = it },
                label = "Date"
            )
            TextField(
                value = expenseType.value,
                onValueChange = { expenseType.value = it },
                label = "Type"
            )

            TextField(
                value = expenseDescription.value,
                onValueChange = { expenseDescription.value = it },
                label = "Description"
            )
            TextField(
                value = expenseValue.value,
                onValueChange = { expenseValue.value = it },
                label = "Value"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(modifier = Modifier.weight(1f), onClick = { navController.popBackStack() }) {
                    Text(text = "Cancel")
                }
                Button(modifier = Modifier.weight(1f), onClick = {

                }) {
                    Text(text = "Save")
                }
            }
        }
    }
}


@Composable
private fun TextField(value: String, onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) })
}