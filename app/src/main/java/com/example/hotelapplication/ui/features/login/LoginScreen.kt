package com.example.hotelapplication.ui.features.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.hiltViewModel
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.commonComponents.Buttons.LoginButton
import com.example.hotelapplication.ui.commonComponents.Buttons.OutLineImageButton
import com.example.hotelapplication.ui.commonComponents.Progress.CircleProgressDialog
import com.example.hotelapplication.ui.commonComponents.TextField.TextFieldCommon
import com.example.hotelapplication.ui.commonComponents.Texts.TextLoginTitle
import com.example.hotelapplication.ui.features.forgotpassword.ForgotPasswordDialog
import com.example.hotelapplication.ui.features.forgotpassword.ForgotPasswordResultDialog
import com.example.hotelapplication.ui.features.forgotpassword.ForgotPasswordStep
import com.example.hotelapplication.ui.features.forgotpassword.ForgotPasswordStep3Dialog

@Composable
fun LoginScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<LoginViewModel>()
    val uiState by viewModel.loginUiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = uiState) {
        viewModel.checkAndAutoLogin()

        if (uiState.isLoginSuccessful) {
            navController.navigate(Route.MainScreen.route)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(35.dp, 0.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            TextLoginTitle(stringResource(R.string.login))
        }

        Column {
            TextFieldCommon(
                value = uiState.username,
                onChangeValue = { value ->
                    viewModel.setUserName(value)
                },
                label = stringResource(R.string.txt_username),
                leadingIcon = R.drawable.message,
                placeholder = stringResource(R.string.txt_default_username)
            )
            TextFieldCommon(
                value = uiState.password,
                onChangeValue = { value ->
                    viewModel.setPassword(value)
                },
                stringResource(R.string.txt_password),
                R.drawable.lock,
                R.drawable.hide,
                placeholder = stringResource(R.string.txt_default_password)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(35.dp, 8.dp, 35.dp, 0.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = uiState.isRememberChecked,
                        onCheckedChange = {
                            viewModel.setIsRememberChecked(!uiState.isRememberChecked)
                        },
                        colors = CheckboxDefaults.colors()
                            .copy(
                                checkedBoxColor = colorResource(R.color.main_color),
                                checkedBorderColor = colorResource(R.color.main_color)
                            )
                    )
                    Text(
                        text = stringResource(R.string.remember_me),
                        color = colorResource(R.color.dark_gray)
                    )
                }
                TextButton(
                    onClick = {
                        viewModel.setForgotPasswordState(ForgotPasswordStep.ENTER_ACCOUNT)
                    }
                ) {
                    Text(
                        text = stringResource(R.string.forgot_password),
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.main_color)
                    )
                }
            }
        }

        LoginButton(stringResource(R.string.login)) {
            viewModel.login()
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(R.string.txt_or))
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                OutLineImageButton(
                    painterResource(R.drawable.img_google)
                ) { }
                Spacer(modifier = Modifier.width(30.dp))
                OutLineImageButton(
                    painterResource(R.drawable.img_apple)
                ) { }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.dont_have_an_account),
                color = colorResource(id = R.color.black),
                fontSize = 12.sp,
                fontWeight = FontWeight(weight = 400),
            )
            ClickableText(
                text = AnnotatedString(
                    stringResource(R.string.sign_up),
                    spanStyle = SpanStyle(
                        color = colorResource(id = R.color.main_color),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(weight = 600)
                    )
                ),
                onClick = {
                    navController.navigate(Route.SignupScreen.route) {
                        popUpTo(Route.SplashScreen.route)
                    }
                },
                modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp)
            )
        }

        when (uiState.forgotPasswordStep) {
            ForgotPasswordStep.ENTER_ACCOUNT -> {
                ForgotPasswordDialog(
                    title = stringResource(R.string.enter_phone_email_title),
                    placeHolder = stringResource(R.string.txt_phone_email),
                    onDismiss = {
                        viewModel.setForgotPasswordState(ForgotPasswordStep.NONE)
                    },
                    onConfirm = { account ->
                        viewModel.checkForgotAccount(account)
                    }
                )
            }

            ForgotPasswordStep.VERIFY_CODE -> {
                ForgotPasswordDialog(
                    title = stringResource(R.string.txt_enter_verification_code),
                    placeHolder = stringResource(R.string.txt_default_password),
                    onDismiss = {
                        viewModel.setForgotPasswordState(ForgotPasswordStep.NONE)
                    },
                    onConfirm = { code ->
                        viewModel.checkForgotVerifyCode(code)
                    },
                    isError = uiState.isForgotPassError,
                    errorMessage = uiState.forgotPassErrorMessage
                )
            }

            ForgotPasswordStep.ENTER_NEW_PW -> {
                ForgotPasswordStep3Dialog(
                    isForgotPassError = uiState.isForgotPassError,
                    errorMessage = uiState.forgotPassErrorMessage,
                    onDismiss = {
                        viewModel.setForgotPasswordState(ForgotPasswordStep.NONE)
                    },
                    onConfirm = { newPassword, confirmPassword ->
                        viewModel.checkForgotNewPassword(newPassword, confirmPassword)
                    },
                )
            }

            ForgotPasswordStep.RESULT_OK -> {
                ForgotPasswordResultDialog(stringResource(R.string.txt_success)) {
                    viewModel.setForgotPasswordState(ForgotPasswordStep.NONE)
                }
            }

            ForgotPasswordStep.ERROR -> {
                ForgotPasswordResultDialog(stringResource(R.string.txt_error_change_pw)) {
                    viewModel.setForgotPasswordState(ForgotPasswordStep.NONE)
                }
            }

            ForgotPasswordStep.NONE -> {}
        }

        if (uiState.isError) {
            ForgotPasswordResultDialog(stringResource(uiState.errorMessage)) {
                viewModel.isShowError(false)
            }
        }

        if (uiState.isLoading) {
            CircleProgressDialog()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}