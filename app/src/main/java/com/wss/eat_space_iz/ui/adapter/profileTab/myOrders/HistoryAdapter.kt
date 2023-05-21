package com.wss.eat_space_iz.ui.adapter.profileTab.myOrders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllOrder.ViewAllOrderData
import com.wss.eat_space_iz.databinding.CustomMyOrderHistoryListItemLayoutBinding
import com.wss.eat_space_iz.utils.Layouts

class HistoryAdapter(private val data : List<ViewAllOrderData>):
RecyclerView.Adapter<HistoryAdapter.MyViewHolder>()
{

    private lateinit var binding : CustomMyOrderHistoryListItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            Layouts.custom_my_order_history_list_item_layout,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {}

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(val binding: CustomMyOrderHistoryListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /*  init {
              binding.mcvCampaignHistory.setOnClickListener { v ->
                  onItemClickListener!!.onItemClick(absoluteAdapterPosition, v)
              }*/
    }
}