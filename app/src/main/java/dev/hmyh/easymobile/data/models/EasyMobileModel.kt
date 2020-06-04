package dev.hmyh.easymobile.data.models

import androidx.lifecycle.LiveData
import dev.hmyh.easymobile.data.vos.PostVO

interface EasyMobileModel {

    fun loadAllPosts(onFailure: (message: String) -> Unit): LiveData<List<PostVO>>

    fun getAllPosts(isRefresh: Boolean,onFailure: (message: String) -> Unit,isLoading: (Boolean)->Unit): LiveData<List<PostVO>>
}