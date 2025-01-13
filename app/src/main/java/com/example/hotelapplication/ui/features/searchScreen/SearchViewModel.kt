package com.example.hotelapplication.ui.features.searchScreen

import androidx.lifecycle.MutableLiveData
import com.example.hotelapplication.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : BaseViewModel() {

    private val _resultSearch = MutableLiveData<Int?>()
    val resultSearch: MutableLiveData<Int?>
        get() = _resultSearch

    init {
        _resultSearch.postValue(100)
    }
}