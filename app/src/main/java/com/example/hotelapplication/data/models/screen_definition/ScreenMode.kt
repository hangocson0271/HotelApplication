package com.example.hotelapplication.data.models.screen_definition

sealed class ScreenMode{
    object StandardMode: ScreenMode()
    object ExtendMode: ScreenMode()
}