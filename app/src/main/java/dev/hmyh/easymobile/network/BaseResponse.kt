package dev.hmyh.easymobile.network

import com.google.gson.annotations.SerializedName

data class BaseResponse(

    @SerializedName("code")
    val code: Int = 0,

    @SerializedName("message")
    val message: String = ""
) {
    fun isResponseOk() = code == 200
}