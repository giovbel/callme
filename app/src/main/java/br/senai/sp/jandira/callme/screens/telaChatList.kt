package br.senai.sp.jandira.callme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R

@Composable
fun telaChatList(controleNavegacao: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDF5FF))
    ) {
        // Top bar
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
                ) {}
            }
        }

        // Main content
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Permite que o footer vá até o final da tela
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFEDF5FF),
                                Color(0xFFA5D3FF),
                            )
                        ),
                    )
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { /* ação ao clicar em Conversas */ },
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
                    Image(
                        painter = painterResource(id = R.drawable.macallmenotelefone),
                        contentDescription = "",
                        modifier = Modifier.size(70.dp)
                    )
                    Button(
                        onClick = { /* ação ao clicar em Psicólogos */ },
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

                Row(
                    modifier = Modifier
                        .height(90.dp)
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier
                            .height(80.dp)
                            .width(80.dp)
                            .border(width = 2.dp, color = Color(0xFF3758C3), shape = CircleShape),
                        shape = CircleShape
                    ) {}
                    Column(
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text(
                            text = "Luana Santos",
                            color = Color(0xFF215CB9),
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "oi")
                    }
                }

                HorizontalDivider(color = Color(0xFF3758C3), thickness = 2.dp)
            }
        }

        // Footer bar
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
                FooterButton(iconResId = R.drawable.calendarioicon)
                FooterButton(iconResId = R.drawable.chaticon)
                FooterButton(iconResId = R.drawable.diarioicon)
                FooterButton(iconResId = R.drawable.autoajuda)
                FooterButton(iconResId = R.drawable.doacaoicon)
            }
        }
    }
}

@Composable
fun FooterButton(iconResId: Int) {
    Button(
        onClick = { /* ação do botão */ },
        modifier = Modifier
            .size(72.dp)
            .background(Color.Transparent),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = "",
            modifier = Modifier.size(60.dp)
        )
    }
}
