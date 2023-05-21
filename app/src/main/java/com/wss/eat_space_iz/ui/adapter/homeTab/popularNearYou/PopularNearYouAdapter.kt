package com.wss.eat_space_iz.ui.adapter.homeTab.popularNearYou

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wss.eat_space_iz.data.networkModels.homeTab.viewPopularNearYou.ViewPopularNearYouData
import com.wss.eat_space_iz.data.networkModels.homeTab.viewPopularNearYou.ViewPopularNearYouResponse
import com.wss.eat_space_iz.databinding.CustomPopularNearYouListItemLayoutBinding
import com.wss.eat_space_iz.databinding.HomePopularNearYouBinding
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Layouts


class PopularNearYouAdapter(private val data : List<ViewPopularNearYouData>):
    RecyclerView.Adapter<PopularNearYouAdapter.MyViewHolder>()
{

    private lateinit var binding :  CustomPopularNearYouListItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            Layouts.custom_popular_near_you_list_item_layout,
            parent,
            false
        )
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val viewPopularNearYouData = data[position]
        with(binding){

            ivRestaurant.load(viewPopularNearYouData.logo){
                placeholder(Drawables.ic_placeholder)
                error(Drawables.ic_placeholder)
            }
            tvRestaurantName.text = viewPopularNearYouData.restaurantName
            tvRestaurantAddress.text = viewPopularNearYouData.area
            tvRestaurantRating.text = viewPopularNearYouData.rating
            //ivRestaurantDistance
            tvRestaurantDistance.text = viewPopularNearYouData.distance
            //ivRestaurantTime
            //tvRestaurantTime.text = viewPopularNearYouData


        }
    }

    override fun getItemCount(): Int {
        return data.size
    }



    class MyViewHolder(val binding: CustomPopularNearYouListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /*  init {
              binding.mcvCampaignHistory.setOnClickListener { v ->
                  onItemClickListener!!.onItemClick(absoluteAdapterPosition, v)
              }*/
    }
}