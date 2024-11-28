package br.senai.sp.jandira.callme.screens

import android.util.Log
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
fun telaCadastro(controleNavegacao: NavHostController) {
    var isChecked by remember { mutableStateOf(false) }
    var nomeState by remember { mutableStateOf("") }
    var emailState by remember { mutableStateOf("") }
    var senhaState by remember { mutableStateOf("") }
    var confirmaSenhaState by remember { mutableStateOf("") }

    var CPFState by remember { mutableStateOf("") }
    var datadenascimentoState by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFE3EFFF),
                        Color(0xFF275BC8)
                    )
                )
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
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
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Para se cadastrar preencha os \n campos abaixo:",
                    fontSize = 19.sp,
                    color = Color(0xFF04276D),
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            // Campos de entrada
            CampoCadastro(label = "Nome", value = nomeState, onValueChange = { nomeState = it })
            Spacer(modifier = Modifier.height(16.dp))
            CampoCadastro(label = "E-mail", value = emailState, onValueChange = { emailState = it })
            Spacer(modifier = Modifier.height(16.dp))
            CampoCadastro(label = "Senha", value = senhaState, onValueChange = { senhaState = it })
            Spacer(modifier = Modifier.height(16.dp))
            CampoCadastro(label = "Confirmar Senha", value = confirmaSenhaState, onValueChange = { confirmaSenhaState = it })
            Spacer(modifier = Modifier.height(16.dp))
            CampoCadastro(label = "CPF", value = CPFState, onValueChange = { CPFState = it })
            Spacer(modifier = Modifier.height(16.dp))
            CampoCadastro(label = "Data nascimento", value = datadenascimentoState, onValueChange = { datadenascimentoState = it })
            Spacer(modifier = Modifier.height(16.dp))

            // Checkbox de termos
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it }
                )
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
            Spacer(modifier = Modifier.height(2.dp))

            // Botão de criar conta
            Button(
                onClick = {  val nascimento = datadenascimentoState
                    var dataNascimento = ""
                    if (nascimento.contains("/")) {
                        //arruma o estilo da data pra mandar ela bonitinha pro back
                        val partes = nascimento.split("/")
                        val dia = partes[0]
                        val mes = partes[1]
                        val ano = partes[2]
                        dataNascimento = "$ano-$mes-$dia"
                        Log.i("323", dataNascimento)
                    } else {
//                        mensagemErroState =
//                            "O formato do campo data de nascimento está incorreto"
//                        umError.value = true
                        Log.i("CARALHO","127")
                    }
                    if (emailState == "" || nomeState == "" || datadenascimentoState == "" || senhaState == "" || confirmaSenhaState == "") {
//                        mensagemErroState = "Todos os campos devem ser preenchidos"
//                        umError = true
                        Log.i("CARALHO","127")

                    } else if (senhaState != confirmaSenhaState) {
//                        mensagemErroState = "Sua senha não confere"
//                        umError = true
                        Log.i("CARALHO","127")

                    } else if (senhaState.length > 8 || confirmaSenhaState.length > 8) {
//                        mensagemErroState = "Sua senha deve ter 8 caracteres"
//                        umError = true
                        Log.i("CARALHO","127")

                    } else if (datadenascimentoState.length > 10) {
//                        mensagemErroState =
//                            "O formato do campo data de nascimento está incorreto"
//                        umError = true
                        Log.i("CARALHO","127")

                    } else{
                    val cadastroCliente = Cliente(
                        nome = nomeState,
                        login = emailState,
                        senha = senhaState,
                        cpf = CPFState,
                        nascimento =  dataNascimento,
                        idAvatar = 1
                    )
                    cadastrarUsuario(cadastroCliente, controleNavegacao)}
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFE2EFFF)),
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

@Composable
fun CampoCadastro(label: String, value: String, onValueChange: (String) -> Unit) {
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
                    .width(128.dp)
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
                    text = label,
                    fontSize = 17.sp,
                    color = Color(0xFFFFFFFF),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 20.dp)
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

private fun cadastrarUsuario(cadastroCliente: Cliente, controleNavegacao: NavHostController) {
    val clienteService = RetrofitFactory.getClienteService()

    clienteService.cadastrarCliente(cadastroCliente).enqueue(object : Callback<ClienteResponse> {
        override fun onResponse(call: Call<ClienteResponse>, response: Response<ClienteResponse>) {
            if (response.isSuccessful) {
                Log.d("Cadastro", "Cadastro realizado com sucesso!")
                controleNavegacao.navigate("telaLogin")
            } else {
                Log.e("Cadastro", "Falha ao cadastrar: ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(call: Call<ClienteResponse>, t: Throwable) {
            Log.e("Cadastro", "Erro de rede: ${t.message}")
        }
    })
}
