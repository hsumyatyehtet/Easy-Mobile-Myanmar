package dev.hmyh.easymobile.fragments

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import dev.hmyh.easymobile.mvp.presenters.AbstractBasePresenter
import dev.hmyh.easymobile.mvp.views.BaseView

abstract class BaseFragment: Fragment(),BaseView {

    inline fun <reified T : AbstractBasePresenter<W>, reified W : BaseView> getPresenter(): T {
        val presenter = ViewModelProviders.of(this).get(T::class.java)
        if (this is W) presenter.initPresenter(this)
        return presenter
    }
}