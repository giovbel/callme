package br.senai.sp.jandira.callme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun landingPageChat(controleNavegacao: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .clickable { controleNavegacao.navigate("telaNotas") }
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFE3EFFF),
                            Color(0xFFD1E1FA),
                            Color(0xFF275BC8)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                Box(
                    modifier = Modifier
                        .height(75.dp)
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
                            .fillMaxWidth(),
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
                        ) { }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {},
                        modifier = Modifier.background(Color.Transparent),
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                    ) {
                        Text(
                            text = "Conversas",
                            fontSize = 18.sp,
                            color = Color(0xFF215CB9),
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier.background(Color.Transparent),
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
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.macallmechat),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(170.dp)
                            .padding(top = 18.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Vamos conversar?\nComece aqui!",
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF00307C),
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
            Row(
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
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
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
                    onClick = {},
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
                    onClick = {},
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
                    onClick = {},
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
                    onClick = {},
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
