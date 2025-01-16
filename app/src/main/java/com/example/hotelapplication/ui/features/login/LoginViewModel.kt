package com.example.hotelapplication.ui.features.login

import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.R
import com.example.hotelapplication.base.BaseViewModel
import com.example.hotelapplication.constant.SharePreferenceConstant
import com.example.hotelapplication.data.user.UserRepository
import com.example.hotelapplication.extentions.isEmail
import com.example.hotelapplication.extentions.isPhoneNumber
import com.example.hotelapplication.repositories.StoreValue
import com.example.hotelapplication.ui.features.forgotpassword.ForgotPasswordStep
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val storeValue: StoreValue
) : BaseViewModel() {

    private val _viewModelState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState>
        get() = _viewModelState.asStateFlow()

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
                if (loginUiState.value.isRememberChecked) {
                    /* Save user info to SharePreference */
                    storeValue.setIntValue(
                        SharePreferenceConstant.USER_ID_PREF,
                        user.user_id
                    )
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
                it.copy(forgotPasswordStep = step)
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
}