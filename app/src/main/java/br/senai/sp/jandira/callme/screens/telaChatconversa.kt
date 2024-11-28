package br.senai.sp.jandira.callme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R

@Composable
fun telaChatConversa(controleNavegacao: NavHostController) {

    var conteudo by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE4EFFF))
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
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                )
                Text(
                    text = "CHAT",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )

                Card(
                    modifier = Modifier
                        .size(50.dp)
                        .border(4.dp, Color(0xFF9DBFEF), RoundedCornerShape(30.dp)),
                    shape = RoundedCornerShape(100.dp),
                ) {

                }
            }
        }


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFEDF5FF),
                            Color(0xFFEDF5FF),
                            Color(0xFFA5D3FF),
                        )
                    ),
                ),
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Column {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .border(1.5.dp, Color(0xFF3758C3), RoundedCornerShape(0.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.SpaceAround
                ){
                    Card(
                        modifier = Modifier
                            .size(50.dp)
                            .border(2.dp, Color(0xFF0C3386), RoundedCornerShape(30.dp)),
                        shape = RoundedCornerShape(100.dp),
                    ) {
                    }
                    Column {
                        Text(
                            text = "Giovanna Belo",
                            fontSize = 20.sp,
                            color = Color(0xFF2754B2),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Online",
                            fontSize = 15.sp,
                            color = Color(0xFF322074),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.telefone),
                        contentDescription = "chamada de voz",
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = "chamada de video",
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                    )
                    Card(
                        modifier = Modifier
                            .height(40.dp)
                            .width(70.dp),
                        colors = CardDefaults.cardColors(Color(0xFF2754B2))
                    ){
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ){
                            Text(
                                text = "0:00",
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Image(
                                painter = painterResource(id = R.drawable.relogio),
                                contentDescription = "chamada de voz",
                                modifier = Modifier
                                    .height(20.dp)
                                    .width(30.dp)
                            )
                        }

                    }
                }
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .padding(10.dp)
            ){
                Box(
                    modifier = Modifier
                        .height(55.dp)
                        .width(230.dp)
                        .align(Alignment.End)
                        .shadow(8.dp, shape = RoundedCornerShape(30.dp))
                        .border(2.dp, Color(0xFF4A6B9B), RoundedCornerShape(30.dp)),
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize(),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(Color(0xFF85A3DC)),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(40.dp),
                                shape = RoundedCornerShape(100.dp),
                            ) {
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "A vida é muito triste",
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                }

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .height(55.dp)
                        .width(120.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(30.dp))
                        .border(2.dp, Color(0xFF0044AA), RoundedCornerShape(30.dp))
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize(),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(Color(0xFF4A7DCD))
                    ) {
                        Row (
                            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Card(
                                modifier = Modifier
                                    .size(40.dp),
                                shape = RoundedCornerShape(100.dp),
                            ) {
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Oii",
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }

                    }

                }

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .height(55.dp)
                        .width(120.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(30.dp))
                        .border(2.dp, Color(0xFF0044AA), RoundedCornerShape(30.dp))
                ) {

                    Card(
                        modifier = Modifier
                            .fillMaxSize(),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(Color(0xFF4A7DCD))
                    ) {
                        Row (
                            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Card(
                                modifier = Modifier
                                    .size(40.dp),
                                shape = RoundedCornerShape(100.dp),
                            ) {
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Oii",
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }

                    }

                }




            }
            //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAAAAAAAAA

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .background(Color(0xFF2754B2), RoundedCornerShape(30.dp))
                    .shadow(4.dp, RoundedCornerShape(30.dp))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BasicTextField(
                        value = conteudo,
                        onValueChange = { novoValor ->
                            conteudo = novoValor
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .height(50.dp)
                            .background(Color.Transparent)
                            .padding(end = 16.dp),
                        decorationBox = { innerTextField ->
                            Box(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                if (conteudo.isEmpty()) {
                                    Text(
                                        text = "O que está acontecendo?",
                                        color = Color(0xFF97B3DF),
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .align(Alignment.CenterStart)
                                            .padding(start = 16.dp)
                                    )
                                }
                                innerTextField()
                            }
                        }
                    )


                    Image(
                        painter = painterResource(id = R.drawable.enviarmensagem),
                        contentDescription = "Enviar mensagem",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {

                                println("Mensagem enviada: $conteudo")
                                conteudo = ""
                            }
                    )
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

