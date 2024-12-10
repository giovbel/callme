package br.senai.sp.jandira.callme.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.callme.R
import br.senai.sp.jandira.callme.model.ResultAvatares
import br.senai.sp.jandira.callme.service.RetrofitFactory
import coil.compose.rememberImagePainter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun telaPerfil(controleNavegacao: NavHostController) {
    // Lista de URLs dos avatares (usando mutableStateListOf)
    val avatarUrls = remember { mutableStateListOf<String>() }
    var nomeState by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        RetrofitFactory.getClienteService().getAvatares().enqueue(object : Callback<ResultAvatares> {

            override fun onResponse(call: Call<ResultAvatares>, response: Response<ResultAvatares>) {
                if (response.isSuccessful) {
                    response.body()?.let { avatares ->
                        // Acessando a lista de dados
                        avatares.dados?.let { listaDeAvatares ->
                            avatarUrls.clear() // Limpa a lista antes de adicionar novos itens

                            // Adicionando cada URL de imagem à lista
                            listaDeAvatares.forEach { avatar ->
                                avatar.img?.let { imgUrl ->
                                    if (imgUrl.startsWith("http")) {
                                        avatarUrls.add(imgUrl) // Adiciona URLs válidas
                                    } else {
                                        Log.e("Avatar Error", "URL inválida: $imgUrl")
                                    }
                                }
                            }

                            // Verificar no log as URLs adicionadas
                            Log.d("Avatar URLs", avatarUrls.toString())
                        } ?: run {
                            Log.e("Avatar Error", "Lista de avatares está vazia.")
                        }
                    }
                } else {
                    Toast.makeText(
                        controleNavegacao.context,
                        "Falha ao carregar avatares",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<ResultAvatares>, t: Throwable) {
                Toast.makeText(controleNavegacao.context, "Erro: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFC3D9FF),
                        Color(0xFF1B55CD),
                    )
                )
            )
    ) {
        // Barra superior com título
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
                    text = "MEU PERFIL",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
                Card(
                    modifier = Modifier
                        .size(50.dp)
                        .border(4.dp, Color(0xFF9DBFEF), CircleShape),
                    shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.quatro),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }


        Text(
            text = "Escolha seu avatar",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            fontSize = 18.sp,
            color = Color(0xFF1B55CD),
            fontWeight = FontWeight.Bold
        )


        LazyRow(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(avatarUrls.size) { index ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = avatarUrls[index],
                            builder = {
                                crossfade(true)

                            }
                        ),
                        contentDescription = "Avatar $index",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(630.dp),
            colors = CardDefaults.cardColors(Color(0xFFE3EFFF)),
            shape = RectangleShape
        ) {


            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(500.dp)
                        .border(5.dp, Color(0xFF5A8AD6)),
                    colors = CardDefaults.cardColors(Color.Transparent)
                ) {



                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                    ) {
                        Card (

                            modifier = Modifier
                                .height(100.dp)
                                .width(90.dp)
                                .padding(top = 12.dp)
                                .border(5.dp, Color(0xFF1F55C6), CircleShape)
                                .align(Alignment.TopCenter),
                            shape = CircleShape
                        ){

                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .padding(bottom = 12.dp)
                                    .border(3.dp, Color(0xFF1F55C6), CircleShape)
                                    .height(50.dp),
                                colors = CardDefaults.cardColors(Color(0xFF8CBAFF)),
                                shape = CircleShape
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    ) {
                                    Card(
                                        modifier = Modifier
                                            .width(95.dp)
                                            .fillMaxHeight(),
                                        colors = CardDefaults.cardColors(Color(0xFF2755B2)),
                                        shape = RoundedCornerShape(
                                            topStart = 16.dp,
                                            bottomStart = 16.dp
                                        )
                                    ) {
                                        Box(
                                            modifier = Modifier.fillMaxSize(),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Nome",
                                                fontSize = 16.sp,
                                                color = Color.White,
                                                fontWeight = FontWeight.Medium
                                            )
                                        }

                                    }
                                }
                            }



                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .padding(bottom = 12.dp)
                                    .border(3.dp, Color(0xFF1F55C6), CircleShape)
                                    .height(50.dp),
                                colors = CardDefaults.cardColors(Color(0xFF8CBAFF)),
                                shape = CircleShape
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    ) {
                                    Card(
                                        modifier = Modifier
                                            .width(95.dp)
                                            .fillMaxHeight(),
                                        colors = CardDefaults.cardColors(Color(0xFF2755B2)),
                                        shape = RoundedCornerShape(
                                            topStart = 16.dp,
                                            bottomStart = 16.dp
                                        )
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                            ,

                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "E-mail",
                                                fontSize = 16.sp,
                                                color = Color.White,
                                                fontWeight = FontWeight.Medium
                                            )
                                        }

                                    }
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .padding(bottom = 12.dp)
                                    .border(3.dp, Color(0xFF1F55C6), CircleShape)
                                    .height(50.dp),
                                colors = CardDefaults.cardColors(Color(0xFF8CBAFF)),
                                shape = CircleShape
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    ) {
                                    Card(
                                        modifier = Modifier
                                            .width(95.dp)
                                            .fillMaxHeight(),
                                        colors = CardDefaults.cardColors(Color(0xFF2755B2)),
                                        shape = RoundedCornerShape(
                                            topStart = 16.dp,
                                            bottomStart = 16.dp
                                        )
                                    ) {
                                        Box(
                                            modifier = Modifier.fillMaxSize(),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Senha",
                                                fontSize = 16.sp,
                                                color = Color.White,
                                                fontWeight = FontWeight.Medium
                                            )

//                                            OutlinedTextField(
//                                                value = nomeState,
//                                                onValueChange ={ nomeState = it},
//                                                colors = OutlinedTextFieldDefaults.colors(
//                                                    unfocusedBorderColor = Color.Transparent,
//                                                    focusedBorderColor = Color.Transparent
//                                                ),
//                                                modifier = Modifier.fillMaxWidth()
//                                            )
                                        }


                                    }
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .width(300.dp)
                                    .border(3.dp, Color(0xFF1F55C6), CircleShape)
                                    .height(50.dp),
                                colors = CardDefaults.cardColors(Color(0xFF8CBAFF)),
                                shape = CircleShape
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),

                                    ) {
                                    Card(
                                        modifier = Modifier
                                            .width(120.dp)
                                            .fillMaxHeight(),
                                        colors = CardDefaults.cardColors(Color(0xFF2755B2)),
                                        shape = RoundedCornerShape(
                                            topStart = 16.dp,
                                            bottomStart = 16.dp
                                        )
                                    ) {
                                        Box(
                                            modifier = Modifier.fillMaxSize(),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Nascimento",
                                                fontSize = 16.sp,
                                                color = Color.White,
                                                fontWeight = FontWeight.Medium
                                            )
                                        }

                                    }
                                }
                            }
                        }





                        Button(
                            onClick = { },
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth()
                                .padding(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF213787))
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.historico),
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Ver histórico de notas", color = Color.White)
                            }
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
                        controleNavegacao.navigate("landingPageChat")
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
                    onClick = {controleNavegacao.navigate("telaDiario")
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
                        controleNavegacao.navigate("telaAutoajuda")
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
                    onClick = { controleNavegacao.navigate("telaAutoajuda")
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

@Preview(showBackground = true)
@Composable
fun Preview() {
    telaPerfil(controleNavegacao = rememberNavController())
}