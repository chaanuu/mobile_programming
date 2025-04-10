package com.example.week05.uiexamples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cweek05a.uiexamples.TextCell
import kotlinx.coroutines.launch

@Composable
fun TextLazyColumnFAB(dataList: MutableList<String>, modifier: Modifier = Modifier) {
    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf { //mutable로 해놓으면 처음에 값이 정해지면 그 값이 바뀌지 않는다, =로 할수도 있겠지만 그러면 recomposition이 너무 많이 일어나서 derviedstateof 사용
            state.firstVisibleItemIndex > 0
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = state,
            modifier = modifier,
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = dataList) {item->
                TextCell(text = item, Modifier.background(Color.Green))
            }
        }
        AnimatedVisibility(visible = showButton) {
            ScrollToTopButton {
                scope.launch {
                    state.scrollToItem(0) // scrolltoItem은 scope안에서만 동작 가능
                }
            }
        }
    }
}

@Preview
@Composable
private fun TextLazyColumnFABPreview() {
    val dataList = (1..15).map { it.toString() }.toMutableList()
    TextLazyColumnFAB(dataList = dataList, modifier = Modifier.fillMaxSize())
}