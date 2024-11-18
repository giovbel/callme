package br.senai.sp.jandira.callme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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

@Composable
fun telaPerfil(controleNavegacao: NavHostController) {
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
        // Cabeçalho
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
                // Avatar do usuário (apenas um placeholder)
                Card(
                    modifier = Modifier
                        .size(50.dp)
                        .border(4.dp, Color(0xFF9DBFEF), CircleShape),
                    shape = CircleShape
                ) {
                    // Imagem do avatar
                    Image(
                        painter = painterResource(id = R.drawable.perfilcomum),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        // Foto de perfil centralizada
        Box(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .offset(y = -40.dp) // Para sobrepor à seção superior
                .border(4.dp, Color.White, CircleShape)
                .clip(CircleShape)
                .background(Color.Gray) // Placeholder para a imagem de perfil
        ) {
            Image(
                painter = painterResource(id = R.drawable.perfilcomum),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Campos de entrada de dados
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .border(2.dp, Color(0xFF1B55CD), RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            CustomStyledTextField("Nome")
            CustomStyledTextField("E-mail")
            CustomStyledTextField("Senha")
            CustomStyledTextField("Nascimento")
        }

        // Botão de ação
        Button(
            onClick = { /* Ação de ver histórico de notas */ },
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
                    painter = painterResource(id = R.drawable.perfilcomum),
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

@Composable
fun CustomStyledTextField(labelText: String) {
    Column(modifier = Modifier.padding(bottom = 12.dp)) {
        Text(
            text = labelText,
            color = Color(0xFF1B55CD),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(2.dp, Color(0xFF1B55CD), RoundedCornerShape(16.dp))
                .background(Color(0xFFF0F4FF))
                .padding(horizontal = 16.dp)
        ) {
            // Placeholder de campo de entrada
        }
    }
}
