package br.senai.sp.jandira.callme

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
import br.senai.jandira.sp.telacriarpostdiario.telaCriarPostDiario
import br.senai.sp.jandira.callme.screens.landingPage
import br.senai.sp.jandira.callme.screens.landingPageChat
import br.senai.sp.jandira.callme.screens.landingPageDois
import br.senai.sp.jandira.callme.screens.redefinirSenhaCodigo
import br.senai.sp.jandira.callme.screens.redefinirsenha
import br.senai.sp.jandira.callme.screens.telaAutojuda
import br.senai.sp.jandira.callme.screens.telaCadastro
import br.senai.sp.jandira.callme.screens.telaCardAutoAjuda
import br.senai.sp.jandira.callme.screens.telaChatConversa
import br.senai.sp.jandira.callme.screens.telaChatConversaDois
import br.senai.sp.jandira.callme.screens.telaChatList
import br.senai.sp.jandira.callme.screens.telaChatPsicologo
import br.senai.sp.jandira.callme.screens.telaCriarNota
import br.senai.sp.jandira.callme.screens.telaDiario
import br.senai.sp.jandira.callme.screens.telaEditarpost
import br.senai.sp.jandira.callme.screens.telaEscolherAvatar
import br.senai.sp.jandira.callme.screens.telaLogin
import br.senai.sp.jandira.callme.screens.telaNotas
import br.senai.sp.jandira.callme.screens.telaPerfil
import br.senai.sp.jandira.callme.screens.telaPsicologoInfo

import br.senai.sp.jandira.callme.ui.theme.CallmeTheme
import br.senai.sp.jandira.telacriarnota.telaComentariosLeitor
import senai.jandira.sp.telacategoria.telaCategoria


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
                        startDestination = "telaLogin"
                    ) {
                        composable(route = "landingpage") { landingPage(controleNavegacao) }
                        composable(route = "telaLogin") { telaLogin(controleNavegacao) }
                        composable(route = "redefinirsenha") { redefinirsenha(controleNavegacao) }
                        composable(route = "telaCadastro") { telaCadastro(controleNavegacao) }
                        composable(route = "landingPageDois") { landingPageDois(controleNavegacao) }
                        composable(route = "redefinirsenhacodigo") {
                            redefinirSenhaCodigo(
                                controleNavegacao
                            )
                        }


                        composable(//FEITO
                            "telaNotas/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id =
                                backStackEntry.arguments?.getString("id") ?: ""
                            telaNotas(controleNavegacao, id = id)
                        }
                        composable(route = "telaCategoria") { telaCategoria(controleNavegacao) }

                        composable(//FEITO
                            "telaDiario/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id =
                                backStackEntry.arguments?.getString("id") ?: ""
                            telaDiario(controleNavegacao, id = id)
                        }
                        composable(//FEITO
                            "telaCriarPostDiario/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id =
                                backStackEntry.arguments?.getString("id") ?: ""
                            telaCriarPostDiario(controleNavegacao, id = id)
                        }
                        composable(//FEITO
                            "telaEditarpost/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id =
                                backStackEntry.arguments?.getString("id") ?: ""
                            telaEditarpost(controleNavegacao, id = id)
                        }
                        composable(//FEITO
                            "telaEscolherAvatar/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id =
                                backStackEntry.arguments?.getString("id") ?: ""
                            telaEscolherAvatar(controleNavegacao, id = id)
                        }
                        composable(//FEITO
                            "telaDiario/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id =
                                backStackEntry.arguments?.getString("id") ?: ""
                            telaDiario(controleNavegacao, id = id)
                        }
                        composable(//FEITO
                            "telaChatConversaDois/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id =
                                backStackEntry.arguments?.getString("id") ?: ""
                            telaChatConversaDois(controleNavegacao, id = id)
                        }
//se algum dia vcs dois apararecerem juntos eu te dou uma voadora no pesoço.
                        composable(//FEITO
                            "telaChatConversa/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id =
                                backStackEntry.arguments?.getString("id") ?: ""
                            telaChatConversa(controleNavegacao, id = id)
                        }
                        composable(//FEITO
                            "telaChatList/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id =
                                backStackEntry.arguments?.getString("id") ?: ""
                            telaChatList(controleNavegacao, id = id)
                        }
                        composable(//FEITO
                            "landingPageChat/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id =
                                backStackEntry.arguments?.getString("id") ?: ""
                            landingPageChat(controleNavegacao, id = id)
                        }
                        composable(//FEITO
                            "telaCardAutoAjuda/{id}",
                            arguments = listOf(navArgument("id") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val id =
                                backStackEntry.arguments?.getString("id") ?: ""
                            telaCardAutoAjuda(controleNavegacao, id = id)
                        }

                    composable(//FEITO
                        "telaAutojuda/{id}",
                        arguments = listOf(navArgument("id") {
                            type = NavType.StringType
                        })
                    ) { backStackEntry ->
                        val id =
                            backStackEntry.arguments?.getString("id") ?: ""
                        telaAutojuda(controleNavegacao, id = id)
                    }


                        composable(route = "telaPsicologoInfo") { telaPsicologoInfo(controleNavegacao) }
//                        composable(route = "telaChatList") { telaChatList(controleNavegacao) }
                        composable(route = "telaCriarNota") { telaCriarNota(controleNavegacao) }
                        composable(route = "telaComentariosLeitor") { telaComentariosLeitor(controleNavegacao) }
                        composable(route = "telaPerfil") { telaPerfil(controleNavegacao) }
                        composable(route = "telaChatPsicologo") { telaChatPsicologo(controleNavegacao) }
//                        composable(route = "telaAutoajuda") { telaAutojuda(controleNavegacao) }
//                        composable(route = "telaCardAutoAjuda") { telaCardAutoAjuda(controleNavegacao) }
//                        composable(route = "telaChatConversaDois") { telaChatConversaDois(controleNavegacao) }
//                        composable(route = "telaChatConversa") {telaChatConversa(controleNavegacao)}
//                        composable(route = "telaDiario") { telaDiario(controleNavegacao, id.toString()) }
//                        composable(route = "DetalhesPersonagem/{id}"){ backStackEntry -> val id = backStackEntry.arguments?.getString("id")CharacterDetails(controleNavegacao, id)
                        }
                    }
                }

        }
    }
}