package br.senai.sp.jandira.callme.screens

import android.graphics.drawable.Icon
import android.os.Bundle
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R


@Composable
fun telaChatPsicologo(controleNavegacao: NavHostController) {

    val rating = 5

    Column(
        modifier = Modifier
            .fillMaxSize()
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
                .height(780.dp)
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .background(Color.Transparent),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Text(
                        text = "Conversas",
                        fontSize = 18.sp,
                        color = Color(0xFF215CB9),
                        fontWeight = FontWeight.Medium

                    )

                }
                Image(
                    painter = painterResource(id = R.drawable.macallmenotelefone),
                    contentDescription = "",
                    modifier = Modifier.size(70.dp)
                )

                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .background(Color.Transparent),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Text(
                        text = "Psicólogos",
                        fontSize = 18.sp,
                        color = Color(0xFF215CB9),
                        fontWeight = FontWeight.Medium
                    )
                }


            }
            HorizontalDivider(color = Color(0xFF3758C3), thickness = 2.dp)

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .height(200.dp)
                        .width(350.dp)
                        .padding(top = 20.dp)
                        .border(2.dp, color = Color(0xFF2961D5), RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(Color.Transparent)
                ) {
                    Column {
                        Text(
                            text = "Atendimento em casos de crise",
                            fontSize = 15.sp,
                            color = Color(0xFF093C7D),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 12.dp, top = (6.dp))
                        )

                        HorizontalDivider(color = Color(0xFF3758C3), thickness = 2.dp)

                            Row (
                                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                            ){
                                Card(
                                    modifier = Modifier
                                        .height(62.dp)
                                        .width(62.dp)
                                        .border(
                                            2.dp,
                                            color = Color(0xFF0B2874),
                                            RoundedCornerShape(100.dp)
                                        ),

                                    shape = RoundedCornerShape(100.dp),
                                ) {}
                                Column (){
                                    Text(
                                        text = "Marta Luana Martins",
                                        fontSize = 16.sp,
                                        color = Color(0xFF2754B2),
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 12.dp, top = (6.dp))
                                    )

                                    Row(modifier = Modifier.padding(start = 8.dp)) {
                                        for (i in 1..5) {
                                            if (i <= rating) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.estrelas),
                                                    contentDescription = "",
                                                    modifier = Modifier
                                                        .height(20.dp)
                                                        .width(20.dp)
                                                )
                                            } else {
                                                Image(
                                                    painter = painterResource(id = R.drawable.estrelasvazias),
                                                    contentDescription = "",
                                                    modifier = Modifier
                                                        .height(60.dp)
                                                        .width(60.dp)
                                                )
                                            }

                                        }
                                    }
                                }




                            }

                        Row (
                            modifier = Modifier
                        ){
                            Card (
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(270.dp),
                                colors = CardDefaults.cardColors(Color(0xFF2961D5))
                            ){

                            }


                            Card (
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(50.dp),
                                colors = CardDefaults.cardColors(Color(0xFF2961D5))
                            ){

                            }
                        }





                    }
                }


                    Card(
                        modifier = Modifier
                            .height(200.dp)
                            .width(350.dp)
                            .padding(top = 20.dp)
                            .border(2.dp, color = Color(0xFF2961D5), RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(Color.Transparent)
                    ) {

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


