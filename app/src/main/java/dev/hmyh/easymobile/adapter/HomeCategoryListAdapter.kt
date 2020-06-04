package dev.hmyh.easymobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.hmyh.easymobile.R
import dev.hmyh.easymobile.data.vos.HomeCategoryVO
import dev.hmyh.easymobile.delegate.HomeCategoryListDelegate
import dev.hmyh.easymobile.holder.HomeCategoryListViewHolder

class HomeCategoryListAdapter(private val homeCategoryListDelegate: HomeCategoryListDelegate) :
    BaseRecyclerAdapter<HomeCategoryListViewHolder, HomeCategoryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_in_home,parent,false)
        return HomeCategoryListViewHolder(itemView,homeCategoryListDelegate)
    }

}