package dev.hmyh.easymobile.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import dev.hmyh.easymobile.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView>: BasePresenter<T>, ViewModel() {

    protected lateinit var mView: T

    override fun initPresenter(view: T) {
        mView=view
    }

    open fun onUiReady(owner : LifecycleOwner){

    }

    override fun onRefreshUI(owner: LifecycleOwner) {

    }

}