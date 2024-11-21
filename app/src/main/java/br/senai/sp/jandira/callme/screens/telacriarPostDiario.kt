package br.senai.jandira.sp.telacriarpostdiario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.callme.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun telaCriarPostDiario(controleNavegacao: NavHostController) {

    var conteudo by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("Título") }
    var isFocused by remember { mutableStateOf(false) }
    val currentDate = SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(Date())
    var selectedImage by remember { mutableStateOf<Int?>(null) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE4EFFF))
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
                    text = "CRIAR PÁGINA",
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

        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Card(
                modifier = Modifier
                    .width(380.dp)
                    .height(700.dp)
                    .align(Alignment.CenterHorizontally),
                colors = CardDefaults.cardColors(Color(0xFFC1DBFF)),
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = if (isFocused && title == "Título") "" else title,
                        onValueChange = { title = it },
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .onFocusChanged { focusState ->
                                isFocused = focusState.isFocused
                            },
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            errorContainerColor = Color.Transparent
                        )
                    )


                    Text(
                        text = currentDate,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }


                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 15.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .width(350.dp)
                            .height(300.dp),
                        colors = CardDefaults.cardColors(Color(0xFFE4EFFF)),
                    ) {
                        BasicTextField(
                            value = conteudo,
                            onValueChange = { novoValor ->
                                conteudo = novoValor
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Transparent)
                                .padding(16.dp),
                            decorationBox = { innerTextField ->
                                if (conteudo.isEmpty()) {
                                    Text(
                                        "Cada página em branco é uma oportunidade de se expressar. Vamos começar?",
                                        color = Color.Gray
                                    )
                                }
                                innerTextField()
                            }
                        )
                    }

                    Column (
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ){
                        Column {
                            Text(
                                text = "Como você está hoje?",
                                fontSize = 20.sp,
                                color = Color(0xFF2755B2),
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 20.dp),
                                textAlign = TextAlign.Center
                            )

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.SpaceBetween, // Espaço entre os elementos
                                horizontalAlignment = Alignment.CenterHorizontally // Centraliza na horizontal
                            ) {
                                // Área superior: Imagens
                                if (selectedImage == null) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.emojifeliz),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .size(60.dp)
                                                .padding(horizontal = 8.dp)
                                                .clickable {
                                                    selectedImage = R.drawable.emojifeliz
                                                }
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.emojiok),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .size(60.dp)
                                                .padding(horizontal = 8.dp)
                                                .clickable {
                                                    selectedImage = R.drawable.emojiok
                                                }
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.emojineutro),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .size(60.dp)
                                                .padding(horizontal = 8.dp)
                                                .clickable {
                                                    selectedImage = R.drawable.emojineutro
                                                }
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.emojitriste),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .size(60.dp)
                                                .padding(horizontal = 8.dp)
                                                .clickable {
                                                    selectedImage = R.drawable.emojitriste
                                                }
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.emojichorando),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .size(60.dp)
                                                .padding(horizontal = 8.dp)
                                                .clickable {
                                                    selectedImage = R.drawable.emojichorando
                                                }
                                        )
                                    }
                                } else {
                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Image(
                                                painter = painterResource(id = selectedImage!!),
                                                contentDescription = "Imagem Selecionada",
                                                modifier = Modifier
                                                    .size(60.dp)
                                                    .clickable {
                                                        selectedImage =
                                                            null
                                                    }
                                            )
                                            Spacer(modifier = Modifier.height(16.dp))
                                            Text(
                                                text = "Clique na imagem para voltar",
                                                fontSize = 14.sp,
                                                color = Color.Gray
                                            )
                                        }
                                    }
                                }


                                Card (
                                    modifier = Modifier
                                        .height(60.dp)
                                        .fillMaxWidth()
                                        .align(Alignment.CenterHorizontally)
                                        .padding(start = 12.dp, end = 12.dp, bottom = 10.dp),
                                    colors = CardDefaults.cardColors(Color(0xFF1F55C6)),
                                    shape = RoundedCornerShape(6.dp),
                                ){
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(100.dp),
                                        contentAlignment = Alignment.Center
                                    ){
                                        Text(
                                            text = "Salvar",
                                            fontSize = 24.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Medium
                                        )
                                    }

                                }
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

