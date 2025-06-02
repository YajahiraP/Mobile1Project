package com.example.mobile1project.navigation


import ConverterView
import IMCView
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.mobile1project.examenfinal.ViewModels.RestaurantViewModel
import com.example.mobile1project.ids.IdsView
import com.example.mobile1project.firstpartial.FirstPartialView
import com.example.mobile1project.secondpartial.SecondPartialView
import com.example.mobile1project.thirdpartial.ThirdPartialView
import com.example.mobile1project.ids.sum.views.SumView
import com.example.mobile1project.ids.Login.Views.LoginView
import com.example.mobile1project.ids.sum.ViewModels.SumViewModel
import com.example.mobile1project.ids.list.Views.ListView
import com.example.mobile1project.thirdpartial.ExamenThirdPartial.ViewModels.StudentViewModel
import com.example.mobile1project.thirdpartial.Location.Views.LocationListView
import com.example.mobile1project.thirdpartial.ExamenThirdPartial.Views.StudentListView
import com.example.mobile1project.examenfinal.Views.RestaurantView
import com.example.mobile1project.examenfinal.Views.RestaurantDetailsView








@Composable
fun TabBarNavigationView(navController: NavHostController = rememberNavController(),
                         studentViewModel: StudentViewModel,
                         restaurantViewModel: RestaurantViewModel) {
    val items = listOf(
        ScreenNavigation.Ids,
        ScreenNavigation.FirstPartial,
        ScreenNavigation.SecondPartial,
        ScreenNavigation.ThirdPartial,
        ScreenNavigation.examenfinal

    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route)
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenNavigation.Ids.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreenNavigation.Ids.route) { IdsView(navController) }
            composable(ScreenNavigation.FirstPartial.route) { FirstPartialView() }
            composable(ScreenNavigation.SecondPartial.route) { SecondPartialView() }
            composable(ScreenNavigation.ThirdPartial.route) { ThirdPartialView() }
            composable(ScreenNavigation.IMC.route) { IMCView() }
            composable(ScreenNavigation.Login.route) { LoginView() }
            composable(ScreenNavigation.Converter.route) { ConverterView() }
            composable(ScreenNavigation.List.route) { ListView() }
            composable(ScreenNavigation.Location.route) { LocationListView() }
            composable(ScreenNavigation.ExamenThirdPartial.route) { StudentListView(uiState = studentViewModel.uiState) }
            composable(ScreenNavigation.examenfinal.route) {
                RestaurantView(viewModel = restaurantViewModel, navController = navController)
            }
            composable("detail/{restaurantId}") { backStackEntry ->
                val restaurantId = backStackEntry.arguments?.getString("restaurantId")
                RestaurantDetailsView(
                    restaurantId = restaurantId,
                    viewModel = restaurantViewModel,
                    navController = navController
                )
            }

            composable(ScreenNavigation.Sum.route) {
                val viewModel: SumViewModel = viewModel()
                SumView(viewModel)
            }

        }
    }
}
