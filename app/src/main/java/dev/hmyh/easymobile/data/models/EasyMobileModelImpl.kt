package dev.hmyh.easymobile.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import dev.hmyh.easymobile.data.vos.PostVO
import dev.hmyh.easymobile.network.subscribeDBWithCompletable
import dev.hmyh.easymobile.network.subscribeDataResponse

object EasyMobileModelImpl: BaseModel(),EasyMobileModel {


    override fun loadAllPosts(onFailure: (message: String) -> Unit): LiveData<List<PostVO>> {

        val liveData = MutableLiveData<List<PostVO>>()

        easyMobileApi.getAllPosts().subscribeDataResponse(
            success = {
                liveData.postValue(it)
                saveAllPosts(it)
            },
            failure = {
                onFailure(it)
            }
        )
        return liveData
    }

    private fun saveAllPosts(postList: List<PostVO>) {
        database.postDao().saveAllPosts(postList).subscribeDBWithCompletable()
    }

    override fun getAllPosts(
        isRefresh: Boolean,
        onFailure: (message: String) -> Unit,
        isLoading: (Boolean) -> Unit
    ): LiveData<List<PostVO>> {

        val postCount: Int = database.postDao().getPostCount()

        if (postCount < 1 || isRefresh){
            isLoading(true)
            loadAllPosts(onFailure={
                onFailure(it)
            })
        }else{
            database.postDao().getAllPosts()
        }
        return Transformations.distinctUntilChanged(database.postDao().getAllPosts())
    }
}