package com.teixeira0x.savmoney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.teixeira0x.savmoney.ui.screen.home.HomeScreen
import com.teixeira0x.savmoney.ui.screen.addexpense.AddExpenseScreen
import com.teixeira0x.savmoney.ui.theme.SavMoneyTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SavMoneyTheme {
                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }

    @Composable
    fun AppNavHost(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeScreen(navController)
            }
            composable("add_expense") {
                AddExpenseScreen(navController)
            }
        }
    }
}


