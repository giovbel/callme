package br.senai.sp.jandira.callme.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R

@Composable
fun telaEscolherAvatar(controleNavegacao: NavHostController, id: String) {
    // Estado para armazenar o avatar selecionado
    var selectedAvatar by remember { mutableStateOf<Int?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFE3EFFF),
                        Color(0xFF275BC8)
                    )
                )
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Para finalizar seu cadastro,\n escolha um avatar:",
                    fontSize = 19.sp,
                    color = Color(0xFF04276D),
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(20.dp))
                Card(
                    modifier = Modifier
                        .height(170.dp)
                        .width(170.dp)
                        .border(
                            5.dp,
                            color = Color(0xFF658EC7),
                            shape = RoundedCornerShape(100.dp)
                        ),
                    shape = RoundedCornerShape(100.dp)
                ) {
                    selectedAvatar?.let {
                        Image(
                            painter = painterResource(id = it),
                            contentDescription = "Avatar Selecionado",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFE7ECF8))
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    item {
                        // Primeira linha de avatares
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                16.dp,
                                Alignment.CenterHorizontally
                            ),
                        ) {
                            listOf(
                                R.drawable.avataraaa,
                                R.drawable.avatar,
                                R.drawable.avataraa
                            ).forEach { avatarId ->
                                Card(
                                    modifier = Modifier
                                        .height(120.dp)
                                        .width(120.dp)
                                        .clickable {
                                            selectedAvatar = avatarId
                                        },
                                    colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                                ) {
                                    Image(
                                        painter = painterResource(id = avatarId),
                                        contentDescription = "Avatar",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Segunda linha de avatares
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                16.dp,
                                Alignment.CenterHorizontally
                            )
                        ) {
                            listOf(
                                R.drawable.cinco,
                                R.drawable.um,
                                R.drawable.dois
                            ).forEach { avatarId ->
                                Card(
                                    modifier = Modifier
                                        .height(120.dp)
                                        .width(120.dp)
                                        .clickable {
                                            selectedAvatar = avatarId
                                        },
                                    colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                                ) {
                                    Image(
                                        painter = painterResource(id = avatarId),
                                        contentDescription = "Avatar",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Terceira linha de avatares
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                16.dp,
                                Alignment.CenterHorizontally
                            )
                        ) {
                            listOf(
                                R.drawable.tres,
                                R.drawable.quatro,
                                R.drawable.avataraaaaaa
                            ).forEach { avatarId ->
                                Card(
                                    modifier = Modifier
                                        .height(120.dp)
                                        .width(120.dp)
                                        .clickable {
                                            selectedAvatar = avatarId
                                        },
                                    colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                                ) {
                                    Image(
                                        painter = painterResource(id = avatarId),
                                        contentDescription = "Avatar",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color(0xFFBBD1FF)),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF658EC7)),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Finalizar",
                        fontSize = 19.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(id = R.drawable.finalizar),
                        contentDescription = "Finalizar",
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .clickable {
                                controleNavegacao.navigate("telaNotas/${id}")
                            }
                    )

                }
            }
        }
    }
}
