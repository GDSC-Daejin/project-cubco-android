package com.purang.cubco.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalCubcoColors = staticCompositionLocalOf<CubcoColors> {
    error("No CubcoColors provided")
}

/*private val LocalCubcoTypography = staticCompositionLocalOf<Ty> {
    error("No CubcoTypography provided")
}*/

object CubcoTheme {
    val colors: CubcoColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCubcoColors.current
   /* val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = Local Typography.current*/
}

@Composable
fun ProvideCubcoColors(
    colors: CubcoColors,
    //typography: AtSoptTypography,
    content: @Composable () -> Unit,
) {
    val provideColors = remember { colors.copy() }.apply { update(colors) }
    CompositionLocalProvider(
        LocalCubcoColors provides provideColors,
        //LocalCubcoTypography provides typography,
        content = content,
    )
}

@Composable
fun CUBCOTheme(
    content: @Composable () -> Unit,
) {
    val colors = CubcoLightColors()
    //val typography = Typography()

    ProvideCubcoColors(
        colors = colors,
        //typography = typography,
    ) {
        MaterialTheme(
            content = content,
        )
    }
}
