package com.wss.eat_space_iz.ui.adapter.homeTab.recommended

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou.RecommendedForYouData
import com.wss.eat_space_iz.databinding.CustomRecommendedListItemLayoutBinding
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Layouts

class RecommendedAdapter(private val data : List<RecommendedForYouData>):
RecyclerView.Adapter<RecommendedAdapter.MyViewHolder>()
{

    private lateinit var binding :  CustomRecommendedListItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            Layouts.custom_recommended_list_item_layout,
            parent,
            false
        )
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val viewRecommendeData = data[position]
        with(binding){

            ivDish.load(viewRecommendeData.menuImg){
                placeholder(Drawables.ic_placeholder)
                error(Drawables.ic_placeholder)
            }
            tvDishName.text = viewRecommendeData.itemName
           // tvRestaurantAddress.text = viewRecommendeData.
            tvDishPrice.text = viewRecommendeData.price.toString()

        }
        }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(val binding: CustomRecommendedListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /*  init {
              binding.mcvCampaignHistory.setOnClickListener { v ->
                  onItemClickListener!!.onItemClick(absoluteAdapterPosition, v)
              }*/
    }
}