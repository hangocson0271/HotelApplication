package com.example.hotelapplication.ui.features.signup

sealed class LoadStatus(val description: Int = 0) {
    class Init() : LoadStatus()
    class Loading() : LoadStatus()
    class Success() : LoadStatus()
    class Error(val error: Int) : LoadStatus(error)
}

data class SignupUiState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val state: LoadStatus = LoadStatus.Init()
)