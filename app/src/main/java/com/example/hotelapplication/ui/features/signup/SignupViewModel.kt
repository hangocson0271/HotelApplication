package com.example.hotelapplication.ui.features.signup

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.R
import com.example.hotelapplication.base.BaseViewModel
import com.example.hotelapplication.data.user.UserRepository
import com.example.hotelapplication.extentions.isEmail
import com.example.hotelapplication.extentions.isPhoneNumber
import com.example.hotelapplication.extentions.isValidPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val _signupUiState = MutableStateFlow<SignupUiState>(SignupUiState())
    val signupUiState: StateFlow<SignupUiState>
        get() = _signupUiState.asStateFlow()


    fun signup() {
        viewModelScope.launch {

            _signupUiState.update {
                it.copy(
                    state = LoadStatus.Loading()
                )
            }

            /* Fake internet connection time */
            delay(2000)

            val username = _signupUiState.value.username
            val email = _signupUiState.value.email
            val password = _signupUiState.value.password

            if (username.isEmpty() || isPhoneNumber(username)) {
                updateErrorState(R.string.txt_username_should_not_null)
                return@launch
            }
            if (!isEmail(email)) {
                updateErrorState(R.string.txt_email_wrong_format)
                return@launch
            }
            if (!isValidPassword(password)) {
                updateErrorState(R.string.txt_password_policy)
                return@launch
            }

            val user_id = userRepository.insertUser(username, email, password)
            Log.d("TuanTQ45", "signup: ${user_id}")
            if (user_id > 0) {
                _signupUiState.update {
                    it.copy(
                        state = LoadStatus.Success()
                    )
                }
            } else {
                updateErrorState(R.string.txt_unknow_error)
            }
        }
    }

    private fun updateErrorState(error: Int) {
        _signupUiState.update {
            it.copy(state = LoadStatus.Error(error))
        }
    }

    fun updateUsername(value: String) {
        viewModelScope.launch {
            _signupUiState.update { it.copy(username = value) }
        }
    }

    fun updateEmail(value: String) {
        viewModelScope.launch {
            _signupUiState.update { it.copy(email = value) }
        }
    }

    fun updatePassword(value: String) {
        viewModelScope.launch {
            _signupUiState.update { it.copy(password = value) }
        }
    }

    fun onDismissErrorDialog() {
        viewModelScope.launch {
            _signupUiState.update {
                it.copy(
                    state = LoadStatus.Init()
                )
            }
        }
    }
}
