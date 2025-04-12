package com.purang.cubco.views.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purang.cubco.R
import com.purang.cubco.ui.theme.Purple80

@Composable
fun HomeScreen(
    //navController: NavController
) {

    val curationListTest = listOf(0,1,2,3,4,5)
    val tagListTest = listOf("모두", "인기 있는", "새로운", "조용한")

    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp)
            //.verticalScroll(rememberScrollState())
    ){
        //쿠폰
        Box(
            modifier = Modifier.fillMaxWidth()
                .background(Purple80, RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.weight(1f))

        //큐레이션
        LazyRow {
            itemsIndexed(
                items = curationListTest,
            ) { _, item ->
                Curation()
            }
        }

        Spacer(modifier = Modifier.padding(top = 16.dp))

        //태그
        LazyRow {
            itemsIndexed(
                items = tagListTest
            ) { _, item ->
                TagItemUI(item)
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            text = "추천 카페",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
        )

        //추천
        LazyColumn {
            itemsIndexed(
                items = curationListTest
            ) { _, item ->
                Recommendation()
            }
        }
    }
}


@Composable
fun Curation(
) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .height(LocalConfiguration.current.screenHeightDp.dp * 0.2f)
            .clip(RoundedCornerShape(16.dp)),
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop // FillBounds
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f))
                    )
                )
                .height(24.dp)
        )

        Text(
            text = "조용한 카페",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Composable
fun TagItemUI(
    item : String
) {
    AssistChip(
        onClick = { /* Do something! */ },
        label = {
            Text(
                item,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ) },
        modifier = Modifier.padding(end = 8.dp)
    )
}

@Composable
fun Recommendation(

) {
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
    ) {
        Box (
            modifier = Modifier.fillMaxWidth().padding(16.dp)
                .height(LocalConfiguration.current.screenHeightDp.dp * 0.2f) // 60% 높이
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop // FillBounds
            )

            Icon(
                painter = painterResource(id = R.drawable.baseline_star_24),
                contentDescription = null,
                modifier = Modifier.align(Alignment.TopEnd)
                    .padding(8.dp)
            )
        }

        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, bottom = 16.dp)
        ){
            Text(
                text = "공차",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.baseline_star_24),
                contentDescription = null,
                tint = Color.Yellow,
                modifier = Modifier.padding(end = 16.dp, top = 16.dp)
            )
            Text(
                text = "4.8",
                modifier = Modifier.padding(end = 16.dp, top = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun CurationPreview() {
    HomeScreen()
}