package dev.hmyh.easymobile.adapter

import androidx.recyclerview.widget.RecyclerView
import dev.hmyh.easymobile.holder.BaseRecyclerViewHolder

abstract class BaseRecyclerAdapter<T: BaseRecyclerViewHolder<W>,W>: RecyclerView.Adapter<T>() {

    protected var mData: ArrayList<W> = arrayListOf()

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setNewData(newData: List<W>) {
        if (newData.isEmpty()){
            mData.clear()
        }else{
            mData = ArrayList(newData)
        }
        notifyDataSetChanged()
    }

    fun appendData(newData: List<W>){
        if (newData.isEmpty()) return

        val statePosition = mData.size
        mData.addAll(newData)
        notifyItemRangeInserted(statePosition,newData.size)
    }

    fun getItemAt(position: Int): W?{
        return if (position < mData.size) mData[position] else null
    }

    fun getItems(): List<W> {
        return mData
    }

    fun removeData(data: W) {
        mData.remove(data)
        notifyDataSetChanged()
    }

    fun removeGently(data: W){
        val index = mData.indexOf(data)
        if (index == -1) return

        mData.remove(data)
        notifyItemRemoved(index)
        notifyItemRangeChanged(index,mData.size)
        notifyDataSetChanged()

    }

    fun addNewData(data: W) {
        mData.add(data)
        notifyDataSetChanged()
    }
}