package dev.hmyh.easymobile.data.vos

import com.google.gson.annotations.SerializedName

class MetaVO {

    @SerializedName("current_page")
    val currentPage: Int = 0

    @SerializedName("total_page")
    val totalPages: Int = 0

    @SerializedName("next_page")
    val nextUrl: String=""

    @SerializedName("is_more")
    val isMore: Boolean = false
}