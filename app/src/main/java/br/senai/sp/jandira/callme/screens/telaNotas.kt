package br.senai.sp.jandira.callme.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R
import br.senai.sp.jandira.callme.model.Cliente
import br.senai.sp.jandira.callme.model.ClienteResponse
import br.senai.sp.jandira.callme.model.NotasResponse
import br.senai.sp.jandira.callme.model.Postagem
import br.senai.sp.jandira.callme.service.RetrofitFactory
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun telaNotas(controleNavegacao: NavHostController) {
    // Variáveis de estado para armazenar as notas e a mensagem de erro
 //   var notas by remember { mutableStateOf<List<Nota>>(emptyList()) }
    var notas by remember { mutableStateOf<List<Postagem>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    var loadingNotas by remember { mutableStateOf(true) }

    val retrofitFactory = RetrofitFactory
    val notaService = retrofitFactory.getNotasService()

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        notaService.getNotas().enqueue(object : Callback<NotasResponse> {
            override fun onResponse(call: Call<NotasResponse>, response: Response<NotasResponse>) {
                if (response.isSuccessful) {
                    notas = response.body()?.dados?: emptyList()
                    Log.d("Sexos", "Notas carregadas: $notas")
                } else {
                    Toast.makeText(context, "Erro ao carregar notas: ${response.code()}", Toast.LENGTH_SHORT).show()
                    Log.e("Erro", "Corpo da resposta: ${response.errorBody()?.string()}")
                }
                loadingNotas = false
            }

            override fun onFailure(call: Call<NotasResponse>, t: Throwable) {
                Toast.makeText(context, "Erro: ${t.message}", Toast.LENGTH_SHORT).show()
                loadingNotas = false
            }
        })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Cabeçalho da tela
        Box(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF213787),
                            Color(0xFF245FB0),
                            Color(0xFF6E96E8)
                        )
                    ),
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo2),
                    contentDescription = "",
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                )
                Text(
                    text = "NOTAS",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
                Card(
                    modifier = Modifier
                        .size(50.dp)
                        .border(4.dp, Color(0xFF9DBFEF), RoundedCornerShape(30.dp)),
                    shape = RoundedCornerShape(100.dp),
                ) {}
            }
        }

        // Conteúdo principal
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFC3D9FF),
                            Color(0xFFC3D9FF),
                            Color(0xFF9BBAF5),
                            Color(0xFF1B55CD),
                        )
                    ),
                ),
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.8f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier.padding(start = 16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(0xFF213787),
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .height(700.dp)
                            .fillMaxWidth(0.7f)
                    ) {
                        // Cartões sobrepostos
                        Card(
                            modifier = Modifier
                                .height(255.dp)
                                .width(276.dp)
                                .align(Alignment.Center)
                                .offset(x = -10.dp)
                                .graphicsLayer { rotationZ = -10f }
                                .border(4.dp, Color(0xFF020075), RoundedCornerShape(20.dp)),
                            shape = RoundedCornerShape(30.dp),
                            colors = CardDefaults.cardColors(Color(0xFFBCDDFF))
                        ) {}

                        Card(
                            modifier = Modifier
                                .height(250.dp)
                                .width(280.dp)
                                .align(Alignment.Center)
                                .offset(y = 20.dp, x = 25.dp)
                                 .graphicsLayer { rotationZ = -12f }
                                .border(4.dp, Color(0xFF020075), RoundedCornerShape(20.dp)),
                            shape = RoundedCornerShape(30.dp),
                            colors = CardDefaults.cardColors(Color(0xFFFFFFD2))
                        ) {}

                        // Card principal com o conteúdo da nota
                        Card(
                            modifier = Modifier
                                .height(260.dp)
                                .width(290.dp)
                                .align(Alignment.Center)
                                .offset(y = -15.dp, x = 10.dp)
                                .border(4.dp, Color(0xFF020075), RoundedCornerShape(20.dp)),
                            shape = RoundedCornerShape(30.dp),
                            colors = CardDefaults.cardColors(Color(0xFFFFFFFF))
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(start = 20.dp, end = 20.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = if (notas.isNotEmpty()) notas[0].conteudo else "Carregando...",
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF2754B2)
                                )
                            }
                        }

                        Image(
                            painter = painterResource(id = R.drawable.macallmeanotando),
                            contentDescription = "",
                            modifier = Modifier
                                .size(150.dp)
                                .zIndex(12f)
                                .offset(y = 27.dp, x = -32.dp)
                        )
                    }

                    IconButton(
                        onClick = { /* TODO */ },
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Avançar",
                            tint = Color(0xFF213787),
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }

                // Botões de ação na parte inferior
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(Color(0xFF213787)),
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .height(50.dp)
                            .width(160.dp),
                        shape = RoundedCornerShape(7.dp)
                    ) {
                        Text(
                            text = "Postar Nota",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(Color(0xFF213787)),
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .height(50.dp)
                            .width(160.dp),
                        shape = RoundedCornerShape(7.dp)
                    ) {
                        Text(
                            text = "Responder Nota",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}

private fun getNotas(cliente: Cliente, navController: NavHostController, context: Context) {
    val clienteService = RetrofitFactory.getClienteService().loginUsuario(cliente)

    clienteService./*loginUsuari(cliente)*/enqueue(object : Callback<ClienteResponse> {
        override fun onResponse(call: Call<ClienteResponse>, response: Response<ClienteResponse>) {
            if (response.isSuccessful) {
                navController.navigate("telaNotas")
                Toast.makeText(context, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Log.e("Login", "O login falhou: ${response.message()}")
                Toast.makeText(context, "Login falhou. Verifique suas credenciais.", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<ClienteResponse>, t: Throwable) {
            Log.e("Login", "Erro de rede: ${t.message}")
            Toast.makeText(context, "Erro de rede. Tente novamente.", Toast.LENGTH_SHORT).show()
        }
    })
}

