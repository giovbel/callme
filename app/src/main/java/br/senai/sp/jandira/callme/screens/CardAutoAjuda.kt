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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun telaCardAutoAjuda(controleNavegacao: NavHostController) {

    var conteudo by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()


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
                    modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    BasicTextField(
                        value = conteudo,
                        onValueChange = { novoValor ->
                            conteudo = novoValor
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .background(Color.Transparent),
                        decorationBox = { innerTextField ->
                            Box(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                if (conteudo.isEmpty()) {
                                    Text(
                                        "O que você procura?",
                                        color = Color(0xFF97B3DF),
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .align(Alignment.CenterStart)
                                    )
                                }
                                innerTextField()
                            }
                        }
                    )


                    Image(
                        painter = painterResource(id = R.drawable.searchicon),
                        contentDescription = "",
                        modifier = Modifier
                            .height(25.dp)
                            .width(25.dp)
                    )
                }

            }

            Spacer(modifier = Modifier.height(25.dp))

                Card (
                    modifier = Modifier
                        .height(600.dp)
                        .width(350.dp)
                        .shadow(8.dp, RoundedCornerShape(10.dp), clip = false)
                        .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
                    colors = CardDefaults.cardColors(Color(0xFFF2F5F8)),
                ){
                    Card (
                        modifier = Modifier
                            .height(190.dp)
                            .fillMaxWidth()
                            .border(2.dp, Color(0xFF6188C5), RoundedCornerShape(10.dp)),
                        colors = CardDefaults.cardColors(Color(0xFFAECAE6)),
                    ){

                    }
                    Column (

                        modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                        verticalArrangement = Arrangement.SpaceBetween,

                        ) {
                        Column(modifier = Modifier.fillMaxSize()) {

                            Column(
                                modifier = Modifier
                                    .width(350.dp)
                                    .weight(1f)
                                    .verticalScroll(scrollState)
                            ) {
                                Text(
                                    text = "Como lidar com a ansiedade",
                                    color = Color(0xFF2754B2),
                                    fontSize = 23.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                Text(
                                    text = "A ansiedade é um problema cada vez mais recorrente entre a população global. O problema é ainda maior em território nacional, já que o Brasil é considerado o país mais ansioso do mundo. Aproximadamente 9,3% dos brasileiros sofrem da patologia, segundo a Organização Mundial da Saúde (OMS). \n" +
                                            "Segundo a Dra. Karen Valéria da Silva, coordenadora de psicologia da Docway, os transtornos ansiosos têm se proliferado devido à rotina atribulada que muitas pessoas levam atualmente, com a pressão de realizar múltiplas tarefas ao mesmo tempo. Além disso, o período de pandemia que vivenciamos intensificou os sintomas desses transtornos, inclusive os físicos.\n",
                                    fontSize = 13.3.sp,
                                    color = Color(0xFF1F55C6),
                                    fontWeight = FontWeight.Medium
                                )
                            }


                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 6.dp, bottom = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Card(
                                    modifier = Modifier
                                        .height(25.dp)
                                        .width(25.dp)
                                        .clip(RoundedCornerShape(100.dp))
                                ) {

                                }

                                Spacer(modifier = Modifier.width(4.dp))

                                Text(text = "Murilo Carolino", fontSize = 11.sp)
                            }
                        }
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