package br.edu.ifsp.scl.prdm.sc3039307.pingpongscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.prdm.sc3039307.pingpongscoreboard.ui.theme.PingPongScoreBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PingPongScoreBoardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Placar de Ping Pong",
            fontSize = 30.sp,
            modifier = Modifier.padding(20.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            PlayerCard(
                playerName = "Jogador A",
                playerPoints = 0,
                addPoints = {},
                Modifier.weight(1f)
            )
            PlayerCard(
                playerName = "Jogador B",
                playerPoints = 0,
                addPoints = {},
                Modifier.weight(1f)
            )
        }
        Button(
            onClick = {},
            modifier = Modifier
                .wrapContentSize()
                .padding(10.dp)
        ) {
            Text(
                text = "Reiniciar partida",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

        }
    }
}

@Composable
fun PlayerCard(playerName: String,
               playerPoints: Int,
               addPoints: () -> Unit,
               modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = playerName,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "$playerPoints",
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = {addPoints()},
            modifier = Modifier
                .wrapContentSize()
                .padding(10.dp)
        ) {
            Text(
                text = "+ 1 Ponto",
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PingPongScoreBoardTheme {
        MainScreen()
    }
}