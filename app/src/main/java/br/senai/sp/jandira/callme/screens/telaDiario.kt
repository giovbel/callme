package br.senai.sp.jandira.callme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.callme.R




@Composable
fun telaDiario(controleNavegacao: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Top bar
        Card(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(Color(0xFF213787))
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
                    text = "MEU DIÁRIO",
                    fontSize = 20.sp,
                    color = Color(0xFFBCE0F6)
                )
                Card(
                    modifier = Modifier
                        .size(50.dp)
                        .border(4.dp, Color(0xFF9DBFEF), RoundedCornerShape(30.dp)),
                    shape = RoundedCornerShape(100.dp)
                ) {}
            }
        }

        // Main content
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Adicionando weight para ocupar o restante da tela
            colors = CardDefaults.cardColors(Color(0xFFE3EFFF)),
            shape = RoundedCornerShape(0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                DiaryEntry(
                    title = "Eu quero comer batata",
                    date = "30/08/24",
                    content = "So my fiancé(F34) and I(m27) have been dating for almost 5 years and have been engaged for about 9 mo..."
                )
                Spacer(modifier = Modifier.height(16.dp))
                DiaryEntry(
                    title = "Eu quero viver a vida",
                    date = "31/08/24",
                    content = "So my fiancé(F34) and I(m27) have been dating for almost 5 years and have been engaged for about 9 mo..."
                )
            }
        }

        @Composable
        fun MyFloatingActionButton(onClick: () -> Unit) {
            FloatingActionButton(
                onClick = onClick,
                containerColor = Color(0xFF1F55C6),
                modifier = Modifier.padding(16.dp)
                    .clickable { controleNavegacao.navigate("telaCriarPostDiario") },
            ) {
                // Adicionando um ícone de "+"
                Icon(
                    imageVector = Icons.Default.Add, // Usando o ícone padrão de "+"
                    contentDescription = "Adicionar entrada"
                )
            }
        }

        Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE3EFFF)),
                horizontalArrangement = Arrangement.End,
            ) {
                MyFloatingActionButton(onClick = {


                })
            }


        // Bottom bar
        Card(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(Color(0xFF213787))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                BottomBarButton(iconResId = R.drawable.calendarioicon)
                BottomBarButton(iconResId = R.drawable.chaticon)
                BottomBarButton(iconResId = R.drawable.diarioicon)
                BottomBarButton(iconResId = R.drawable.autoajuda)
                BottomBarButton(iconResId = R.drawable.doacaoicon)
            }


        }





    }
}}

@Composable
fun DiaryEntry(title: String, date: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .border(1.dp, Color(0xFF1F55C6), RoundedCornerShape(0.dp)),
        colors = CardDefaults.cardColors(Color.Transparent),
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .height(70.dp)
                    .width(66.dp),
                colors = CardDefaults.cardColors(Color(0xFFC7DEFF))
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.emojiicon),
                        contentDescription = "",
                        modifier = Modifier
                            .height(45.dp)
                            .width(60.dp)
                    )
                }



            }

            Column {
                Row {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color(0xFF2755B2),
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(190.dp)
                            .fillMaxWidth(),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = date,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color(0xFF2755B2),
                        modifier = Modifier.padding(start = 16.dp, end = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.size(5.dp))

                Text(
                    text = content,
                    fontSize = 11.sp,
                    lineHeight = 15.sp,
                    color = Color(0xFF1E4189),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun BottomBarButton(iconResId: Int) {
    Button(
       onClick = { //controleNavegacao.navigate("telaCriarPostDiario")
            },
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

