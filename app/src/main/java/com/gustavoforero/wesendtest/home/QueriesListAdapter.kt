package com.gustavoforero.wesendtest.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gustavoforero.wesendtest.data.model.QueryBTC
import com.gustavoforero.wesendtest.databinding.ItemQueryBinding

class QueriesListAdapter : RecyclerView.Adapter<QueriesListAdapter.ItemViewHolder>() {

    private val mQueriesList = ArrayList<QueryBTC>()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ItemViewHolder {
        return ItemViewHolder.create(LayoutInflater.from(parent.context), parent)
    }

    override fun getItemCount(): Int = mQueriesList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(mQueriesList[position])
    }

    fun addData(list: List<QueryBTC>) {
        this.mQueriesList.clear()
        this.mQueriesList.addAll(list)
        notifyDataSetChanged()
    }

    class ItemViewHolder(private val itemBind: ItemQueryBinding) : RecyclerView.ViewHolder(itemBind.root) {

        fun onBind(query: QueryBTC) {
            itemBind.query = query
            itemBind.executePendingBindings()
        }

        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): ItemViewHolder {
                val itemMovieListBinding = ItemQueryBinding.inflate(inflater, parent, false)
                return ItemViewHolder(itemMovieListBinding)
            }
        }

    }
}