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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R
import br.senai.sp.jandira.callme.model.NotasResponse
import br.senai.sp.jandira.callme.model.Postagem
import br.senai.sp.jandira.callme.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun telaNotas(controleNavegacao: NavHostController) {
    var notas by remember { mutableStateOf<List<Postagem>>(emptyList()) }
    var currentNoteIndex by remember { mutableStateOf(0) }
    val context = LocalContext.current
    var loadingNotas by remember { mutableStateOf(true) }
    val notaService = RetrofitFactory.getNotasService()

    // Carregar as notas
    LaunchedEffect(Unit) {
        notaService.getNotas().enqueue(object : Callback<NotasResponse> {
            override fun onResponse(call: Call<NotasResponse>, response: Response<NotasResponse>) {
                if (response.isSuccessful) {
                    notas = response.body()?.dados ?: emptyList()
                } else {
                    Toast.makeText(context, "Erro ao carregar notas: ${response.code()}", Toast.LENGTH_SHORT).show()
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
        modifier = Modifier.fillMaxSize()
    ) {
        // Cabeçalho da tela
        Box(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color(0xFF213787), Color(0xFF245FB0), Color(0xFF6E96E8))
                    )
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
                    modifier = Modifier.size(60.dp)
                )
                Text(
                    text = "NOTAS",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        // Conteúdo principal
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFFC3D9FF), Color(0xFF9BBAF5), Color(0xFF1B55CD))
                    )
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
                        onClick = {
                            if (currentNoteIndex > 0) currentNoteIndex--
                        },
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
                            .height(260.dp)
                            .fillMaxWidth(0.7f)
                    ) {
                        // Cartões sobrepostos para o efeito visual
                        Card(
                            modifier = Modifier
                                .height(255.dp)
                                .width(276.dp)
                                .align(Alignment.Center)
                                .offset(x = -10.dp)
                                .rotate(-10f)
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
                                .rotate(-12f)
                                .border(4.dp, Color(0xFF020075), RoundedCornerShape(20.dp)),
                            shape = RoundedCornerShape(30.dp),
                            colors = CardDefaults.cardColors(Color(0xFFFFFFD2))
                        ) {}

                        // Cartão principal que exibe o conteúdo da nota
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
                                    .padding(20.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = if (notas.isNotEmpty() && currentNoteIndex < notas.size) {
                                        notas[currentNoteIndex].conteudo
                                    } else "Carregando...",
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
                        onClick = {
                            if (currentNoteIndex < notas.size - 1 && currentNoteIndex < 4) currentNoteIndex++
                        },
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Avançar",
                            tint = Color(0xFF213787),
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
            }
        }
    }
}
