package dev.hmyh.easymobile.mvp.presenters

import dev.hmyh.easymobile.delegate.HomeCategoryListDelegate
import dev.hmyh.easymobile.mvp.views.HomeFragmentView

interface HomeFragmentPresenter: BasePresenter<HomeFragmentView>,HomeCategoryListDelegate {
}