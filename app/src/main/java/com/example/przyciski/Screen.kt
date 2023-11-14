package com.example.przyciski

sealed class Screen(val route: String) {
    object Wybierz : Screen("wybierz")
    object Czujnik_Swiatla : Screen("czujnik_swiatla")
    object Czujnik_Zblizeniowy : Screen("czujnik_zblizeniowy")
    object Slaby_jestes : Screen("dupa_jestes")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg") }
        }
    }
}
