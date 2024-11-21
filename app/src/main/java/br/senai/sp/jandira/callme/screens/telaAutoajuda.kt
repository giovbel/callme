package br.senai.sp.jandira.callme.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
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
fun telaAutojuda(controleNavegacao: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3EFFF)),
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
                    text = "AUTOAJUDA",
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

        Column (
            modifier = Modifier
                .height(775.dp)
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
           Card (
               modifier = Modifier
                   .width(400.dp)
                   .height(60.dp)
                   .shadow(8.dp, RoundedCornerShape(10.dp), clip = false)
                   .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
               colors = CardDefaults.cardColors(Color(0xFFF2F5F8)),
           ){
               Row (

               ){
                   Text(
                       text =  "O que você procura?",
                       fontSize = 18.sp,
                       color = Color(0xFF5C8FDF),
                       modifier = Modifier.fillMaxWidth(),
                       textAlign = TextAlign.Start,
                       fontWeight = FontWeight.Bold
                   )
               }

           }

            Spacer(modifier = Modifier.height(25.dp))

            Row {
                Card (
                    modifier = Modifier
                        .height(180.dp)
                        .width(180.dp)
                        .shadow(8.dp, RoundedCornerShape(10.dp), clip = false)
                        .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
                    colors = CardDefaults.cardColors(Color(0xFFF2F5F8)),
                ){
                    Card (
                        modifier = Modifier
                            .height(80.dp)
                            .fillMaxWidth()
                            .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
                        colors = CardDefaults.cardColors(Color(0xFFAECAE6)),
                    ){
                        
                    }
                    Column (

                        modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                        verticalArrangement = Arrangement.SpaceBetween,

                    ){
                        Column (
                            modifier = Modifier.height(60.dp)
                        ){
                            Text(text = "Como lidar com a ansiedade", color = Color(0xFF2754B2), fontWeight = FontWeight.Bold)
                        }

                        Row (

                        ){
                            Card (
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                                    .clip(RoundedCornerShape(100.dp))
                            ){

                            }
                            Spacer(modifier = Modifier.width(6.dp))

                            Text(text = "Murilo Carolino", fontSize = 11.sp)
                        }

                    }

                }
                Spacer(modifier = Modifier.width(16.dp))


                Card (
                    modifier = Modifier
                        .height(180.dp)
                        .width(180.dp)
                        .shadow(8.dp, RoundedCornerShape(10.dp), clip = false)
                        .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
                    colors = CardDefaults.cardColors(Color(0xFFF2F5F8)),
                ){
                    Card (
                        modifier = Modifier
                            .height(80.dp)
                            .fillMaxWidth()
                            .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
                        colors = CardDefaults.cardColors(Color(0xFFAECAE6)),
                    ){

                    }
                    Column (
                        modifier = Modifier.padding(start = 10.dp, top = 5.dp)
                    ){
                        Column (
                            modifier = Modifier.height(60.dp)
                        ){
                            Text(text = "Estou sem amigos...", color = Color(0xFF2754B2), fontWeight = FontWeight.Bold)
                        }

                        Row (
                            modifier = Modifier
                        ){
                            Card (
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                                    .clip(RoundedCornerShape(100.dp))
                            ){

                            }
                            Spacer(modifier = Modifier.width(6.dp))

                            Text(text = "Murilo Carolino", fontSize = 11.sp)
                        }

                    }
                }

            }
            Spacer(modifier = Modifier.height(25.dp))


            Card (
                modifier = Modifier
                    .height(170.dp)
                    .width(360.dp)
                    .shadow(8.dp, RoundedCornerShape(10.dp), clip = false)
                    .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
                colors = CardDefaults.cardColors(Color(0xFFF2F5F8)),
            ){
                Card (
                    modifier = Modifier
                        .height(90.dp)
                        .fillMaxWidth()
                        .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
                    colors = CardDefaults.cardColors(Color(0xFFAECAE6)),
                ){

                }
                Column (
                    modifier = Modifier.padding(start = 10.dp, top = 5.dp)
                ){
                    Column (
                        modifier = Modifier.height(40.dp)
                    ){
                        Text(text = "Como e vomito, preciso de ajuda!", color = Color(0xFF2754B2), fontWeight = FontWeight.Bold)
                    }

                    Row (
                        modifier = Modifier
                    ){
                        Card (
                            modifier = Modifier
                                .height(25.dp)
                                .width(25.dp)
                                .clip(RoundedCornerShape(100.dp))
                        ){

                        }
                        Spacer(modifier = Modifier.width(6.dp))

                        Text(text = "Murilo Carolino", fontSize = 11.sp)
                    }

                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row {
                Card (
                    modifier = Modifier
                        .height(180.dp)
                        .width(180.dp)
                        .shadow(8.dp, RoundedCornerShape(10.dp), clip = false)
                        .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
                    colors = CardDefaults.cardColors(Color(0xFFF2F5F8)),
                ){
                    Card (
                        modifier = Modifier
                            .height(90.dp)
                            .fillMaxWidth()
                            .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
                        colors = CardDefaults.cardColors(Color(0xFFAECAE6)),
                    ){

                    }
                    Column (
                        modifier = Modifier.padding(start = 10.dp, top = 5.dp)
                    ){
                        Column (
                            modifier = Modifier.height(50.dp)
                        ){
                            Text(text = "Quero me assumir.", color = Color(0xFF2754B2), fontWeight = FontWeight.Bold)
                        }

                        Row (
                            modifier = Modifier
                        ){
                            Card (
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                                    .clip(RoundedCornerShape(100.dp))
                            ){

                            }
                            Spacer(modifier = Modifier.width(6.dp))

                            Text(text = "Murilo Carolino", fontSize = 11.sp)
                        }

                    }
                }
                Spacer(modifier = Modifier.width(16.dp))

                Card (
                    modifier = Modifier
                        .height(180.dp)
                        .width(180.dp)
                        .shadow(8.dp, RoundedCornerShape(10.dp), clip = false)
                        .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
                    colors = CardDefaults.cardColors(Color(0xFFF2F5F8)),
                ){

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