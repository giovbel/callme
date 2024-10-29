package senai.jandira.sp.telacategoria

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun telaCategoria(controleNavegacao: NavHostController) {
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
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .padding(top = 16.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.height(100.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Qual seu objetivo?",
                    fontSize = 22.sp,
                    color = Color(0xFF04276D),
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(60.dp))

            // Primeiro Card
            Card(
                elevation = CardDefaults.elevatedCardElevation(20.dp),
                onClick = {controleNavegacao.navigate("telaCadastro")},
                modifier = Modifier
                    .width(320.dp)
                    .height(105.dp)
                    .align(Alignment.CenterHorizontally),
                colors = CardDefaults
                    .cardColors(containerColor = Color(0xFFFFFDFD)),
                shape = RoundedCornerShape(28.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Estou buscando\nalguém para\nconversar e me\najudar",
                        fontSize = 15.sp,
                        color = Color(0xFF2755B2),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Image(
                        painter = painterResource(id = br.senai.sp.jandira.callme.R.drawable.macallmefalandocomabanana),
                        contentDescription = "imagem de perfil",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(start = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(35.dp))

            // Segundo Card
            Card(
                elevation = CardDefaults.elevatedCardElevation(20.dp),
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(320.dp)
                    .height(105.dp)
                    .align(Alignment.CenterHorizontally),
                colors = CardDefaults
                    .cardColors(containerColor = Color(0xFFFFFDFD)),
                shape = RoundedCornerShape(28.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Desejo ajudar\npessoas, oferecendo\nsuporte",
                        fontSize = 16.sp,
                        color = Color(0xFF2755B2),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Image(
                        painter = painterResource(id = br.senai.sp.jandira.callme.R.drawable.macallmeouvinte),
                        contentDescription = "imagem de perfil",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(start = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(100.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults
                    .buttonColors(
                        containerColor = Color(0XFFE2EFFF)
                    ),
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(size = 32.dp)
            ) {
                Text(
                    fontWeight = FontWeight.Medium,
                    text = "Continuar",
                    color = Color(0xFF1F55C6),
                    fontSize = 20.sp,
                    modifier = Modifier
                )
            }
            Card(
                modifier = Modifier
                    .height(17.dp)
                    .width(230.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0x800B4ED7)),
                shape = RoundedCornerShape(
                    bottomEnd = 32.dp,
                    bottomStart = 32.dp,
                )
            ) {
            }
        }
    }
}
