package com.example.limoapp.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.limoapp.R
import com.example.limoapp.databinding.ItemViewBinding
import com.example.limoapp.domain.model.DataModel
import java.io.File

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
            //PATH
            val imagePath = "/sdcard/DCIM/Camera/IMG_20230326_212949.jpg" // Ubah sesuai dengan path atau alamat file gambar di perangkat Anda
            val file = File(imagePath)
            if (file.exists()) {
                val bitmap = BitmapFactory.decodeFile(file.absolutePath)
                binding.imgActivity.setImageBitmap(bitmap)
            } else {
                Toast.makeText(itemView.context, "File tidak di temukan", Toast.LENGTH_SHORT).show()
                // File tidak ditemukan
            }

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