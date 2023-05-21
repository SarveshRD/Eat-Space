package com.wss.eat_space_iz.ui.adapter.profileTab.myOrders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllOrder.ViewAllOrderData
import com.wss.eat_space_iz.databinding.CustomOrderUpcomingListItemLayoutBinding
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Layouts

class UpcomingAdapter(private val data : List<ViewAllOrderData>):
RecyclerView.Adapter<UpcomingAdapter.MyViewHolder>()
{

    private lateinit var binding : CustomOrderUpcomingListItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            Layouts.custom_order_upcoming_list_item_layout,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val viewUpcomingData = data[position]
        with(binding){

            ivFood.load(viewUpcomingData.restaurantLogo){
                placeholder(Drawables.ic_placeholder)
                error(Drawables.ic_placeholder)
            }
            tvFoodItemCount.text = viewUpcomingData.itemTotal
            // tvRestaurantAddress.text = viewRecommendeData.
           // tvDishPrice.text = viewUpcomingData.price.toString()

        }



    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(val binding: CustomOrderUpcomingListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /*  init {
              binding.mcvCampaignHistory.setOnClickListener { v ->
                  onItemClickListener!!.onItemClick(absoluteAdapterPosition, v)
              }*/
    }
}