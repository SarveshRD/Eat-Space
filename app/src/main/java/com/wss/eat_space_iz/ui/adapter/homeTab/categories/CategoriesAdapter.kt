package com.wss.eat_space_iz.ui.adapter.homeTab.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wss.eat_space_iz.data.networkModels.homeTab.viewGlobalCategory.ViewGlobalCategoryData
import com.wss.eat_space_iz.databinding.CustomCategoriesListItemLayoutBinding
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Layouts

class CategoriesAdapter(private val data:List<ViewGlobalCategoryData>):
RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>()
{

    private lateinit var binding : CustomCategoriesListItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            Layouts.custom_categories_list_item_layout,
            parent,
            false
        )
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val viewCategoriesData = data[position]
        with(binding){
            ivPopularFood.load(viewCategoriesData.logo) {
                placeholder(Drawables.ic_placeholder)
                error(Drawables.ic_placeholder)
            }
            textView.text = viewCategoriesData.name
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }


    class MyViewHolder(val binding: CustomCategoriesListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /*  init {
              binding.mcvCampaignHistory.setOnClickListener { v ->
                  onItemClickListener!!.onItemClick(absoluteAdapterPosition, v)
              }*/
    }
}