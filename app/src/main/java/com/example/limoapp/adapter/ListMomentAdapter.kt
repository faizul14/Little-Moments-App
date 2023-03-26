package com.example.limoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.limoapp.R
import com.example.limoapp.databinding.ItemViewBinding
import com.example.limoapp.domain.model.DataModel

class ListMomentAdapter(): RecyclerView.Adapter<ListMomentAdapter.ViewHolder>() {
    private var listData = ArrayList<DataModel>()

    fun setData(newListData: List<DataModel>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }
    class ViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: DataModel){
            binding.apply {
                tvComment.setText(data.comment)
                tvJam.setText(data.time)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }
}