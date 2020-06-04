package dev.hmyh.easymobile.network

import com.google.gson.annotations.SerializedName

data class DataResponse<T>(
    @SerializedName("code") val code: Int = 200,
    @SerializedName("message") val message: String = "",
    @SerializedName("data") val data: T? = null
) {
    fun isResponseOk(): Boolean {
        return code == 200 && data != null
    }
}