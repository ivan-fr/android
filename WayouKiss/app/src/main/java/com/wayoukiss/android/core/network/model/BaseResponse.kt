package com.wayoukiss.android.core.network.model

sealed class BaseResponse<out T> {
    data class Success<T>(val data: T) : BaseResponse<T>()
    data class Error(
        val code: String,
        val message: String,
        val detail: String? = null
    ) : BaseResponse<Nothing>()
}

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error(val exception: Exception) : NetworkResult<Nothing>()
    data object Loading : NetworkResult<Nothing>()
}
