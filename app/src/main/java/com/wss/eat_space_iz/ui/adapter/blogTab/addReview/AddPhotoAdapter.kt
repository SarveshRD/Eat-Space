package com.wss.eat_space_iz.ui.adapter.blogTab.addReview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wss.eat_space_iz.data.localModels.AddPhotoDataModel
import com.wss.eat_space_iz.databinding.CustomAddPhotosLayoutBinding
import com.wss.eat_space_iz.ui.adapter.blogTab.myBlogs.MyBlogsAdapter
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Layouts

class AddPhotoAdapter(private val mAddPhotoList: ArrayList<AddPhotoDataModel>) :
    RecyclerView.Adapter<AddPhotoAdapter.MyViewHolder>() {

    companion object {
        private var onItemClickListener: OnItemClickListener? = null
    }

    private lateinit var binding: CustomAddPhotosLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            Layouts.custom_add_photos_layout,
            parent,
            false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val addPhotoData = mAddPhotoList[position]
        with(binding) {
            if (addPhotoData.isImageUrl) {
                ivPhoto.load(addPhotoData.imageUrl) {
                    placeholder(Drawables.ic_placeholder)
                    error(Drawables.ic_placeholder)
                }
            } else {
                ivPhoto.load(addPhotoData.addPhotoImg) {
                    placeholder(Drawables.ic_placeholder)
                    error(Drawables.ic_placeholder)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mAddPhotoList.size
    }


    class MyViewHolder(val binding: CustomAddPhotosLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.mcvAddPhoto.setOnClickListener { v ->
                onItemClickListener!!.onItemClick(absoluteAdapterPosition, v)
            }
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        AddPhotoAdapter.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, v: View)
        fun onItemCLickDelete(position: Int, v: View)
    }
}


