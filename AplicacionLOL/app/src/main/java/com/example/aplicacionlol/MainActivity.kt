package com.example.aplicacionlol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage



class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    ChampionListItem1(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
@Composable
fun ChampionListItem(image: String, title: String, description: String) {
    val imageModifier = Modifier.size(100.dp).padding(8.dp).clip(CircleShape)
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model= image,
            contentDescription ="",
            modifier= imageModifier,
        )
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

data class Champion(val image:String, val title:String, val description: String)
val championList: List<Champion> = listOf(
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Annie.png", "Annie", "La Hija de la Oscuridad"),
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Diana.png", "Diana", "El Desdén de la Luna"),
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Fizz.png", "Fizz", "El Bromista de las Mareas"),
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Irelia.png", "Irelia", "La Cuchilla Danzante"),
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Leona.png", "Leona", "El Amanecer Radiante"),
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Mordekaiser.png", "Mordekaiser", "El Revenanate de Hierro"),
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Neeko.png", "Neeko", "La Camaleona Curiosa"),
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Senna.png", "Senna", "La Redentora"),
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Taric.png", "Taric", "El Escudo de Valoran"),
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Teemo.png", "Teemo", "El Explorador Veloz"),
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Vi.png", "Vi", "La Defensora de Piltover"),
    Champion("https://ddragon.leagueoflegends.com/cdn/14.20.1/img/champion/Ziggs.png", "Ziggs", "El Experto en Explosivos")
    )


@Composable
fun ChampionListItem1(modifier: Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(championList) {champion ->
            ChampionListItem(
                image = champion.image,
                title = champion.title,
                description = champion.description

            )
        }


    }
}