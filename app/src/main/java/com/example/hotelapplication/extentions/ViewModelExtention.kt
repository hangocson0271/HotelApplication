package com.example.hotelapplication.extentions

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavBackStackEntry

@Composable
internal inline fun <reified VM : ViewModel> hiltViewModel(viewModelStoreOwner: ViewModelStoreOwner? = null): VM =
    when (val currentOwner = viewModelStoreOwner ?: LocalViewModelStoreOwner.current) {
        is ComponentActivity, is Fragment -> viewModel<VM>(currentOwner)
        is NavBackStackEntry -> currentOwner.viewModel<VM>()
        else -> throw IllegalArgumentException("Unexpected $currentOwner")
    }

@Composable
private inline fun <reified VM : ViewModel> NavBackStackEntry.viewModel(): VM = viewModel<VM>(
    viewModelStoreOwner = this,
    factory = dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.createInternal(
        LocalContext.current.requireActivity(),
        this,
        arguments,
        viewModelFactory { }
    )
)

@JvmName("findActivityTyped")
inline fun <reified T : Activity> Context.findActivity() = asType<T>()

inline fun <reified T : Any> Context.asType(): T? {
    var context = this
    while (context is ContextWrapper) {
        if (context is T) return context
        context = context.baseContext
    }
    return null
}

inline fun <reified T : Activity> Context.requireActivity(): T =
    requireNotNull(findActivity<T>()) { "${T::class.simpleName} context is required" }