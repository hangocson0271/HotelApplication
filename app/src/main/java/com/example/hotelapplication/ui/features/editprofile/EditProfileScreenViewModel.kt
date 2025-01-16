package com.example.hotelapplication.ui.features.editprofile

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.base.BaseViewModel
import com.example.hotelapplication.constant.SharePreferenceConstant
import com.example.hotelapplication.data.user.User
import com.example.hotelapplication.data.user.UserRepository
import com.example.hotelapplication.repositories.StoreValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class EditProfileScreenViewModel @Inject constructor(
    private val context: Context,
    userRepository: UserRepository,
    private val storeValue: StoreValue
) : BaseViewModel() {
    private val _viewModelState = MutableStateFlow(EditProfileUiState())
    val editProfileUiState: StateFlow<EditProfileUiState>
        get() = _viewModelState.asStateFlow()
    private val userRes = userRepository
    private var user: User? = null

    fun getUserById() {
        val userId: Int = storeValue.getIntValue(SharePreferenceConstant.USER_ID_PREF)
        viewModelScope.launch {
            user = userRes.getUserById(userId)
            if (user == null) {
                Log.i("TAG", "Get user null")
            } else {
                _viewModelState.update {
                    it.copy(
                        userName = user!!.user_name,
                        phone = user!!.phone,
                        email = user!!.email ?: "",
                        dateOfBirth = user!!.date_of_birth ?: ""
                    )
                }
            }
        }
    }

    fun setUserName(userName: String) {
        viewModelScope.launch {
            _viewModelState.update {
                it.copy(userName = userName)
            }
        }
    }

    fun setDateOfBirth(dateOfBirth: String) {
        viewModelScope.launch {
            _viewModelState.update {
                it.copy(dateOfBirth = dateOfBirth)
            }
        }
    }

    fun setPhone(phone: String) {
        viewModelScope.launch {
            _viewModelState.update {
                it.copy(phone = phone)
            }
        }
    }

    fun setEmail(email: String) {
        viewModelScope.launch {
            _viewModelState.update {
                it.copy(email = email)
            }
        }
    }

    fun updateUserData(userName: String, dateOfBirth: String, phone: String, email: String) {
        viewModelScope.launch {
            user?.copy(
                user_name = userName,
                date_of_birth = dateOfBirth,
                phone = phone,
                email = email
            )?.let { userRes.updateUserData(it) }
        }
    }

    fun setAppLanguage(context: Context, languageCode: String) {
        Log.i("TAG", "setAppLanguage $languageCode")

        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
        if (context is Activity) {
            context.recreate()
        }
    }
}