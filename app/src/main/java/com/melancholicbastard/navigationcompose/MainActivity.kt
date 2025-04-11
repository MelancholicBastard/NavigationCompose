package com.melancholicbastard.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.melancholicbastard.navigationcompose.ui.theme.NavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val topLevelRoutes = listOf(
            TopLevelRoutes("Accounting", Routes.Accounting.route, Icons.Outlined.AccountBox),
            TopLevelRoutes("Marketing", Routes.Marketing.route, Icons.Outlined.ShoppingCart),
            TopLevelRoutes("Coworking", Routes.Coworking.route, Icons.Outlined.Warning)
        )


        setContent {
            val navController = rememberNavController()
            NavigationComposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigation {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()   //
                            val currentDestination = navBackStackEntry?.destination     // Запоминает
                            topLevelRoutes.forEach { topLevelRoute ->
                                BottomNavigationItem(
                                    selected = currentDestination?.route == topLevelRoute.route,
                                    onClick = { navController.navigate(topLevelRoute.route) },
                                    icon = { Icon(imageVector = topLevelRoute.icon, contentDescription = "иконка") },
                                    label = { Text(topLevelRoute.name) },
                                )
                            }
                        }
                    }
                    ) { innerPadding ->

                    NavHost(navController = navController, startDestination = Routes.Accounting.route) {
                        composable(Routes.Accounting.route) { Accounting() }
                        composable(Routes.Marketing.route+"/{room_id}",
                            arguments = listOf(navArgument("room_id") {type = NavType.IntType})) { entry ->
                            // для обработки аргумента room_id выше

                            val room_id = entry.arguments!!.getInt("room_id")
                            Marketing(room_id)
                        }
                        composable(Routes.Marketing.route) { Marketing() }
                        composable(Routes.Coworking.route) { Coworking(navController) }
                    }
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Button(onClick = {
                            navController.navigate(Routes.Accounting.route)
                        }) {
                            Text("To Accounting")
                        }
                        Button(onClick = {
                            navController.navigate(Routes.Marketing.route + "/0")
                        }) {
                            Text("To Marketing")
                        }
                        Button(onClick = {
                            navController.navigate(Routes.Coworking.route)
                        }) {
                            Text("To Coworking")
                        }
                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NavigationComposeTheme {
//        Greeting("Android")
//    }
//}