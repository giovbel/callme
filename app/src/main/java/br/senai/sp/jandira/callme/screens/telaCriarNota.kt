package br.senai.sp.jandira.callme.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R
import br.senai.sp.jandira.callme.model.NotaResponse
import br.senai.sp.jandira.callme.model.NotasResponse
import br.senai.sp.jandira.callme.model.Postagem
import br.senai.sp.jandira.callme.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun telaCriarNota(controleNavegacao: NavHostController) {
    var nota by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    val notaService = RetrofitFactory.getNotasService()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
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
                    text = "CRIAR NOTA",
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
                .height(775.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFC3D9FF),
                            Color(0xFFC3D9FF),
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
                        .height(600.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { }, modifier = Modifier.padding(start = 16.dp)) {}

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
                                .graphicsLayer { rotationZ = -10f }
                                .border(4.dp, Color(0xFF020075), RoundedCornerShape(20.dp)),
                            shape = RoundedCornerShape(30.dp),
                            colors = CardDefaults.cardColors(Color(0xFFBCDDFF))
                        ) {
                            Card(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(210.dp)
                                    .align(Alignment.End),
                                colors = CardDefaults.cardColors(Color(0xFF90C6FF))
                            ) {}
                        }
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
                                    .fillMaxHeight()
                                    .padding(start = 20.dp, end = 20.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                BasicTextField(
                                    value = nota,
                                    onValueChange = { newText -> nota = newText },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .background(Color.Transparent),
                                    decorationBox = { innerTextField ->
                                        if (nota.text.isEmpty()) {
                                            Text("Digite sua nota aqui...", color = Color.Gray)
                                        }
                                        innerTextField()
                                    }
                                )
                            }
                        }

                        Image(
                            painter = painterResource(id = R.drawable.macallmeanotando),
                            contentDescription = "",
                            modifier = Modifier
                                .size(150.dp)
                                .zIndex(12f)
                                .offset(y = 70.dp, x = -32.dp),
                        )
                        Card(
                            modifier = Modifier
                                .height(55.dp)
                                .width(55.dp)
                                .offset(y = 140.dp, x = 210.dp)
                                .border(3.dp, Color(0xFF020075), RoundedCornerShape(30.dp)),
                            shape = RoundedCornerShape(30.dp)
                        ) {}
                    }

                    IconButton(onClick = { }) {}
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Button(
                        colors = ButtonDefaults.buttonColors(Color(0xFF213787)),
                        onClick = {
                            if (nota.text.isNotEmpty()) {
                                val novaNota = Postagem(
                                    conteudo = nota.text,
                                    idUsuario = 2
                                ) // Ajuste o ID conforme necessário
                                notaService.adicionarNota(novaNota)
                                    .enqueue(object : Callback<NotaResponse> {
                                        override fun onResponse(
                                            call: Call<NotaResponse>,
                                            response: Response<NotaResponse>
                                        ) {
                                            Log.i("calma", response.toString())
                                            if (response.isSuccessful) {
                                                Toast.makeText(
                                                    context,
                                                    "Nota adicionada com sucesso!",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                                controleNavegacao.navigate("telaNotas/{id")
                                            } else {
                                                Toast.makeText(
                                                    context,
                                                    "Erro ao adicionar nota.",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }

                                        override fun onFailure(
                                            call: Call<NotaResponse>,
                                            t: Throwable
                                        ) {
                                            Log.i("Calma", t.message.toString())
                                            Toast.makeText(
                                                context,
                                                "Falha na comunicação com o servidor.",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    })
                            } else {
                                Toast.makeText(
                                    context,
                                    "A nota não pode estar vazia.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        },
                        modifier = Modifier
                            .height(50.dp)
                            .width(160.dp),
                        shape = RoundedCornerShape(7.dp)
                    ) {
                        Text(
                            text = "Postar nota",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                        Image(
                            painter = painterResource(id = R.drawable.send),
                            contentDescription = "Enviar nota",
                            modifier = Modifier
                                .size(24.dp)
                                .padding(start = 8.dp)
                        )
                    }
                }
            }
        }

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
                    controleNavegacao.navigate("landingPageChat")
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
                    controleNavegacao.navigate("telaDiario")
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
                    controleNavegacao.navigate("telaAutoajuda")
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
                    controleNavegacao.navigate("telaAutoajuda")
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

