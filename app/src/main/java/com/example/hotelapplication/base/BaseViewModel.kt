package com.example.hotelapplication.base

import androidx.lifecycle.ViewModel
import com.example.hotelapplication.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val loadingEvent by lazy { SingleLiveEvent<Boolean>() }
}