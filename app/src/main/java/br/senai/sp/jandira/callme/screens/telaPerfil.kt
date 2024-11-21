package br.senai.sp.jandira.callme.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
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
                        painter = painterResource(id = R.drawable.perfilcomum),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        // Título para seleção de avatar
        Text(
            text = "Escolha seu avatar",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            fontSize = 18.sp,
            color = Color(0xFF1B55CD),
            fontWeight = FontWeight.Bold
        )

        // Exibição dos avatares (LazyRow)
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
                        .background(Color.LightGray) // Cor de fundo caso a imagem não carregue
                ) {
                    // Carregando a imagem com Coil
                    Image(
                        painter = rememberImagePainter(
                            data = avatarUrls[index],
                            builder = {
                                crossfade(true) // Animação de transição
                              //  placeholder(R.drawable.placeholder_avatar) // Imagem de placeholder
                             //   error(R.drawable.error_avatar) // Imagem caso ocorra erro
                            }
                        ),
                        contentDescription = "Avatar $index",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }


        Spacer(modifier = Modifier.height(20.dp))

        // Botão para ver histórico de notas
        Button(
            onClick = { /* Navegar para o histórico de notas */ },
            modifier = Modifier
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
