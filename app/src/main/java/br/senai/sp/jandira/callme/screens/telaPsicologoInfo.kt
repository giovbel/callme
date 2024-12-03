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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R

@Composable
fun telaPsicologoInfo(controleNavegacao: NavHostController) {

    val rating = 5
    val scrollState = rememberScrollState()
    var conteudo by remember { mutableStateOf("") }


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
                    text = "INFORMAÇÕES",
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

            Row (
                modifier = Modifier.padding(top = 12.dp, start = 12.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.voltar),
                    contentDescription = "",
                    modifier = Modifier.size(35.dp)
                )
            }



            Column(
                modifier = Modifier.fillMaxWidth().verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .height(370.dp)
                        .width(360.dp)
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

                        Column(
                            modifier = Modifier.padding(start = 15.dp, top = 10.dp, end = 10.dp)
                        ){
                            Row(

                            ) {
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
                                Column() {
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

                            Text(
                                text = "Sou Maria Rozana de Lira Nogueira, tenho 60 anos. Casada, três filhos, 2 netos.\u2028Trabalho com a abordagem: Terapia Cognitiva Comportamental, que procura identificar e modificar pensamentos automáticos e distorcidos. Com foco no aqui - agora, procurando melhorar aspectos que estejam em desacordo com o desejado. ",
                                fontSize = 12.sp
                            )
                        }




                        Row(
                            modifier = Modifier.padding(start = 27.dp, top = 12.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .height(50.dp)
                                    .border(2.dp, color = Color.White, RoundedCornerShape(10.dp))
                                    .width(300.dp),
                                colors = CardDefaults.cardColors(Color(0xFF2961D5))
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Mandar mensagem",
                                        fontSize = 16.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 12.dp, top = (6.dp))
                                    )
                                }
                            }
                        }


                    }
                }
                val scrollState = rememberScrollState()
                var comment by remember { mutableStateOf("") }

                Card(
                    modifier = Modifier
                        .height(350.dp)
                        .width(360.dp)
                        .padding(top = 20.dp)
                        .border(2.dp, color = Color(0xFF2961D5), RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(Color.Transparent)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        // Título "Comentários"
                        Text(
                            text = "Comentários",
                            fontSize = 17.sp,
                            color = Color(0xFF2754B2),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 6.dp)
                        )

                        HorizontalDivider(color = Color(0xFF3758C3), thickness = 2.dp)


                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .verticalScroll(scrollState)
                                .padding(bottom = 10.dp)
                        ) {
                            // Comentário 1
                            Row(
                                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                            ) {
                                Card(
                                    modifier = Modifier
                                        .height(32.dp)
                                        .width(32.dp)
                                        .border(
                                            2.dp,
                                            color = Color(0xFF0B2874),
                                            RoundedCornerShape(100.dp)
                                        ),
                                    shape = RoundedCornerShape(100.dp),
                                ) {}
                                Column {
                                    Text(
                                        text = "****** ** *****",
                                        fontSize = 16.sp,
                                        color = Color(0xFF2754B2),
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 12.dp, top = (6.dp))
                                    )
                                    Text(
                                        text = "Muito boa profissional, me ajudou muito em apenas uma sessão, obrigado!! Indico muito.",
                                        fontSize = 12.sp
                                    )
                                }
                            }

                            // Comentário 2
                            Row(
                                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                            ) {
                                Card(
                                    modifier = Modifier
                                        .height(32.dp)
                                        .width(32.dp)
                                        .border(
                                            2.dp,
                                            color = Color(0xFF0B2874),
                                            RoundedCornerShape(100.dp)
                                        ),
                                    shape = RoundedCornerShape(100.dp),
                                ) {}
                                Column {
                                    Text(
                                        text = "****** ** *****",
                                        fontSize = 16.sp,
                                        color = Color(0xFF2754B2),
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 12.dp, top = (6.dp))
                                    )
                                    Text(
                                        text = "Muito boa profissional, me ajudou muito em apenas uma sessão, obrigado!! Indico muito.",
                                        fontSize = 12.sp
                                    )
                                }
                            }
                            // Comentário 3
                            Row(
                                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                            ) {
                                Card(
                                    modifier = Modifier
                                        .height(32.dp)
                                        .width(32.dp)
                                        .border(
                                            2.dp,
                                            color = Color(0xFF0B2874),
                                            RoundedCornerShape(100.dp)
                                        ),
                                    shape = RoundedCornerShape(100.dp),
                                ) {}
                                Column {
                                    Text(
                                        text = "****** ** *****",
                                        fontSize = 16.sp,
                                        color = Color(0xFF2754B2),
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 12.dp, top = (6.dp))
                                    )
                                    Text(
                                        text = "Muito boa profissional, me ajudou muito em apenas uma sessão, obrigado!! Indico muito.",
                                        fontSize = 12.sp
                                    )
                                }
                            }

                        }


                        Spacer(modifier = Modifier.height(12.dp))

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        Column(
                            modifier = Modifier
                                .width(340.dp)
                                .clip(RoundedCornerShape(30.dp))
                                .border(2.dp, Color(0xFF2961D5), RoundedCornerShape(30.dp))
                                .background(Color(0xFF92B1F1))
                        ) {
                            Spacer(modifier = Modifier.height(-10.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(45.dp)
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                BasicTextField(
                                    value = conteudo,
                                    onValueChange = { novoValor -> conteudo = novoValor },
                                    modifier = Modifier.fillMaxWidth(0.8f),
                                    decorationBox = { innerTextField ->
                                        Box(modifier = Modifier.fillMaxWidth()) {
                                            if (conteudo.isEmpty()) {
                                                Text(
                                                    "Enviar comentário",
                                                    color = Color(0xFFBEDEFF),
                                                    fontSize = 15.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.align(Alignment.CenterStart)
                                                )
                                            }
                                            innerTextField()
                                        }
                                    }
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.enviarmensagem),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(25.dp)
                                        .width(25.dp)
                                )
                            }
                        }


                        Spacer(modifier = Modifier.height(12.dp))
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
