package com.ag_apps.typesafenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ag_apps.typesafenavigation.ui.theme.TypeSafeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypeSafeNavigationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Navigation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Screen1,
        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { -it } },
        popEnterTransition = { slideInHorizontally { -it } },
        popExitTransition = { slideOutHorizontally { it } }
    ) {
       composable<Screen.Screen1> {
           Screen1(
               onGoToNextScreen = {
                   navController.navigate(Screen.Screen2(8))
               }
           )
       }

       composable<Screen.Screen2> { backStackEntry ->
           val screen2: Screen.Screen2 = backStackEntry.toRoute()

           Screen2(
               id = screen2.id,
               onGoToNextScreen = {
                   navController.popBackStack()
                   navController.navigate(Screen.Screen3)
               }
           )
       }

       composable<Screen.Screen3> {
           Screen3(
               onGoBack = {
                   navController.popBackStack()
               }
           )
       }
    }
}