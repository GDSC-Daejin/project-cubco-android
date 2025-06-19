package com.purang.cubco.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purang.cubco.core.ui.theme.CubcoTheme

@Composable
fun CubcoTagItem(
    tag : String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(end = 4.dp)
            .background(CubcoTheme.colors.yellow5, RoundedCornerShape(50))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = tag,
            fontSize = 12.sp,
            color = CubcoTheme.colors.yellow2,
            modifier = Modifier
                .padding(horizontal = 4.dp, vertical = 2.dp),
            fontWeight = FontWeight.Bold
        )
    }
}