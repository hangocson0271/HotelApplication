package com.example.hotelapplication.ui.features.editprofile

import com.example.hotelapplication.base.BaseViewModel
import com.example.hotelapplication.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditProfileScreenViewModel @Inject constructor(userRepository: UserRepository) : BaseViewModel() {

}