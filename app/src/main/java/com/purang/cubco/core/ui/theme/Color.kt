package com.purang.cubco.core.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

val yellowBlack = Color(0xFF191201)
val yellow1 = Color(0xFF4A2002)
val yellow2 = Color(0xFF814204)
val yellow3 = Color(0xFFBC7005)
val yellow4 = Color(0xFFDF9706)
val yellow5 = Color(0xFFF9B920)
val yellow6 = Color(0xFFFAC84F)
val yellow7 = Color(0xFFFBD883)
val yellow8 = Color(0xFFFDE8B5)
val yellowWhite = Color(0xFFFEF7E6)

val redBlack = Color(0xFF191201)
val red1 = Color(0xFF4A1102)
val red2 = Color(0xFF7C1C04)
val red3 = Color(0xFFAE2705)
val red4 = Color(0xFFDF3206)
val red5 = Color(0xFFF94B20)
val red6 = Color(0xFFFA714F)
val red7 = Color(0xFFFB9B83)
val red8 = Color(0xFFFDC3B5)

val cubcoBlack = Color(0xFF191201)
val gray1 = Color(0xFF1C1C1C)
val gray2 = Color(0xFF393939)
val gray3 = Color(0xFF555555)
val gray4 = Color(0xFF717171)
val gray5 = Color(0xFF8E8E8E)
val gray6 = Color(0xFFAAAAAA)
val gray7 = Color(0xFFD9D9D9)
val gray8 = Color(0xFFF0F0F0)
val cubcoWhite = Color(0xFFFFFFFF)

@Stable
class CubcoColors(
    yellowBlack: Color,
    yellow1: Color,
    yellow2: Color,
    yellow3: Color,
    yellow4: Color,
    yellow5: Color,
    yellow6: Color,
    yellow7: Color,
    yellow8: Color,
    yellowWhite: Color,

    redBlack: Color,
    red1: Color,
    red2: Color,
    red3: Color,
    red4: Color,
    red5: Color,
    red6: Color,
    red7: Color,
    red8: Color,

    cubcoBlack: Color,
    gray1: Color,
    gray2: Color,
    gray3: Color,
    gray4: Color,
    gray5: Color,
    gray6: Color,
    gray7: Color,
    gray8: Color,
    cubcoWhite: Color,
    isLight: Boolean,
) {
    var yellowBlack by mutableStateOf(yellowBlack)
        private set
    var yellow1 by mutableStateOf(yellow1)
        private set
    var yellow2 by mutableStateOf(yellow2)
        private set
    var yellow3 by mutableStateOf(yellow3)
        private set
    var yellow4 by mutableStateOf(yellow4)
        private set
    var yellow5 by mutableStateOf(yellow5)
        private set
    var yellow6 by mutableStateOf(yellow6)
        private set
    var yellow7 by mutableStateOf(yellow7)
        private set
    var yellow8 by mutableStateOf(yellow8)
        private set
    var yellowWhite by mutableStateOf(yellowWhite)
        private set

    var redBlack by mutableStateOf(redBlack)
        private set
    var red1 by mutableStateOf(red1)
        private set
    var red2 by mutableStateOf(red2)
        private set
    var red3 by mutableStateOf(red3)
        private set
    var red4 by mutableStateOf(red4)
        private set
    var red5 by mutableStateOf(red5)
        private set
    var red6 by mutableStateOf(red6)
        private set
    var red7 by mutableStateOf(red7)
        private set
    var red8 by mutableStateOf(red8)
        private set

    var cubcoBlack by mutableStateOf(cubcoBlack)
        private set
    var gray1 by mutableStateOf(gray1)
        private set
    var gray2 by mutableStateOf(gray2)
        private set
    var gray3 by mutableStateOf(gray3)
        private set
    var gray4 by mutableStateOf(gray4)
        private set
    var gray5 by mutableStateOf(gray5)
        private set
    var gray6 by mutableStateOf(gray6)
        private set
    var gray7 by mutableStateOf(gray7)
        private set
    var gray8 by mutableStateOf(gray8)
        private set
    var cubcoWhite by mutableStateOf(cubcoWhite)
        private set

    var isLight by mutableStateOf(isLight)
        private set

    fun copy(): CubcoColors = CubcoColors(
        yellowBlack,
        yellow1,
        yellow2,
        yellow3,
        yellow4,
        yellow5,
        yellow6,
        yellow7,
        yellow8,
        yellowWhite,

        redBlack,
        red1,
        red2,
        red3,
        red4,
        red5,
        red6,
        red7,
        red8,

        cubcoBlack,
        gray1,
        gray2,
        gray3,
        gray4,
        gray5,
        gray6,
        gray7,
        gray8,
        cubcoWhite,
        isLight
    )

    fun update(other: CubcoColors) {
        yellowBlack = other.yellowBlack
        yellow1 = other.yellow1
        yellow2 = other.yellow2
        yellow3 = other.yellow3
        yellow4 = other.yellow4
        yellow5 = other.yellow5
        yellow6 = other.yellow6
        yellow7 = other.yellow7
        yellow8 = other.yellow8
        yellowWhite = other.yellowWhite

        redBlack = other.redBlack
        red1 = other.red1
        red2 = other.red2
        red3 = other.red3
        red4 = other.red4
        red5 = other.red5
        red6 = other.red6
        red7 = other.red7
        red8 = other.red8

        cubcoBlack = other.cubcoBlack
        gray1 = other.gray1
        gray2 = other.gray2
        gray3 = other.gray3
        gray4 = other.gray4
        gray5 = other.gray5
        gray6 = other.gray6
        gray7 = other.gray7
        gray8 = other.gray8
        cubcoWhite = other.cubcoWhite

        isLight = other.isLight
    }
}

fun CubcoLightColors(
    YellowBlack: Color = yellowBlack,
    Yellow1: Color = yellow1,
    Yellow2: Color = yellow2,
    Yellow3: Color = yellow3,
    Yellow4: Color = yellow4,
    Yellow5: Color = yellow5,
    Yellow6: Color = yellow6,
    Yellow7: Color = yellow7,
    Yellow8: Color = yellow8,
    YellowWhite: Color = yellowWhite,

    RedBlack: Color = redBlack,
    Red1: Color = red1,
    Red2: Color = red2,
    Red3: Color = red3,
    Red4: Color = red4,
    Red5: Color = red5,
    Red6: Color = red6,
    Red7: Color = red7,
    Red8: Color = red8,

    CubcoBlack: Color = cubcoBlack,
    Gray1: Color = gray1,
    Gray2: Color = gray2,
    Gray3: Color = gray3,
    Gray4: Color = gray4,
    Gray5: Color = gray5,
    Gray6: Color = gray6,
    Gray7: Color = gray7,
    Gray8: Color = gray8,
    CubcoWhite: Color = cubcoWhite,
) = CubcoColors(
    YellowBlack,
    Yellow1,
    Yellow2,
    Yellow3,
    Yellow4,
    Yellow5,
    Yellow6,
    Yellow7,
    Yellow8,
    YellowWhite,

    RedBlack,
    Red1,
    Red2,
    Red3,
    Red4,
    Red5,
    Red6,
    Red7,
    Red8,

    CubcoBlack,
    Gray1,
    Gray2,
    Gray3,
    Gray4,
    Gray5,
    Gray6,
    Gray7,
    Gray8,
    CubcoWhite,
    isLight = true
)