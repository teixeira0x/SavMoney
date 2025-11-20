package com.teixeira0x.savmoney.ui.screen.addexpense

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.teixeira0x.savmoney.Strings
import com.teixeira0x.savmoney.data.model.Expense
import com.teixeira0x.savmoney.data.model.ExpenseType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseScreen(
    navController: NavController, viewModel: AddExpenseViewModel = viewModel()
) {
    val expenseDate = remember { mutableStateOf("") }
    val expenseType = remember { mutableStateOf(ExpenseType.TYPE_VARIABLE) }

    val expenseDescription = remember { mutableStateOf("") }
    val expenseAmount = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(Strings.app_name))
                })
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            TextField(
                value = expenseDate.value,
                onValueChange = { expenseDate.value = it },
                label = "Date",
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next // Set the IME action to "Next"
                ),

            )
            AutoCompleteField(
                value = expenseType.value,
                onValueChange = { expenseType.value = it },
                label = "Type",
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next // Set the IME action to "Next"
                ),

                suggestions = ExpenseType.ALL_TYPES
            )

            TextField(
                value = expenseDescription.value,
                onValueChange = { expenseDescription.value = it },
                label = "Description",
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next // Set the IME action to "Next"
                ),
            )
            TextField(
                value = expenseAmount.value,
                onValueChange = { expenseAmount.value = it },
                label = "Amount",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                OutlinedButton(
                    modifier = Modifier.weight(1f), onClick = { navController.popBackStack() }) {
                    Text(text = "Cancel")
                }
                Button(modifier = Modifier.weight(1f), onClick = {

                    if (expenseDate.value.isEmpty() || expenseDescription.value.isEmpty() || expenseAmount.value.isEmpty()) {
                        return@Button
                    }

                    viewModel.addExpense(
                        Expense(
                            date = expenseDate.value,
                            type = expenseType.value,
                            title = expenseDescription.value,
                            category = "",
                            description = expenseDescription.value,
                            amount = expenseAmount.value.toDouble()
                        )
                    )

                    navController.popBackStack()
                }) {
                    Text(text = "Save")
                }
            }
        }
    }
}


@Composable
private fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoCompleteField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    suggestions: List<String>
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded, onExpandedChange = { expanded = !expanded }) {
        OutlinedTextField(
            readOnly = true,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            value = value,
            onValueChange = {
                // do nothing
            },
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) })

        ExposedDropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false }) {
            suggestions.forEach { item ->
                    DropdownMenuItem(text = { Text(item) }, onClick = {
                        onValueChange(item)
                        expanded = false
                    })
                }
        }
    }
}
