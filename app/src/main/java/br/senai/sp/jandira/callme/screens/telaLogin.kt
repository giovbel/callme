package br.senai.sp.jandira.callme
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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


@Composable
fun Telalogin(navHostController: NavHostController) {
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
                    .height(110.dp)
                    .padding(top = 16.dp),
                alignment = Alignment.Center
            )

            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    textAlign = TextAlign.Center,
                    text = "Seja bem vindo ao Callme!\nFaça seu login!",
                    fontSize = 22.sp,
                    color = Color(0xFF04276D),
                    fontWeight = FontWeight.Medium
                )

            }
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.macallmesonhando),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .padding(top = 16.dp),
                alignment = Alignment.Center
            )

            Spacer(modifier = Modifier.height(40.dp))
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
                }

            }


            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults
                    .buttonColors(
                        containerColor = Color.Transparent
                    ),
                modifier = Modifier,
            ) {
                Text(
                    text = "Esqueci minha senha",
                    color = Color(0xFF213787),
                    fontWeight = FontWeight.Bold,

                    modifier = Modifier
                        .padding(12.dp)
                        .clickable {

                        }


                )
            }

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults
                    .buttonColors(
                        containerColor = Color(0XFFE2EFFF)
                    ),
                modifier = Modifier
                    .width(350.dp)
                    .height(105.dp)
                    .padding(start = 52.dp, end = 16.dp, top = 26.dp, bottom = 30.dp),
                shape = RoundedCornerShape(size = 32.dp)
            ) {
                Text(
                    text = "Login",
                    color = Color(0xFF1F55C6),
                    fontSize = 20.sp,
                    modifier = Modifier
                )

            }
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(32.dp)){
            }

        }


    }
}



