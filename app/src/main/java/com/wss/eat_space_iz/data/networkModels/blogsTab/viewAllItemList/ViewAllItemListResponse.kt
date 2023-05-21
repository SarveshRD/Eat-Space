package com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllItemList


import com.google.gson.annotations.SerializedName

data class ViewAllItemListResponse(
    @SerializedName("message")
    val data: List<String>,
    @SerializedName("status")
    val status: String
)