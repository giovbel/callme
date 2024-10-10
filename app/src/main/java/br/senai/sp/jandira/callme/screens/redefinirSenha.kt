package br.senai.sp.jandira.callme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R


@Composable
fun redefinirsenha(controleNavegacao: NavHostController){
    var teste = -10.dp;
    var teste1 = -10;

    var emailState = remember {
        mutableStateOf("")
    }
    var senhaState = remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
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
        Box(
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()

            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(top = 16.dp),
                        alignment = Alignment.Center
                    )




                    Spacer(modifier = Modifier.height(25.dp))




                    Text(
                        text = "Preencha os dados abaixo\npara solicitar a recuperação\nde senha",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF2755B2),
                        fontWeight = FontWeight.SemiBold,
                    )
                    Row(
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, top = 30.dp)
                    ) {


                        Text(
                            text = "Seu e-mail de acesso:",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Start,
                            color = Color(0xFF2755B2),
                            fontWeight = FontWeight.Normal,
                        )
                        Spacer(modifier = Modifier.height(50.dp))
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 24.dp),
                        shape = RoundedCornerShape(32.dp)
                    ) {
                        Row(
                            modifier = Modifier.background(color = Color(0xFFFFFFFF))
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(600.dp)
                                    .background(
                                        color = Color(0xFF2755B2),
                                        shape = RoundedCornerShape(
                                            bottomEnd = 32.dp,
                                            bottomStart = 32.dp,
                                            topStart = 32.dp
                                        )


                                    )
                            ) {
                                Text(
                                    textAlign = TextAlign.Center,
                                    text = "E-mail",
                                    fontSize = 17.sp,
                                    color = Color(0xFFFFFFFF),
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start = 20.dp)
                                )
                            }
                            Box {
                                OutlinedTextField(
                                    value = "", onValueChange = { emailState.value = it }, colors =
                                    OutlinedTextFieldDefaults.colors(
                                        unfocusedBorderColor =
                                        Color.Transparent, focusedBorderColor = Color.Transparent
                                    )
                                )


                            }
                        }


                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Column(

                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier.width(400.dp),
                    ) {
                        Text(
                            textAlign = TextAlign.Start,
                            text = "Você irá receber um e-mail no endereço informado acima contendo o procedimento para criar uma nova senha para esse usuário",
                            fontSize = 16.sp,
                            color = Color(0xff2755B2),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(start = 28.dp, end = 28.dp)
                        )

                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                            modifier = Modifier.padding(start = 20.dp),

                            ) {
                            Button(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults
                                    .buttonColors(
                                        containerColor = Color(0xFF2755B2)
                                    ),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .width(145.dp)
                                    .height(55.dp),
                                shape = RoundedCornerShape(size = 32.dp)
                            ) {
                                Text(
                                    text = "Enviar",
                                    color = Color(0xFFFFFFFF),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier
                                )

                            }

                            Card(
                                modifier = Modifier
                                    .offset(y = -20.dp)
                                    .width(145.dp)
                                    .height(34.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(0x800B4ED7)),
                                shape = RoundedCornerShape(
                                    bottomEnd = 32.dp,
                                    bottomStart = 32.dp,
                                ),

                                ) {


                            }
                        }


                    }

                }



                Image(
                    painter = painterResource(id = R.drawable.macallmepsicologobanana),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(135 .dp),
                    alignment = Alignment.BottomCenter
                )
            }
        }
    }

}













