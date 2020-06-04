package dev.hmyh.easymobile.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.hmyh.easymobile.R
import dev.hmyh.easymobile.adapter.HomeCategoryListAdapter
import dev.hmyh.easymobile.data.vos.PostVO
import dev.hmyh.easymobile.dummy.getCategoryList
import dev.hmyh.easymobile.mvp.presenters.HomeFragmentPresenter
import dev.hmyh.easymobile.mvp.presenters.impl.HomeFragmentPresenterImpl
import dev.hmyh.easymobile.mvp.views.HomeFragmentView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseFragment(),HomeFragmentView {

    private lateinit var mHomeCategoryListAdapter: HomeCategoryListAdapter
    private lateinit var mPresenter: HomeFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        onUIReady()
        setUpRecyclerView()

    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<HomeFragmentPresenterImpl,HomeFragmentView>()
    }

    private fun onUIReady() {
        mPresenter.onUIReady(this)
    }

    private fun setUpRecyclerView() {
        mHomeCategoryListAdapter = HomeCategoryListAdapter(mPresenter)
        with(rvHome){
            layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            adapter = mHomeCategoryListAdapter
        }

        mHomeCategoryListAdapter.setNewData(getCategoryList())
    }

    override fun showAllPostList(postList: List<PostVO>) {

    }

    override fun navigateToCategoryListActivity() {

    }
}