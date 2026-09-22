package com.pemmob.rani

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pemmob.rani.ui.screen.BasicInfoScreen
import com.pemmob.rani.ui.screen.HubungiKamiScreen
import com.pemmob.rani.ui.theme.PraktikumMobileJualanTheme
import ui.screen.CategoryScreen
import ui.screen.DaftarProductScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraktikumMobileJualanTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "category") {
                        composable(route = "category") {
                            CategoryScreen(
                                onCategoryClick = { categoryId ->
                                    navController.navigate(route = "daftar_product/$categoryId")
                                }
                            )
                        }
                        composable(
                            route = "daftar_product/{categoryId}",
                            arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val categoryId = backStackEntry.arguments?.getInt("categoryId")
                            DaftarProductScreen(initialCategoryId = categoryId)
                        }
                        composable(route = "basic_info") {
                            BasicInfoScreen(
                                onNavigateToContact = { navController.navigate(route = "form_screen") }
                            )
                        }
                        composable(route = "form_screen") {
                            HubungiKamiScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}