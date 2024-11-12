package br.senai.sp.jandira.callme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R


@Composable
fun telaEscolherAvatar(navController: NavHostController) {
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
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(93.dp)
                    .padding(top = 16.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier.fillMaxWidth().height(350.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Para finalizar seu cadastro,\n escolha um avatar:",
                    fontSize = 19.sp,
                    color = Color(0xFF04276D),
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(70.dp))
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
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color(0xFFE7ECF8))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
                    ) {
                        Card(
                            modifier = Modifier
                                .height(120.dp)
                                .width(120.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                        ) {}
                        Card(
                            modifier = Modifier
                                .height(120.dp)
                                .width(120.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                        ) {}
                        Card(
                            modifier = Modifier
                                .height(120.dp)
                                .width(120.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                        ) {}
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
                    ) {
                        Card(
                            modifier = Modifier
                                .height(120.dp)
                                .width(120.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                        ) {}
                        Card(
                            modifier = Modifier
                                .height(120.dp)
                                .width(120.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                        ) {}
                        Card(
                            modifier = Modifier
                                .height(120.dp)
                                .width(120.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                        ) {}
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
                    ) {
                        Card(
                            modifier = Modifier
                                .height(120.dp)
                                .width(120.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                        ) {}
                        Card(
                            modifier = Modifier
                                .height(120.dp)
                                .width(120.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                        ) {}
                        Card(
                            modifier = Modifier
                                .height(120.dp)
                                .width(120.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFB3C8E7))
                        ) {}
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Row (
                        modifier = Modifier
                            .height(50.dp)
                            .width(200.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .align(Alignment.Center)
                            .background(Color(0xFFBBD1FF)),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Finalizar",
                            fontSize = 19.sp,
                            color = Color(0xFF04276D),
                            fontWeight = FontWeight.Medium
                        )
                        Image(
                            painter = painterResource(id = R.drawable.finalizar),
                            contentDescription = "",
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                        )
                    }

                }
            }

        }
    }
}