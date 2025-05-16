package com.purang.cubco.views.scrap

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.purang.cubco.models.ScrapData

@Composable
fun ScrapScreen(
    navController: NavController,
    //viewModel: ScrapViewModel = hiltViewModel()
) {

    val sampleList = listOf(
        ScrapData(
            imagePath = "https://example.com/image1.jpg",
            title = "Title 1",
            description = "Description 1"
        ),
        ScrapData(
            imagePath = "https://example.com/image1.jpg",
            title = "Title 2",
            description = "Description 1"
        ),
        ScrapData(
            imagePath = "https://example.com/image1.jpg",
            title = "Title 3",
            description = "Description 1"
        ),
        ScrapData(
            imagePath = "https://example.com/image1.jpg",
            title = "Title 4",
            description = "Description 1"
        ),
    )


    val scrapList = remember { mutableStateListOf<ScrapData>() }
    scrapList.addAll(sampleList)

    LazyColumn {
        items(scrapList.size) { index ->
            ScrapItem(scrapList[index])
        }
    }
}

@Composable
fun ScrapItem(
    scrapData: ScrapData
) {
    Column {
        Text(
            text = scrapData.title,
        )

        Text(
            text = scrapData.description
        )
    }
}