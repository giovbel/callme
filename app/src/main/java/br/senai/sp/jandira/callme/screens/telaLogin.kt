package br.senai.sp.jandira.callme.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R
import br.senai.sp.jandira.callme.model.Cliente
import br.senai.sp.jandira.callme.model.ClienteResponse
import br.senai.sp.jandira.callme.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun telaLogin(navController: NavHostController) {
    val context = LocalContext.current
    var loginState by remember { mutableStateOf("") }
    var senhaState by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFE3EFFF), Color(0xFF275BC8))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp, 10.dp, 10.dp, 60.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(93.dp)
                        .padding(top = 23.dp),
                    alignment = Alignment.Center
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    textAlign = TextAlign.Center,
                    text = "Seja bem-vindo ao Callme!\nFaça seu login!",
                    fontSize = 22.sp,
                    color = Color(0xFF04276D),
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(id = R.drawable.macallmesonhando),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                        .padding(top = 16.dp),
                    alignment = Alignment.Center
                )
                Spacer(modifier = Modifier.height(40.dp))
                CampoTexto(label = "E-mail", value = loginState) { loginState = it }
                Spacer(modifier = Modifier.height(16.dp))
                CampoTexto(label = "Senha", value = senhaState) { senhaState = it }

                Button(
                    onClick = { navController.navigate("redefinirsenha") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(
                        text = "Esqueci minha senha",
                        color = Color(0xFF213787),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(12.dp)
                    )
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            val cliente = Cliente(login = loginState, senha = senhaState)
                            fazerLogin(cliente, navController, context)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFE2EFFF)),
                        modifier = Modifier
                            .width(300.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(size = 32.dp)
                    ) {
                        Text(
                            text = "Login",
                            color = Color(0xFF1F55C6),
                            fontSize = 20.sp
                        )
                    }
                    Card(
                        modifier = Modifier
                            .height(30.dp)
                            .width(230.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0x800B4ED7)),
                        shape = RoundedCornerShape(bottomEnd = 32.dp, bottomStart = 32.dp)
                    ) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Não tem conta? Faça seu cadastro",
                            fontSize = 13.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .clickable { navController.navigate("telaCadastro") }
                                .fillMaxHeight(),
                            lineHeight = 2.em
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CampoTexto(label: String, value: String, onValueChange: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Row {
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .background(Color(0xFF2755B2), shape = RoundedCornerShape(bottomEnd = 32.dp, topStart = 32.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = label,
                    fontSize = 17.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

private fun fazerLogin(cliente: Cliente, navController: NavHostController, context: Context) {
    val clienteService = RetrofitFactory.getClienteService().loginUsuario(cliente)

    clienteService./*loginUsuari(cliente)*/enqueue(object : Callback<ClienteResponse> {
        override fun onResponse(call: Call<ClienteResponse>, response: Response<ClienteResponse>) {
            if (response.isSuccessful) {
                navController.navigate("telaNotas")
                Toast.makeText(context, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Log.e("Login", "O login falhou: ${response.message()}")
                Toast.makeText(context, "Login falhou. Verifique suas credenciais.", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<ClienteResponse>, t: Throwable) {
            Log.e("Login", "Erro de rede: ${t.message}")
            Toast.makeText(context, "Erro de rede. Tente novamente.", Toast.LENGTH_SHORT).show()
        }
    })
}
