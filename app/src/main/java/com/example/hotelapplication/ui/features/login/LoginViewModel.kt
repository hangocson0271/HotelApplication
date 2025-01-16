package com.example.hotelapplication.ui.features.login

import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.R
import com.example.hotelapplication.base.BaseViewModel
import com.example.hotelapplication.constant.SharePreferenceConstant
import com.example.hotelapplication.data.user.User
import com.example.hotelapplication.data.user.UserRepository
import com.example.hotelapplication.extentions.isEmail
import com.example.hotelapplication.extentions.isPhoneNumber
import com.example.hotelapplication.extentions.isValidPassword
import com.example.hotelapplication.repositories.StoreValue
import com.example.hotelapplication.ui.features.forgotpassword.ForgotPasswordStep
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val storeValue: StoreValue
) : BaseViewModel() {

    private val _viewModelState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState>
        get() = _viewModelState.asStateFlow()

    private var forgotUser: User? = null

    fun checkAndAutoLogin() {
        val username: String = storeValue.getStringValue(SharePreferenceConstant.USER_NAME_PREF)
        val password: String = storeValue.getStringValue(SharePreferenceConstant.PASSWORD_PREF)

        if (username.isNotEmpty() && password.isNotEmpty()) {
            login(username, password)
        }
    }

    fun login(username: String? = null, password: String? = null) {
        viewModelScope.launch {

            _viewModelState.update {
                it.copy(
                    isLoading = true
                )
            }

            /* fake internet connection time */
            delay(2000)

            val loginAccount: String = username ?: loginUiState.value.username
            val loginPassword: String = password ?: loginUiState.value.password

            if (!checkValidInput(loginAccount)) {
                _viewModelState.update {
                    it.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = R.string.txt_incorrect_username_password
                    )
                }
                return@launch
            }

            val user = userRepository.getUser(
                phone = loginAccount   /*"0987654321"*/,
                email = loginAccount,
                password = loginPassword  /*"abc1234!"*/
            )

            if (user != null) {
                storeValue.setIntValue(
                    SharePreferenceConstant.USER_ID_PREF,
                    user.user_id
                )

                if (loginUiState.value.isRememberChecked) {
                    /* Save user info to SharePreference */
                    storeValue.setStringValue(
                        SharePreferenceConstant.USER_NAME_PREF,
                        loginAccount
                    )
                    storeValue.setStringValue(
                        SharePreferenceConstant.PASSWORD_PREF,
                        loginPassword
                    )
                }

                /* update uiState */
                _viewModelState.update { it.copy(isLoading = false, isLoginSuccessful = true) }
            } else {
                _viewModelState.update {
                    it.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = R.string.txt_incorrect_username_password
                    )
                }
            }
        }
    }

    fun setUserName(account: String) {
        viewModelScope.launch {
            _viewModelState.update {
                it.copy(username = account)
            }
        }
    }

    fun setPassword(pw: String) {
        viewModelScope.launch {
            _viewModelState.update {
                it.copy(password = pw)
            }
        }
    }

    fun setIsRememberChecked(checked: Boolean) {
        viewModelScope.launch {
            _viewModelState.update {
                it.copy(isRememberChecked = checked)
            }
        }
    }

    fun setForgotPasswordState(step: ForgotPasswordStep) {
        viewModelScope.launch {
            _viewModelState.update {
                it.copy(
                    forgotPasswordStep = step,
                    errorMessage = R.string.txt_incorrect_username_password
                )
            }
        }
    }

    fun isShowError(isShow: Boolean) {
        viewModelScope.launch {
            _viewModelState.update {
                it.copy(
                    isError = isShow,
                    errorMessage = 0
                )
            }
        }
    }

    private fun checkValidInput(account: String): Boolean {
        return isPhoneNumber(account) || isEmail(account)
    }

    fun checkForgotAccount(account: String) {
        viewModelScope.launch {
            if (!checkValidInput(account)) {
                _viewModelState.update {
                    it.copy(
                        isForgotPassError = true,
                        forgotPassErrorMessage = R.string.txt_incorrect_username_password
                    )
                }
            } else {
                forgotUser = userRepository.getUserByAccount(account)
                _viewModelState.update {
                    it.copy(
                        isForgotPassError = false,
                        forgotPasswordStep = ForgotPasswordStep.VERIFY_CODE
                    )
                }
            }
        }
    }

    fun checkForgotVerifyCode(code: String) {
        viewModelScope.launch {
            /* Check verify code like user's password */
            if (forgotUser?.password?.trim().equals(code.trim())) {
                _viewModelState.update {
                    it.copy(
                        isForgotPassError = false,
                        forgotPasswordStep = ForgotPasswordStep.ENTER_NEW_PW,
                        errorMessage = R.string.txt_incorrect_username_password
                    )
                }
            } else {
                _viewModelState.update {
                    it.copy(
                        isForgotPassError = true,
                        forgotPassErrorMessage = R.string.txt_incorrect_verify_code
                    )
                }
            }
        }
    }

    fun checkForgotNewPassword(newPassword: String, confirmPassword: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                if (!isValidPassword(newPassword) || !isValidPassword(confirmPassword)) {
                    _viewModelState.update {
                        it.copy(
                            isForgotPassError = true,
                            forgotPassErrorMessage = R.string.txt_password_policy
                        )
                    }
                } else if (newPassword != confirmPassword) {
                    _viewModelState.update {
                        it.copy(
                            isForgotPassError = true,
                            forgotPassErrorMessage = R.string.txt_password_not_equals
                        )
                    }
                } else {
                    _viewModelState.update {
                        it.copy(
                            isLoading = true
                        )
                    }

                    /* Update password */
                    withContext(Dispatchers.IO) {
                        val result = forgotUser?.copy(password = newPassword)
                            ?.let { userRepository.updatePassword(it) }
                        if (result != null && result > 0) {
                            _viewModelState.update {
                                it.copy(
                                    isLoading = false,
                                    isForgotPassError = false,
                                    forgotPassErrorMessage = 0,
                                    forgotPasswordStep = ForgotPasswordStep.RESULT_OK
                                )
                            }
                        } else {
                            _viewModelState.update {
                                it.copy(
                                    isLoading = false,
                                    isForgotPassError = false,
                                    forgotPassErrorMessage = 0,
                                    forgotPasswordStep = ForgotPasswordStep.ERROR
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}