package br.senai.sp.jandira.callme.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.callme.R


@Composable
fun telaDiario() {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        Card (
            modifier = Modifier.height(70.dp).fillMaxWidth(),
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(Color(0xFF213787))
        ){
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier.height(60.dp).width(60.dp)
                )
                Text(
                    text = "MEU DIÁRIO",
                    fontSize = 20.sp,
                    color = Color(0xFFBCE0F6),
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
            modifier = Modifier.fillMaxWidth().height(630.dp),
            colors = CardDefaults.cardColors(Color(0xFFE3EFFF)),
            shape = RoundedCornerShape(0.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
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
                            .fillMaxSize().padding(start = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            modifier = Modifier
                                .height(70.dp)
                                .width(66.dp),
                            colors = CardDefaults.cardColors(Color(0xFFC7DEFF)),
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
                            Row ()
                            {
                                Text(
                                    text = "Eu quero comer batata",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color(0xFF2755B2),
                                    modifier = Modifier.padding(start = 16.dp).width(190.dp)
                                        .fillMaxWidth(),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                                Text(
                                    text = "30/08/24",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    color = Color(0xFF2755B2),
                                    modifier = Modifier.padding(start = 16.dp, end = 10.dp)
                                )
                            }

                            Spacer(modifier = Modifier.size(5.dp))
                            Text(
                                text = "So my fiancé(F34) and I(m27) have been dating for almost 5 years and have been engaged for about 9 mo...",
                                fontSize = 11.sp,
                                lineHeight = 15.sp,
                                color = Color(0xFF1E4189),
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                                    .fillMaxWidth(),
                                maxLines = 3,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
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
                            .fillMaxSize().padding(start = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            modifier = Modifier
                                .height(70.dp)
                                .width(66.dp),
                            colors = CardDefaults.cardColors(Color(0xFFC7DEFF)),
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
                                    text = "Eu quero viver a vida",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color(0xFF2755B2),
                                    modifier = Modifier.padding(start = 16.dp).width(190.dp)
                                        .fillMaxWidth(),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                                Text(
                                    text = "31/08/24",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    color = Color(0xFF2755B2),
                                    modifier = Modifier.padding(start = 16.dp, end = 10.dp)
                                )
                            }

                            Spacer(modifier = Modifier.size(5.dp))
                            Text(
                                text = "So my fiancé(F34) and I(m27) have been dating for almost 5 years and have been engaged for about 9 mo...",
                                fontSize = 11.sp,
                                lineHeight = 15.sp,
                                color = Color(0xFF1E4189),
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                                    .fillMaxWidth(),
                                maxLines = 3,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
            }
        }

        Card (
            modifier = Modifier.height(70.dp).fillMaxWidth(),
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(Color(0xFF213787))
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
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
}}

