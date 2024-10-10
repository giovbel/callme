package br.senai.sp.jandira.callme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.jandira.sp.callme.telas.landingPage
import br.senai.sp.jandira.callme.screens.redefinirsenha
import br.senai.sp.jandira.callme.screens.telaCadastro
import br.senai.sp.jandira.callme.ui.theme.CallmeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface (
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ){
                CallmeTheme {
                    val controleNavegacao = rememberNavController()
                    NavHost(
                        navController = controleNavegacao,
                        startDestination = "landingpage"
                    ){
                        composable(route = "landingpage") {landingPage(controleNavegacao)}
                        composable(route = "telacadastro") { telaCadastro(controleNavegacao)}
                        composable(route = "redefinirsenha") { redefinirsenha(controleNavegacao) }

//                        composable(route = "DetalhesPersonagem/{id}"){ backStackEntry -> val id = backStackEntry.arguments?.getString("id")CharacterDetails(controleNavegacao, id)
                        }
                    }
                }

        }
    }
}