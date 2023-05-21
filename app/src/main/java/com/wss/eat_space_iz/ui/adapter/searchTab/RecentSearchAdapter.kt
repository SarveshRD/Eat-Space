package com.wss.eat_space_iz.ui.adapter.searchTab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wss.eat_space_iz.data.networkModels.searchTab.trendingNearYou.TrendingNearYouData
import com.wss.eat_space_iz.databinding.CustomSearchForReviewItemLayoutBinding
import com.wss.eat_space_iz.utils.Layouts

class RecentSearchAdapter(private val data : List<TrendingNearYouData>):
    RecyclerView.Adapter<RecentSearchAdapter.MyViewHolder>()
{

    private lateinit var binding : CustomSearchForReviewItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            Layouts.custom_search_for_review_item_layout,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val viewTrendingData = data[position]
        with(binding){

            tvSearchSuggestion.text = viewTrendingData.itemName
            // tvRestaurantAddress.text = viewRecommendeData.
            //tvDishPrice.text = viewRecommendeData.price.toString()
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }


    class MyViewHolder(val binding:CustomSearchForReviewItemLayoutBinding ) :
        RecyclerView.ViewHolder(binding.root) {

        /*  init {
              binding.mcvCampaignHistory.setOnClickListener { v ->
                  onItemClickListener!!.onItemClick(absoluteAdapterPosition, v)
              }*/
    }


}