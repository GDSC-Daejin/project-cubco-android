package com.purang.cubco.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.purang.cubco.core.util.noRippleClickable

@Composable
fun CubcoTopBar(
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: (@Composable (modifier: Modifier) -> Unit)? = null
) {
    Box(
        modifier = modifier
            .background(Color.White)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                contentDescription = "Back",
                modifier = Modifier.noRippleClickable {
                    navigateUp()
                }
            )

            Spacer(modifier = Modifier.weight(1f))


            //Todo : 나중에 icon 추가, screen마다?
            if (trailingIcon != null) {
                trailingIcon(modifier)
            }
        }
    }
}