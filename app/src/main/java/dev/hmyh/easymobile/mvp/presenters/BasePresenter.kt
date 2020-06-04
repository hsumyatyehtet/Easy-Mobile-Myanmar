package dev.hmyh.easymobile.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import dev.hmyh.easymobile.mvp.views.BaseView

interface BasePresenter<V: BaseView> {

    fun onUIReady(owner: LifecycleOwner)
    fun initPresenter(view: V)
    fun onRefreshUI(owner: LifecycleOwner)
}