package dev.ahmadrafi.movieapp.navigations

import java.lang.IllegalArgumentException

enum class MovieScreen {
    HomeScreen,
    DetailsScreen;
    companion object {
        fun fromRoute(route: String?): MovieScreen
        = when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not exist")

        }
    }
}