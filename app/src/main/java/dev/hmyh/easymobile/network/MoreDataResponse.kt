package dev.hmyh.easymobile.network

import com.google.gson.annotations.SerializedName
import dev.hmyh.easymobile.data.vos.MetaVO

data class MoreDataResponse<T>(
    @SerializedName("code")val code: Int =200,
    @SerializedName("message")val message: String="",
    @SerializedName("data")val data: T?=null,
    @SerializedName("meta")var meta: MetaVO?=null
) {
    fun isResponseOk(): Boolean{
        return code==200 && data!=null
    }
}