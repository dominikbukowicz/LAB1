package com.example.przyciski

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Navigation() {
    val navController = rememberNavController() //NAWIGACJA
    NavHost(navController = navController, startDestination = Screen.Wybierz.route) {

        composable(route = Screen.Wybierz.route) {
            Wybierz(navController = navController)
        }
        composable(
            route = Screen.Czujnik_Swiatla.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Nieznajomy"
                    nullable = true
                }
            )
        )
        { entry ->
            Czujnik_Swiatla(navController = navController, name = entry.arguments?.getString("name"))
            //Czujnik_Zblizeniowy(navController = navController, name = entry.arguments?.getString("name"))

        }

        composable(
            route = Screen.Czujnik_Zblizeniowy.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Nieznajomy"

                }
            )
        )
        { entry ->
            //Czujnik_Swiatla(navController = navController, name = entry.arguments?.getString("name"))
            Czujnik_Zblizeniowy(navController = navController, name = entry.arguments?.getString("name"))

        }

        composable(
            route = Screen.Slaby_jestes.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Nieznajomy"

                }
            )
        )
        { entry ->
            //Czujnik_Swiatla(navController = navController, name = entry.arguments?.getString("name"))
            Slaby_jestes(navController = navController, name = entry.arguments?.getString("name"))

        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Wybierz(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Zapisz się w histori:", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White)
        var value by remember { mutableStateOf("") }

        TextField(value = value,
            onValueChange = {value = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text(text = "Enter name")})

        Text(text = "Wybierz swojego bohatera", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White)
        TextButton(onClick = {
            if (value.isNotBlank()) {
                navController.navigate(Screen.Czujnik_Swiatla.withArgs(value))
            }
            else{
                navController.navigate(Screen.Czujnik_Swiatla.withArgs("Nieznajomy"))
            }
        },
            modifier = Modifier.padding(6.dp),
            colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
            Text(text = "Czarownik", fontSize = 18.sp, color = Color.White)
        }
        TextButton(onClick = {
            if (value.isNotBlank()) {
                navController.navigate(Screen.Czujnik_Zblizeniowy.withArgs(value))
            }
            else{
                navController.navigate(Screen.Czujnik_Zblizeniowy.withArgs("Nieznajomy"))
            }
        },
            modifier = Modifier.padding(6.dp),
            colors = ButtonDefaults.buttonColors(Color.DarkGray)
            ) {
            Text(text = "Wojownik", fontSize = 18.sp, color = Color.White)
        }

        TextButton(onClick = {
            if (value.isNotBlank()) {
                navController.navigate(Screen.Slaby_jestes.withArgs(value))
            }
            else{
                navController.navigate(Screen.Slaby_jestes.withArgs("Nieznajomy"))
            }
        },
            modifier = Modifier.padding(6.dp),
            colors = ButtonDefaults.buttonColors(Color.DarkGray)
        ) {
            Text(text = "Palladyn", fontSize = 18.sp, color = Color.White)
        }

    }
}

@Composable
fun Czujnik_Swiatla(navController: NavController, name: String?) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.czary),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Tutaj chce wyswietlic wartosc inputValue
        Text(text = "Witaj, $name", fontSize = 18.sp, color = Color.White)


        Text(text = "Twój bohater to czarownik", fontSize = 18.sp, color = Color.White)
        TextButton(onClick = {
            navController.navigate(Screen.Wybierz.route)
        },
            modifier = Modifier.padding(6.dp),
            colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
            Text(text = "Back", fontSize = 18.sp, color = Color.White)
        }



    }
}

@Composable
fun Czujnik_Zblizeniowy(navController: NavController, name: String?) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.woj),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Witaj, $name", fontSize = 18.sp, color = Color.White)
        Text(text = "Twój bohater to wojownik", fontSize = 18.sp, color = Color.White)

        TextButton(onClick = {
            navController.navigate(Screen.Wybierz.route)
        },
            modifier = Modifier.padding(6.dp),
            colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
            Text(text = "Back", fontSize = 18.sp, color = Color.White)
        }
    }
}

@Composable
fun Slaby_jestes(navController: NavController, name: String?) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.dupa),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Albo wojownik albo nic", fontSize = 18.sp, color = Color.White)

        TextButton(onClick = {
            navController.navigate(Screen.Wybierz.route)
        },
            modifier = Modifier.padding(6.dp),
            colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
            Text(text = "Back", fontSize = 18.sp, color = Color.White)
        }
    }
}