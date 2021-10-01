package com.aaleksiev.core.models

sealed class UIState<T> {
    data class Loading<T>(val isLoading: Boolean = true) : UIState<T>()
    data class Error<T>(val errorMessage: String) : UIState<T>()
    data class Success<T>(val data: T) : UIState<T>()
}

fun <T> UIState<T>.updateUI(
    onLoading: (Boolean) -> Unit = {},
    onSuccess: (T) -> Unit = {},
    onError: (String) -> Unit = {}
) = when (this) {
    is UIState.Error -> onError(errorMessage)
    is UIState.Loading -> onLoading(isLoading)
    is UIState.Success -> onSuccess(data)
}