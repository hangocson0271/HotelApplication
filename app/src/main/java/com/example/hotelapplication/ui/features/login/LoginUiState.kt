package com.example.hotelapplication.ui.features.login

import com.example.hotelapplication.ui.features.forgotpassword.ForgotPasswordStep

data class LoginUiState(
    val isLoading: Boolean = false,
    val isLoginSuccessful: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: Int = 0,
    val isForgotPassError: Boolean = false,
    val forgotPassErrorMessage: Int = 0,
    val username: String = "",
    val password: String = "",
    val isRememberChecked: Boolean = false,
    val forgotPasswordStep: ForgotPasswordStep = ForgotPasswordStep.NONE
)
