package br.senai.sp.jandira.telacriarnota

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R
import br.senai.sp.jandira.callme.model.NotasResponse
import br.senai.sp.jandira.callme.model.Postagem
import br.senai.sp.jandira.callme.service.RetrofitFactory
import coil.compose.rememberAsyncImagePainter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun telaComentariosLeitor(controleNavegacao: NavHostController) {

    var notas by remember { mutableStateOf<List<Postagem>>(emptyList()) }
    var currentNoteIndex by remember { mutableStateOf(0) }
    var loadingNotas by remember { mutableStateOf(true) }
    val context = LocalContext.current
    val notaService = RetrofitFactory.getNotasService()

    LaunchedEffect(Unit) {
        notaService.getNotas().enqueue(object : Callback<NotasResponse> {
            override fun onResponse(call: Call<NotasResponse>, response: Response<NotasResponse>) {
                if (response.isSuccessful) {
                    notas = response.body()?.dados?.take(10) ?: emptyList()
                    loadingNotas = false
                } else {
                    Toast.makeText(
                        context,
                        "Erro ao carregar notas: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                    loadingNotas = false
                }
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
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFC3D9FF),
                        Color(0xFF1B55CD),
                    )
                )
            )
    ) {
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



        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFC3D9FF),
                            Color(0xFF9BBAF5),
                            Color(0xFF1B55CD),
                        )
                    )
                ),
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.voltar ),
                contentDescription = "",
                modifier = Modifier
                    .size(35.dp)
                    .zIndex(12f)
                    .offset(y = 20.dp, x = 10.dp)
            )

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

                    }

                    Box(
                        modifier = Modifier
                            .height(700.dp)
                            .fillMaxWidth(0.7f)
                    ) {
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
                                    .fillMaxSize()
                                    .padding(start = 20.dp, end = 20.dp),
                                contentAlignment = Alignment.Center

                            ) {
                                Text(
                                    text = if (!loadingNotas && notas.isNotEmpty()) notas[currentNoteIndex].conteudo else "Carregando...",
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
                                .offset(y = 20.dp, x = -32.dp)
                        )

                        Card(
                            modifier = Modifier
                                .height(55.dp)
                                .width(55.dp)
                                .offset(y = 53.dp, x = 210.dp)
                                .border(3.dp, Color(0xFF020075), RoundedCornerShape(30.dp)),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                val profilePainter: Painter =
                                    if (!loadingNotas && notas.isNotEmpty() && !notas[currentNoteIndex].usuario.foto.isNullOrEmpty()) {
                                        rememberAsyncImagePainter(model = notas[currentNoteIndex].usuario.foto)
                                    } else {
                                        painterResource(id = R.drawable.perfilcomum)
                                    }

                                Image(
                                    painter = profilePainter,
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(30.dp))
                                )
                            }
                        }
                    }

                    IconButton(
                        onClick = {
                            if (currentNoteIndex < notas.size - 1) currentNoteIndex++
                        }
                    ) {

                    }
                }

                Card (
                    modifier = Modifier.fillMaxWidth().height(300.dp).background(Color(0xFFBDD8FF))
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .border(1.dp, Color.Black, RoundedCornerShape(20.dp))
                            .background(Color(0xFFFFFFF5))
                    ) {
                        Row (){
                            Card (
                                modifier = Modifier.height(40.dp).width(40.dp).clip(RoundedCornerShape(20.dp))
                                    .border(2.dp, Color.Black, RoundedCornerShape(20.dp))
                            ){

                            }
                        }
                    }
                }


            }

            }

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
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .size(72.dp)
                                .background(Color.Transparent),
                            colors = ButtonDefaults.buttonColors(Color.Transparent)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.calendarioicon),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp)
                            )

                        }
                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .size(72.dp)
                                .background(Color.Transparent),
                            colors = ButtonDefaults.buttonColors(Color.Transparent)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.chaticon),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp)
                            )

                        }
                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .size(72.dp)
                                .background(Color.Transparent),
                            colors = ButtonDefaults.buttonColors(Color.Transparent)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.diarioicon),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp)
                            )

                        }
                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .size(72.dp)
                                .background(Color.Transparent),
                            colors = ButtonDefaults.buttonColors(Color.Transparent)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.autoajuda),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp)
                            )

                        }
                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .size(72.dp)
                                .background(Color.Transparent),
                            colors = ButtonDefaults.buttonColors(Color.Transparent)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.doacaoicon),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp)
                            )

                        }
                    }
                }
            }

        }

