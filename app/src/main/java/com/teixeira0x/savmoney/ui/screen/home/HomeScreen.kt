package com.teixeira0x.savmoney.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.teixeira0x.savmoney.Strings
import com.teixeira0x.savmoney.ui.screen.home.component.ExpensesList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = viewModel()
) {
    val state = viewModel.viewState

    LaunchedEffect(Unit) {
        viewModel.loadExpenses()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(Strings.app_name))
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("add_expense")
            }) {
                Text(stringResource(Strings.add_expense))
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

            ExpensesList(
                expenses = state.expenses
            )

        }
    }
}