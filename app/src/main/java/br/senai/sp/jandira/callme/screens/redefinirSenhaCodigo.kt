package br.senai.sp.jandira.callme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R

@Composable
fun redefinirSenhaCodigo(controleNavegacao: NavHostController) {
    var codigoState1 by remember { mutableStateOf("") }
    var senhaState by remember { mutableStateOf("") }
    var mensagemErroState by remember { mutableStateOf("") }
    val codigoCorreto = "123456"

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
        Box {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
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

                // Campo de Código
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 24.dp),
                    shape = RoundedCornerShape(32.dp)
                ) {
                    Row {
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
                                text = "Código",
                                fontSize = 17.sp,
                                color = Color(0xFFFFFFFF),
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(start = 20.dp)
                            )
                        }
                        OutlinedTextField(
                            value = codigoState1,
                            onValueChange = { codigoState1 = it },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color.Transparent,
                                focusedBorderColor = Color.Transparent
                            )
                        )
                    }
                }

                // Campo de Senha
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 24.dp),
                    shape = RoundedCornerShape(32.dp)
                ) {
                    Row {
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
                                text = "Senha",
                                fontSize = 17.sp,
                                color = Color(0xFFFFFFFF),
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(start = 20.dp)
                            )
                        }
                        OutlinedTextField(
                            value = senhaState,
                            onValueChange = { senhaState = it },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color.Transparent,
                                focusedBorderColor = Color.Transparent
                            )
                        )
                    }
                }

                // Mensagem de erro
                if (mensagemErroState.isNotEmpty()) {
                    Text(
                        text = mensagemErroState,
                        color = Color.Red,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        if (codigoState1 != codigoCorreto) {
                            mensagemErroState = "Código incorreto! Talvez tenha se confundido."
                        } else {
                            mensagemErroState = "" // Limpa a mensagem se o código estiver correto
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2755B2)),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(145.dp)
                        .height(55.dp),
                    shape = RoundedCornerShape(size = 32.dp)
                ) {
                    Text(
                        text = "Enviar",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.macallmepsicologobanana),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(135.dp),
                    alignment = Alignment.BottomCenter
                )
            }
        }
    }
}
