package dev.hmyh.easymobile.mvp.presenters.impl

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import dev.hmyh.easymobile.data.models.EasyMobileModel
import dev.hmyh.easymobile.data.models.EasyMobileModelImpl
import dev.hmyh.easymobile.data.vos.PostVO
import dev.hmyh.easymobile.mvp.presenters.AbstractBasePresenter
import dev.hmyh.easymobile.mvp.presenters.HomeFragmentPresenter
import dev.hmyh.easymobile.mvp.views.HomeFragmentView

class HomeFragmentPresenterImpl: AbstractBasePresenter<HomeFragmentView>(),HomeFragmentPresenter {

    private val easyMobileModel: EasyMobileModel = EasyMobileModelImpl
    private val mEasyMobileLiveData: MutableLiveData<List<PostVO>> = MutableLiveData()

    override fun onUIReady(owner: LifecycleOwner) {
        super.onUiReady(owner)

        mEasyMobileLiveData.observe(owner, Observer {
            it.let {postList->
                if (postList.isEmpty()){
                    mView.showAllPostList(postList)
                }
            }
        })

        getAllPost(owner)
    }

    override fun onRefreshUI(owner: LifecycleOwner) {
        super.onRefreshUI(owner)

        getAllPost(owner,true)
    }

    private fun getAllPost(owner: LifecycleOwner,isFresh: Boolean = false) {
        easyMobileModel.getAllPosts(
            isRefresh = isFresh,
            onFailure = {
                Log.d("fail",it)
            },
            isLoading = {

            }
        ).observe(owner, Observer {
            mEasyMobileLiveData.postValue(it)
        })
    }

    override fun onTapCategoryFolder() {
        mView.navigateToCategoryListActivity()
    }
}