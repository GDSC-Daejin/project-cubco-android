package com.purang.cubco.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purang.cubco.R
import com.purang.cubco.core.components.StableImage
import com.purang.cubco.core.ui.theme.Purple80
import com.purang.cubco.presentation.home.components.HomeTopAppBar

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    snackBarHostState: SnackbarHostState,
    //viewModel: ClubDetailHomeViewModel = hiltViewModel()
) {

    HomeScreen(
        paddingValues = paddingValues,
        //navigateUp = viewModel::navigateUp,
        //state = state.uiState
    )
}

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    //navigateUp: () -> Unit,
    //state: UiState<ClubDetailEntity>,
    modifier: Modifier = Modifier
) {
    val curationListTest = listOf(0,1,2,3,4,5)
    val tagListTest = listOf("모두", "인기 있는", "새로운", "조용한")

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            //.verticalScroll(rememberScrollState())
    ){
        HomeTopAppBar(
            navigateUp = {
                //navigateUp()
            },
            modifier = modifier
        )
        //쿠폰
        StableImage(
            drawableResId = R.drawable.div,
            modifier = modifier
                .fillMaxWidth(),
            contentDescription = "coupon sample",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        //큐레이션
        LazyRow (
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            itemsIndexed(
                items = curationListTest,
            ) { _, item ->
                CurationCard()
            }
        }

        Spacer(modifier = Modifier.padding(top = 12.dp))

        //태그
        LazyRow {
            itemsIndexed(
                items = tagListTest
            ) { _, item ->
                TagItemUI(
                    item = item,
                    selectedItem = "모두", //Todo : 나중에 state로 변경해서 선택 chip이름 가져오기
                    onClickChip = {

                    }
                )
            }
        }

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
fun CurationCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .width(120.dp)
            .height(LocalConfiguration.current.screenHeightDp.dp * 0.25f)
    ) {
        Column(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "NEW",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color.Red, shape = RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                        .align(Alignment.TopStart)
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "조용한 카페",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //나중에 내용 추가
                }
            }
        }
    }
}


@Composable
fun TagItemUI(
    item : String,
    selectedItem : String,
    onClickChip : (String) -> Unit
) {
    AssistChip(
        onClick = {
            onClickChip(item)
        },
        label = {
            Text(
                item,
                fontWeight = FontWeight.Bold,
                color = if (item == selectedItem) Color.White else Color.Black
            ) },
        modifier = Modifier
            .padding(end = 8.dp),
        colors = AssistChipDefaults.assistChipColors(
            containerColor = if (item == selectedItem)
                Purple80
            else
                Color.White,
            disabledContainerColor = Color.White
        )
    )
}

@Composable
fun Recommendation(

) {
    Column (
        modifier = Modifier.fillMaxSize()
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

@Preview(showBackground = true)
@Composable
fun CurationPreview() {
    HomeScreen(
        paddingValues = PaddingValues(),
    )
}