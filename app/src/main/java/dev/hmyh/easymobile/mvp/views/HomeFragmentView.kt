package dev.hmyh.easymobile.mvp.views

import dev.hmyh.easymobile.data.vos.PostVO

interface HomeFragmentView: BaseView {

    fun showAllPostList(postList: List<PostVO>)
    fun navigateToCategoryListActivity()
}