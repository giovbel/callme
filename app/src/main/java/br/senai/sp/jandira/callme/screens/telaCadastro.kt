package br.senai.sp.jandira.callme.screens
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R

@Composable
fun telaCadastro(controleNavegacao: NavHostController) {
    var isChecked by remember { mutableStateOf(false) }
    var emailState by remember {
        mutableStateOf("")
    }




    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFE3EFFF),
                        Color(0xFF275BC8)


                    ),
                )
            )
    ) {
        Column (
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(93.dp)
                    .padding(top = 16.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    textAlign = TextAlign.Center,
                    text = "Para se cadastrar preencha os \n campos abaixo:",
                    fontSize = 19.sp,
                    color = Color(0xFF04276D),
                    fontWeight = FontWeight.Medium
                )


            }
            Spacer(modifier = Modifier.height(50.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(32.dp)
            ){
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
                            text = "Nome",
                            fontSize = 17.sp,
                            color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    OutlinedTextField(
                        value =  emailState,
                        onValueChange = {emailState = it},
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent)
                    )
                }




            }
            Spacer(modifier = Modifier.height(16.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(32.dp)
            ){
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
                            text = "E-mail",
                            fontSize = 17.sp,
                            color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent)
                    )
                }


            }
            Spacer(modifier = Modifier.height(16.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(32.dp)
            ){
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
                        value = "",
                        onValueChange = {},
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent)
                    )
                }


            }
            Spacer(modifier = Modifier.height(16.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(32.dp)
            ){
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
                            text = "Telefone",
                            fontSize = 17.sp,
                            color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent)
                    )
                }


            }
            Spacer(modifier = Modifier.height(16.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(32.dp)
            ){
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
                            text = "CPF",
                            fontSize = 17.sp,
                            color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent)
                    )
                }


            }
            Spacer(modifier = Modifier.height(16.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(32.dp)
            ){
                Row {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .width(190.dp)
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
                            text = "Data de nascimento",
                            fontSize = 17.sp,
                            color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent)
                    )
                }
            }


            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)


            ){


                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it }
                )


                Row (


                ){
                    Text(
                        text = "Aceito os",
                        color = Color(0xFFE3ECFF),
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(end = 4.dp, start = 2.dp)
                    )
                    Text(
                        text = "termos e condições",
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF0040C0)
                    )
                }




            }




            Spacer(modifier = Modifier.height(2.dp))


            Button(
                onClick = {controleNavegacao.navigate("telaLogin")},
                colors = ButtonDefaults
                    .buttonColors(
                        containerColor = Color(0XFFE2EFFF)
                    ),
                modifier = Modifier
                    .width(350.dp)
                    .height(97.dp)
                    .padding(start = 52.dp, end = 16.dp, top = 26.dp, bottom = 30.dp),
                shape = RoundedCornerShape(size = 32.dp)
            ) {
                Text(
                    text = "Criar Conta",
                    color = Color(0xFF1F55C6),
                    fontSize = 20.sp,
                    modifier = Modifier
                )


            }




        }




    }
}
