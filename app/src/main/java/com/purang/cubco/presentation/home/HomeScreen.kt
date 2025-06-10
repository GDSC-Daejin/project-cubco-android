package com.purang.cubco.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.purang.cubco.R
import com.purang.cubco.core.components.StableImage
import com.purang.cubco.core.ui.theme.CUBCOTheme
import com.purang.cubco.core.ui.theme.CubcoTheme
import com.purang.cubco.core.util.UiState
import com.purang.cubco.data.models.CurationEntity
import com.purang.cubco.presentation.home.components.HomeCurationCard
import com.purang.cubco.presentation.home.components.HomeTopAppBar
import kotlinx.collections.immutable.PersistentList

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateNext: () -> Unit,
    snackBarHostState : SnackbarHostState,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current


    LaunchedEffect(Unit) {
        viewModel.getCurations()
    }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is HomeSideEffect.ShowSnackBar -> snackBarHostState.showSnackbar(sideEffect.message)
                    HomeSideEffect.NavigateNext -> navigateNext()
                    HomeSideEffect.NavigateUp -> navigateUp()
                }
            }
    }

    HomeScreen(
        paddingValues = paddingValues,
        snackBarHostState = snackBarHostState,
        navigateUp = viewModel::navigateUp,
        navigateNext = viewModel::navigateNext,
        //state = state.uiState
        state = state.uiState,
        modifier = modifier,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    state: UiState<PersistentList<CurationEntity>>,
    navigateUp: () -> Unit,
    navigateNext: () -> Unit,
    modifier: Modifier = Modifier,
    snackBarHostState: SnackbarHostState = SnackbarHostState(),
) {
    val curationListTest = listOf(0,1,2,3,4,5)
    val tagListTest = listOf("모두", "인기 있는", "새로운", "조용한")

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
            //.verticalScroll(rememberScrollState())
    ){
        when (state) {
            is UiState.Loading -> {
                item {
                    Text(
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.loading_string),
                        fontSize = 30.sp
                    )
                }
            }

            is UiState.Empty -> {
                item {
                    Text(
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.empty_string),
                        fontSize = 30.sp
                    )
                }
            }

            is UiState.Failure -> {
                item {
                    Text(
                        textAlign = TextAlign.Center,
                        text = state.message,
                        //style = CubcoTheme.typography.body1Sb15,
                        color = CubcoTheme.colors.red5
                    )
                }
            }

            is UiState.Success -> {
                stickyHeader {
                    Column {
                        HomeTopAppBar(
                            navigateUp = navigateUp,
                            modifier = Modifier.fillMaxWidth()
                        )
                        StableImage(
                            drawableResId = R.drawable.div,
                            modifier = Modifier.fillMaxWidth(),
                            contentDescription = "coupon sample",
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                item {
                    //큐레이션
                    LazyRow (
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        itemsIndexed(
                            items = state.data,
                        ) { _, item ->
                            HomeCurationCard(
                                thumbnail = item.thumbnail,
                                title = item.title,
                                content = item.content,
                                like = item.like,
                                onClickCard = {
                                    navigateNext()
                                }
                            )
                        }
                    }
                }

                item {
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
                }

                itemsIndexed(
                    items = curationListTest
                ) { _, item ->
                    Recommendation()
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
                CubcoTheme.colors.red7
            else
                Color.White,
        )
    )
}

@Composable
fun Recommendation(

) {
    Column (
        modifier = Modifier.fillMaxWidth()
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
private fun HomeScreenPreview() {
    CUBCOTheme {
        HomeScreen(
            paddingValues = PaddingValues(),
            state = UiState.Loading,
            navigateUp = {},
            navigateNext = {},
            snackBarHostState = SnackbarHostState()
        )
    }
}