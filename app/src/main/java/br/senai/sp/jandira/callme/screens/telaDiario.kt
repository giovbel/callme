package br.senai.sp.jandira.callme.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R
import br.senai.sp.jandira.callme.model.diariolista
import br.senai.sp.jandira.callme.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun telaDiario(controleNavegacao: NavHostController, id: String) {
    var dadosState by remember { mutableStateOf(diariolista()) }
    RetrofitFactory.getDiarioService().getDiario(id=id.toInt()).enqueue(object : Callback<diariolista> {

        override fun onResponse(call: Call<diariolista>, response: Response<diariolista>) {
            if (response.isSuccessful) {
                if(response.body()!=null){
               dadosState= response.body()!!
                }
                else{

                }
            } else {
                Toast.makeText(
                    controleNavegacao.context,
                    "Falha ao carregar diario",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        override fun onFailure(call: Call<diariolista>, t: Throwable) {
            Toast.makeText(controleNavegacao.context, "Erro: ${t.message}", Toast.LENGTH_SHORT).show()
        }
    })

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top bar
            Card(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(Color(0xFF213787))
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
                        text = "MEU DIÁRIO",
                        fontSize = 20.sp,
                        color = Color(0xFFBCE0F6)
                    )
                    Card(
                        modifier = Modifier
                            .size(50.dp)
                            .border(4.dp, Color(0xFF9DBFEF), RoundedCornerShape(30.dp)),
                        shape = RoundedCornerShape(100.dp)
                    ) {}
                }
            }

            // Main content
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Adicionando weight para ocupar o restante da tela
                colors = CardDefaults.cardColors(Color(0xFFE3EFFF)),
                shape = RoundedCornerShape(0.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    dadosState.dados?.forEach{ item->
                        DiaryEntry(
                            title = item.titulo,
                            date = item.dataPublicacao,
                            content = item.conteudo,
                            classificacao = item.classificacao,
                            id=id.toInt(),
                            controleNavegacao = controleNavegacao
                        )
                    }
                }
            }

            // FloatingActionButton to create a new diary post
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE3EFFF)),
                horizontalArrangement = Arrangement.End,
            ) {

                MyFloatingActionButton(controleNavegacao = controleNavegacao,id=id)
            }

            // Bottom bar
            Card(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(Color(0xFF213787))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    BottomBarButton(iconResId = R.drawable.calendarioicon)
                    BottomBarButton(iconResId = R.drawable.chaticon)
                    BottomBarButton(iconResId = R.drawable.diarioicon)
                    BottomBarButton(iconResId = R.drawable.autoajuda)
                    BottomBarButton(iconResId = R.drawable.doacaoicon)
                }
            }
        }
    }
}

@Composable
fun MyFloatingActionButton(controleNavegacao: NavHostController,id:String) {
    FloatingActionButton(
        onClick = { controleNavegacao.navigate("telaCriarPostDiario/${id}") },
        containerColor = Color(0xFF1F55C6),
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Adicionar entrada"
        )
    }
}

@Composable
fun DiaryEntry(title: String, date: String, content: String,classificacao: Int,id:Int, controleNavegacao: NavHostController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { controleNavegacao.navigate("telaEditarpost/${id}") }
            .border(1.dp, Color(0xFF1F55C6), RoundedCornerShape(0.dp)),
        colors = CardDefaults.cardColors(Color.Transparent),
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .height(70.dp)
                    .width(66.dp),
                colors = CardDefaults.cardColors(Color(0xFFC7DEFF))
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val emoji=
                        if(classificacao==1){
                        painterResource(id = R.drawable.emojichorando)
                    }
                    else if(classificacao==2){
                        painterResource(id = R.drawable.emojitriste)

                    }
                    else if(classificacao==3){
                        painterResource(id = R.drawable.emojineutro)

                    } else if(classificacao==4){
                        painterResource(id = R.drawable.emojiok)

                    } else if(classificacao==5){
                        painterResource(id = R.drawable.emojifeliz)
                    }
                    else{
                        painterResource(id = R.drawable.emojiok)
                    }
                    Image(
                        painter = emoji,
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
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color(0xFF2755B2),
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(190.dp)
                            .fillMaxWidth(),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = date,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color(0xFF2755B2),
                        modifier = Modifier.padding(start = 16.dp, end = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.size(5.dp))

                Text(
                    text = content,
                    fontSize = 11.sp,
                    lineHeight = 15.sp,
                    color = Color(0xFF1E4189),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun BottomBarButton(iconResId: Int) {
    Button(
        onClick = { /* Navegação da barra inferior, se aplicável */ },
        modifier = Modifier
            .size(72.dp)
            .background(Color.Transparent),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = "",
            modifier = Modifier.size(60.dp)
        )
    }
}

