package dev.hmyh.easymobile.holder

import android.view.View
import com.bumptech.glide.Glide
import dev.hmyh.easymobile.data.vos.HomeCategoryVO
import dev.hmyh.easymobile.delegate.HomeCategoryListDelegate
import kotlinx.android.synthetic.main.view_holder_in_home.view.*

class HomeCategoryListViewHolder(itemView: View,val homeCategoryListDelegate: HomeCategoryListDelegate)
    : BaseRecyclerViewHolder<HomeCategoryVO>(itemView){

    init {
        setUpCategoryListTitleActivity()
    }

    private fun setUpCategoryListTitleActivity() {
        itemView.setOnClickListener {
            mData?.let {
                homeCategoryListDelegate.onTapCategoryFolder()
            }
        }
    }

    override fun bindData(data: HomeCategoryVO) {
        mData = data

        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivHomeTitle)
        itemView.tvHomeTitle.text = data.title
    }
}